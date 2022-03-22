package location.controller;

import location.Exception.CountryNotFoundException;
import location.model.Country;
import location.assembler.CountryModelAssembler;
import location.repository.CountryRepository;
import location.repository.CountryRepositoryCustom;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    private final CountryModelAssembler countryModelAssembler;

    public CountryController(CountryRepository countryRepository,
                             CountryModelAssembler countryModelAssembler
                             ) {
        this.countryRepository = countryRepository;
        this.countryModelAssembler = countryModelAssembler;
    }

  /*  @GetMapping("/countries")
    public CollectionModel<EntityModel<Country>> all() {
        List<EntityModel<Country>> countries = countryRepository
                .findAll()
                .stream()
                .map(countryModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(countries,
                linkTo(methodOn(CountryController.class)
                        .all())
                        .withSelfRel());
    }*/

    @GetMapping("/countries")
    public CollectionModel<EntityModel<Country>> findByNameContaining(@RequestParam String name) {
        List<EntityModel<Country>> countries = countryRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(countryModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(countries,
                linkTo(methodOn(CountryController.class)
                        .findByNameContaining(name))
                        .withSelfRel());
    }

    @GetMapping("/countries/{id}")
    public EntityModel<Country> one(@PathVariable Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));

        return countryModelAssembler.toModel(country);
    }

}
