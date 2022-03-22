package location.assembler;

import location.controller.CityController;
import location.model.City;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CityModelAssembler implements RepresentationModelAssembler<City, EntityModel<City>> {

    @Override
    public EntityModel<City> toModel(City city) {
        return EntityModel.of(city,
                linkTo(methodOn(CityController.class)
                        .one(city.getId()))
                        .withSelfRel(),
                linkTo(methodOn(CityController.class)
                        .all())
                        .withRel("cities"));
    }
}