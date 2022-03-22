package location.repository;

import location.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


    List<Location> findByNameContainingIgnoreCase(String name);

    /*List<Country> findAllCountries();

    List<State> findAllStates();

    List<County> findAllCounties();

    List<City> findAllCities();

    List<Town> findAllTowns();*/
}
