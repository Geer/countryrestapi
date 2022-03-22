package location.controller;

import location.Exception.CountryNotFoundException;
import location.Exception.TownNotFoundException;
import location.assembler.CityModelAssembler;
import location.assembler.TownModelAssembler;
import location.model.City;
import location.model.Town;
import location.repository.CityRepository;
import location.repository.TownRepository;
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
public class TownController {

    private final TownRepository townRepository;

    private final TownModelAssembler townModelAssembler;

    public TownController(TownRepository townRepository,
                          TownModelAssembler townModelAssembler) {
        this.townRepository = townRepository;
        this.townModelAssembler = townModelAssembler;
    }

    @GetMapping("/towns")
    public CollectionModel<EntityModel<Town>> all() {
        List<EntityModel<Town>> towns = townRepository
                .findAll()
                .stream()
                .map(townModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(towns,
                linkTo(methodOn(TownController.class)
                        .all())
                        .withSelfRel());
    }

    @GetMapping("/town/{id}")
    public EntityModel<Town> one(@PathVariable Long id) {
        Town town = townRepository.findById(id)
                .orElseThrow(() -> new TownNotFoundException(id));

        return townModelAssembler.toModel(town);
    }

}
