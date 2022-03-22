package location.assembler;

import location.controller.CountyController;
import location.model.County;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountyModelAssembler implements RepresentationModelAssembler<County, EntityModel<County>> {

    @Override
    public EntityModel<County> toModel(County county) {
        return EntityModel.of(county,
                linkTo(methodOn(CountyController.class)
                        .one(county.getId()))
                        .withSelfRel(),
                linkTo(methodOn(CountyController.class)
                        .all())
                        .withRel("counties"));
    }
}