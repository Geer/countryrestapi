package location.assembler;

import location.controller.TownController;
import location.model.Town;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TownModelAssembler implements RepresentationModelAssembler<Town, EntityModel<Town>> {

    @Override
    public EntityModel<Town> toModel(Town town) {
        return EntityModel.of(town,
                linkTo(methodOn(TownController.class)
                        .one(town.getId()))
                        .withSelfRel(),
                linkTo(methodOn(TownController.class)
                        .all())
                        .withRel("towns"));
    }
}