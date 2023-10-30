package com.romanko.demo.generics.entity;

import lombok.*;

@AllArgsConstructor
@Data
public class Dog implements Animal, Identifiable {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String breed;

    @Override
    public String species() {
        return "Dog";
    }

    @Override
    public void voice() {
        System.out.println("Woof!!");
    }
}
