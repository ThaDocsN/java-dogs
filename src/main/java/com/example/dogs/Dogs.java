package com.example.dogs;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data // creates getters, setters, toString
@Entity // object ready JPA storage
public class Dogs {
    private @Id
    @GeneratedValue Long id; // primary key automatically populated

    private String name;
    private double weight;
    private boolean isHouseBroken;

    public Dogs() {
    }

    public Dogs(String name, double weight, boolean isHouseBroken) {
        this.name = name;
        this.weight = weight;
        this.isHouseBroken = isHouseBroken;
    }
}
