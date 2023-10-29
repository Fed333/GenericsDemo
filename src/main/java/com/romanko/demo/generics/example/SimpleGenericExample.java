package com.romanko.demo.generics.example;

import java.util.ArrayList;
import java.util.List;

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

