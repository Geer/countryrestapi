package location;

import location.model.*;
import location.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            /*EmployeeRepository employeeRepository,
            OrderRepository orderRepository,*/
            CountryRepository countryRepository,
            StateRepository stateRepository,
            CountyRepository countyRepository,
            CityRepository cityRepository,
            TownRepository townRepository) {
        return args -> {
            log.info("Starting pre loading Countries");

            Country country = new Country("ARGENTINA");

            countryRepository.save((new Country("AFGANISTAN")));
            countryRepository.save((new Country("ALBANIA")));
            countryRepository.save((new Country("ALEMANIA")));
            countryRepository.save((new Country("ANDORRA")));
            countryRepository.save((new Country("ANGOLA")));
            countryRepository.save((new Country("ANTIGUA Y BARBUDA")));
            countryRepository.save((new Country("ARABIA SAUDI")));
            countryRepository.save((new Country("ARGELIA")));
            countryRepository.save(country);
            countryRepository.save((new Country("ARMENIA")));
            countryRepository.save((new Country("ARUBA")));
            countryRepository.save((new Country("AUSTRALIA")));
            countryRepository.save((new Country("AUSTRIA")));
            countryRepository.save((new Country("AZERBAIYAN")));

            countryRepository.findAll().forEach(aCountry -> {
                log.info("Preloaded " +  aCountry);
            });

            State state = new State("Buenos Aires", country);

            log.info("Starting pre loading States");
            stateRepository.save(new State("Ciudad Autonoma de Buenos Aires", country));
            stateRepository.save(state);
            stateRepository.save(new State("Catamarca", country));
            stateRepository.save(new State("Chaco", country));
            stateRepository.save(new State("Chubut", country));
            stateRepository.save(new State("Cordoba", country));
            stateRepository.save(new State("Corrientes", country));
            stateRepository.save(new State("Entre Rios", country));
            stateRepository.save(new State("Formosa", country));
            stateRepository.save(new State("Jujuy", country));
            stateRepository.save(new State("La Pampa", country));
            stateRepository.save(new State("La Rioja", country));
            stateRepository.save(new State("Mendoza", country));
            stateRepository.save(new State("Misiones", country));
            stateRepository.save(new State("Neuquen", country));
            stateRepository.save(new State("Rio Negro", country));
            stateRepository.save(new State("Salta", country));
            stateRepository.save(new State("San Juan", country));
            stateRepository.save(new State("San Luis", country));
            stateRepository.save(new State("Santa Cruz", country));
            stateRepository.save(new State("Santa Fe", country));
            stateRepository.save(new State("Santiago del Estero", country));
            stateRepository.save(new State("Tierra del Fuego", country));
            stateRepository.save(new State("Tucuman", country));

            stateRepository.findAll().forEach(aState -> {
                log.info("Preloaded " +  aState);
            });

            County county = new County("25 de Mayo", state);
            log.info("Starting pre loading Counties");

            countyRepository.save(county);
            countyRepository.save(new County("9 de Julio", state));
            countyRepository.save(new County("12 de Octubre", state));

            countyRepository.findAll().forEach(aCounty -> {
                log.info("Preloaded " +  aCounty);
            });


            City city = new City("25 de Mayo", county);
            log.info("Starting pre loading Cities");

            cityRepository.save(city);

            cityRepository.findAll().forEach(aCity -> {
                log.info("Preloaded " +  aCity);
            });

            Town town = new Town("25 de Mayo", city);
            log.info("Starting pre loading Cities");

            townRepository.save(town);

            townRepository.findAll().forEach(aTown -> {
                log.info("Preloaded " +  aTown);
            });



/*

            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo",  "Baggins", "thief"));

            employeeRepository.findAll().forEach(employee -> {
                log.info("Preloaded " + employee);
            });

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " +  order);
            });

*/
        };
    }
}
