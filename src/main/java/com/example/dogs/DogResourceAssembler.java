package com.example.dogs;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class DogResourceAssembler implements ResourceAssembler<Dogs, Resource<Dogs>> {
    @Override
    public Resource<Dogs> toResource(Dogs dogs) {
        return new Resource<Dogs>(dogs,
                linkTo(methodOn(DogController.class).all()).withRel("dogs"));
    }
}
