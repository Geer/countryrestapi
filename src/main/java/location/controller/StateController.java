package location.controller;

import location.Exception.StateNotFoundException;
import location.assembler.StateModelAssembler;
import location.model.State;
import location.repository.StateRepository;
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
public class StateController {

    private final StateRepository stateRepository;

    private final StateModelAssembler stateModelAssembler;

    public StateController(StateRepository countryRepository,
                           StateModelAssembler countryModelAssembler) {
        this.stateRepository = countryRepository;
        this.stateModelAssembler = countryModelAssembler;
    }

    @GetMapping("/states")
    public CollectionModel<EntityModel<State>> all() {
        List<EntityModel<State>> states = stateRepository
                .findAll()
                .stream()
                .map(stateModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(states,
                linkTo(methodOn(StateController.class)
                        .all())
                        .withSelfRel());
    }

    @GetMapping("/states/{id}")
    public EntityModel<State> one(@PathVariable Long id) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new StateNotFoundException(id));

        return stateModelAssembler.toModel(state);
    }

}
