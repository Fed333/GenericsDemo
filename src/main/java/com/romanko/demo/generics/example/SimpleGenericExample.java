package com.romanko.demo.generics.example;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.1 What generics are and why we need them.
 */
public class SimpleGenericExample {


    public static void main(String[] args) {

    }

    public static <T> void print(T object) {
        System.out.println(object);
    }

    public <T> List<T> singletonList(T item) {
        List<T> list = new ArrayList<>();
        list.add(item);
        return list;
    }

    public Double mapStringToDouble(String digit) {
        Mapper<String, Double> mapper = new StringToDoubleMapper();

        return mapper.map(digit);
    }

}

interface Mapper<T, R> {

    R map(T t);

}

class StringToDoubleMapper implements Mapper<String, Double> {
    @Override
    public Double map(String digit) {
        return Double.parseDouble(digit);
    }
}
