package com.romanko.demo.generics.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AnimalShelterTest {

    private List<Cat> cats;

    private List<Dog> dogs;

    private AnimalShelter shelter;

    @Before
    public void setUp() {
        shelter = new AnimalShelter();

        cats = Arrays.asList(new Cat(null, "Tom"), new Cat(null, "Garfild"), new Cat(null, "Kitty"));
        dogs = Arrays.asList(new Dog(null, "Mike", "Buldog"), new Dog(null, "Toto", "n/a"), new Dog(null, "Buddy", "Bull Terrier"));

    }

    @Test
    public void addCat_shouldAddToEnclosure() {
        Cat cat = new Cat(null, "Felix");

        shelter.addCat(cat);

        assertTrue(shelter.getCats().getAnimals().contains(cat));
    }

    @Test
    public void addCat_shouldSetId() {
        Cat cat = new Cat(null, "Felix");

        shelter.addCat(cat);

        assertNotNull(cat.getId());
    }

    @Test
    public void removeCat_shouldRemoveFromEnclosure() {
        cats.forEach(shelter::addCat);

        Cat catToBeRemoved = cats.get(0);

        boolean removed = shelter.removeCat(catToBeRemoved);

        assertTrue(removed);
        assertTrue(shelter.getCats().getAnimals().size() < cats.size());
    }

    @Test
    public void findCatByName_shouldFindById() {
        cats.forEach(shelter::addCat);
        Cat expected = new Cat(null, "Felix");

        shelter.addCat(expected);
        Cat actual = shelter.findCatById(expected.getId());

        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    public void findCatByName_shouldFindByName() {
        cats.forEach(shelter::addCat);

        Cat tom = shelter.findCatByName("Tom");

        assertEquals("Tom", tom.getName());
    }

    @Test
    public void addDog_shouldAddToEnclosure() {
        Dog dog = new Dog(null, "Ice", "Rottweiler");

        shelter.addDog(dog);

        assertTrue(shelter.getDogs().getAnimals().contains(dog));
    }

    @Test
    public void addDog_shouldSetId() {
        Dog dog = new Dog(null, "Ice", "Rottweiler");

        shelter.addDog(dog);

        assertNotNull(dog.getId());
    }

    @Test
    public void removeDog_shouldRemoveFromEnclosure() {
        dogs.forEach(shelter::addDog);

        Dog dogToBeRemoved = dogs.get(0);

        boolean removed = shelter.removeDog(dogToBeRemoved);

        assertTrue(removed);
        assertTrue(shelter.getDogs().getAnimals().size() < dogs.size());
    }

    @Test
    public void findDogByName_shouldFindById() {
        dogs.forEach(shelter::addDog);
        Dog expected = new Dog(null, "Ice", "Rottweiler");

        shelter.addDog(expected);
        Dog actual = shelter.findDogById(expected.getId());

        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    public void findDogByName_shouldFindByName() {
        dogs.forEach(shelter::addDog);

        Dog mike = shelter.findDogByName("Mike");

        assertEquals("Mike", mike.getName());
    }
}