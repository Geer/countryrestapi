package location.controller;

import location.Exception.CityNotFoundException;
import location.assembler.CityModelAssembler;
import location.model.City;
import location.repository.CityRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CityController {

    private final CityRepository cityRepository;

    private final CityModelAssembler cityModelAssembler;

    public CityController(CityRepository cityRepository,
                             CityModelAssembler cityModelAssembler) {
        this.cityRepository = cityRepository;
        this.cityModelAssembler = cityModelAssembler;
    }

    @GetMapping("/cities")
    public CollectionModel<EntityModel<City>> all() {
        List<EntityModel<City>> cities = cityRepository
                .findAll()
                .stream()
                .map(cityModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(cities,
                linkTo(methodOn(CityController.class)
                        .all())
                        .withSelfRel());
    }

    @GetMapping("/cities/{id}")
    public EntityModel<City> one(@PathVariable Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        return cityModelAssembler.toModel(city);
    }

}
