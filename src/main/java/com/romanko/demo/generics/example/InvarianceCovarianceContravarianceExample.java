package com.romanko.demo.generics.example;

import com.romanko.demo.generics.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2.3 Invariance, covariance, contravariance
 * */
public class InvarianceCovarianceContravarianceExample {

    public static void main(String[] args) {

        //Arrays Covariance
        Cat[] cats = {new Cat(null, "Tom"), new Cat(null, "Felix")};
        Dog[] dogs = {new Dog(null, "Mike", "Buldog"), new Dog(null, "Toto", "n/a")};
        Animal[] animals = cats;
        animals = dogs;
        animals = new Animal[]{new Cat(null, "Tom"), new Dog(null, "Mike", "Buldog")};

        System.out.println("animals: " + Arrays.toString(animals) + "\n");

        //Collections Invariance
        List<Cat> catsList = Arrays.asList(new Cat(null, "Tom"), new Cat(null, "Felix"));
        List<Dog> dogsList = Arrays.asList(new Dog(null, "Mike", "Buldog"), new Dog(null, "Toto", "n/a"));

//        List<Animal> animalsList = catsList; //Ooops it doesn't work due to the invariance

        //Collections Covariance
        List<? extends Animal> covariantAnimalList = catsList;
        covariantAnimalList = dogsList;
        covariantAnimalList = new ArrayList<>(Arrays.asList(new Cat(null, "Tom"), new Dog(null, "Mike", "Buldog")));

//        covariantAnimalList.add(new Cat(null, "Tom")); //We can assign but can't add due to upper wildcard constraints
        covariantAnimalList.add(null); // But null is null

        System.out.println("covariantAnimalList: " + covariantAnimalList + "\n");

        //Collections Contravariance
        List<Chicken> chickens = Arrays.asList(new Chicken(), new Chicken(), new Chicken());
        List<Rooster> roosters = Collections.singletonList(new Rooster());
        List<? super Chicken> contravarianceChicken = chickens;
//        contravarianceChicken = roosters; //Ooops to roosters entrance is closed
        List<Animal> animalsList = Arrays.asList(new Chicken(), new Chicken(), new Rooster());
        contravarianceChicken = new ArrayList<>(animalsList); //but rooster still can penetrate here disguised as Animal
        contravarianceChicken.add(new Rooster()); //and can even be inserted with add method
//        contravarianceChicken.add(new Cat(null, "Tom")); //but cat cannot penetrate

//        Chicken chicken = contravarianceChicken.get(0); //but obtaining the object of Chicken type is not allowed
        Object chickenObject = contravarianceChicken.get(0); //only Object can be retrieved

        contravarianceChicken.forEach(o -> {
            System.out.println("It's supposed to be a chicken but I don't exactly know: " + o.getClass().getSimpleName()); //Take notice we don't have Chicken methods here
        });

        System.out.println("\ncontravarianceChicken: " + contravarianceChicken);

        List<? super Rooster> contravarianceRoosters = new ArrayList<>(chickens); //We can assign chickens array

        contravarianceRoosters.add(new Rooster());
//        contravarianceRoosters.add(new Chicken()); //But can't add a chicken with add

        contravarianceRoosters.forEach(rooster -> {
            System.out.println("Is that " + rooster.getClass().getSimpleName() + " actually a rooster? " + (!rooster.getClass().equals(Rooster.class) ? "I doubt it." : "Yes it is!")); //Now the lack of methods makes sense. The list can possibly contain chickens.
        });
    }
}
