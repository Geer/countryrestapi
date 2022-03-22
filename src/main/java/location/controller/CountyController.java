package location.controller;

import location.Exception.CountryNotFoundException;
import location.Exception.CountyNotFoundException;
import location.assembler.CountyModelAssembler;
import location.model.Country;
import location.model.County;
import location.repository.CountyRepository;
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
public class CountyController {

    CountyModelAssembler countyModelAssembler;

    CountyRepository countyRepository;

    public CountyController(CountyModelAssembler countyModelAssembler, CountyRepository countyRepository) {
        this.countyModelAssembler = countyModelAssembler;
        this.countyRepository = countyRepository;
    }

    @GetMapping("/counties")
    public CollectionModel<EntityModel<County>> all() {
        List<EntityModel<County>> counties = countyRepository
                .findAll()
                .stream()
                .map(countyModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(counties,
                linkTo(methodOn(CountyController.class)
                        .all())
                        .withSelfRel());
    }

    @GetMapping("/counties/{id}")
    public EntityModel<County> one(@PathVariable Long id) {
        County county = countyRepository.findById(id)
                .orElseThrow(() -> new CountyNotFoundException(id));

        return countyModelAssembler.toModel(county);
    }
}
