package com.example.dogs;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class DogController {

    private final DogRepository repo;
    private final DogResourceAssembler assembler;

    public DogController(DogRepository repo, DogResourceAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }

    @GetMapping("/dogs")
    public org.springframework.hateoas.Resources<Resource<Dogs>> all(){
        List<Resource<Dogs>> list = repo.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(list, linkTo(methodOn(DogController.class).all()).withSelfRel());

    }
}
