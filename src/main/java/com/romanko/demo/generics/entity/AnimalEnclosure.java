package com.romanko.demo.generics.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 2.2 Generics syntax.
 * The enclosure is only to contain only the same species.
 * For instance only cats or only dogs not them together.
 * */
@Getter
public class AnimalEnclosure<T extends Animal & Identifiable> { // What's the purpose of using & operator here?

    private Long idNumber = 1L;

    private List<T> animals;

    public AnimalEnclosure() {
        animals = new ArrayList<>();
    }

    public void setAnimals(List<T> animals) {
        this.animals = animals;
        this.animals.stream()
                .filter(a -> Objects.isNull(a.getId())) //Take notice here we're using method from Identifiable
                .forEach(this::assignId);
    }

    public void addAnimal(T animal) {
        assignId(animal);
        animals.add(animal);
    }

    private void assignId(T animal) {
        animal.setId(idNumber++);
    }

    public boolean removeAnimal(Object animal) {
        return animals.remove(animal);
    }

    public List<Animal> findBySpecies(String species) {
        return animals.stream()
                .filter(a -> Objects.equals(a.species(), species)) //Take notice here we're using method from Animal
                .collect(Collectors.toList());
    }
}