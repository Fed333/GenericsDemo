package com.romanko.demo.generics.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.1 What generics are and why we need them.
 */
public class SimpleGenericExample {

    public static <T> void print(T object) {
        System.out.println(object);
    }

    public <T> List<T> singletonList(T item) {
        List<T> list = new ArrayList<>();
        list.add(item);
        return list;
    }
}

