package location.assembler;

import location.controller.CountryController;
import location.controller.StateController;
import location.model.Country;
import location.model.State;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StateModelAssembler implements RepresentationModelAssembler<State, EntityModel<State>> {

    @Override
    public EntityModel<State> toModel(State state) {
        return EntityModel.of(state,
                linkTo(methodOn(StateController.class)
                        .one(state.getId()))
                        .withSelfRel(),
                linkTo(methodOn(StateController.class)
                        .all())
                        .withRel("states"));
    }
}