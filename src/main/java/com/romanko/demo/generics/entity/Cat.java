package com.romanko.demo.generics.entity;

import lombok.*;

@AllArgsConstructor
@Data
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
