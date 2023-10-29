package com.romanko.demo.generics.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Cat implements Animal, Identifiable {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @Override
    public String species() {
        return "Cat";
    }

    @Override
    public void voice() {
        System.out.println("Meow!");
    }
}
