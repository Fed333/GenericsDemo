package com.romanko.demo.generics.entity;

public class Chicken implements Animal {
    @Override
    public String species() {
        return "Chicken";
    }

    @Override
    public void voice() {
        System.out.println("bok-bok");
    }
}
