package com.example.dogs;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    private final DogRepository repo;
    private final DogResourceAssembler assembler;

    public DogController(DogRepository repo, DogResourceAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }
}
