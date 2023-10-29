package com.romanko.demo.generics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The shelter consists of enclosures and can contain several species inside different enclosures.
 * */
@Getter
@Setter
public class AnimalShelter {

    //Why do we use wildcard here? Why don't we just go with T parameter?
    private AnimalEnclosure<? extends Cat> cats;

    private AnimalEnclosure<? super Dog> dogs;

    public AnimalShelter() {
        cats = new AnimalEnclosure<>();
        dogs = new AnimalEnclosure<>();
    }

    public <T extends Cat> void addCat(T cat) {
        // Why do we add the new cat like this?
        // Why don't we just use addAnimal method?
//         cats.addAnimal(cat);
        List<? extends Cat> listOfCats = Stream.of(Collections.singletonList(cat), cats.getAnimals())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        cats.setAnimals((List)listOfCats); //Why do we use raw types here? Is that safe?
    }

    public <T extends Cat> boolean removeCat(T cat) {
        return cats.removeAnimal(cat);    //Pay attention removeAnimal takes Object to get it to work fine
    }

    public Cat findCatById(Long id) {
        return cats.getAnimals().stream()
                .filter(cat -> cat.getId().equals(id))
                .findAny().orElse(null);
    }

    public Cat findCatByName(String name) {
        return cats.getAnimals().stream()
                .filter(cat -> cat.getName().equals(name))
                .findAny().orElse(null);
    }

    public <T extends Dog> void addDog(T dog) {
        dogs.addAnimal(dog);    //Why does addAnimal work fine here?
    }

    public <T extends Dog> boolean removeDog(T dog) {
        return dogs.removeAnimal(dog);
    }

    public Dog findDogByName(String name) {
        return dogs.getAnimals().stream()
                .map(animal -> (Dog) animal) //Why do we need an extra type cast here?
                .filter(dog -> dog.getName().equals(name))
                .findAny().orElse(null);
    }

    public Dog findDogById(Long id) {
        return dogs.getAnimals().stream()
                .map(animal -> (Dog) animal)
                .filter(dog -> dog.getId().equals(id))
                .findAny().orElse(null);
    }
}