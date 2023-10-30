package com.romanko.demo.generics.example;

import java.util.Arrays;
import java.util.List;

public class HeapPollutionExample {

    public static void main(String[] args) {
        consumeArgs(Arrays.asList("2", "3"), Arrays.asList("4", "5"));
    }

    @SafeVarargs    //Just to disable compiler warning
    public static void consumeArgs(List<String>... stringList) {

        Object[] array = stringList;

        array[0] = Arrays.asList(2, 3);

        String s = stringList[0].get(0); //Class cast exception
    }

}
