package com.romanko.demo.generics.example;

import lombok.SneakyThrows;

/**
 * 2.1 What generics are and why we need them.
 * */
public class GenericVsNoGenericComparison {

    public static class Generic {

        @SneakyThrows
        public static <T> T createObject(Class<T> clazz) {
            return clazz.getDeclaredConstructor().newInstance();
        }

        public static <T extends Comparable<T>> T max(T obj1, T obj2) {
            return obj1.compareTo(obj2) > 0 ? obj1 : obj2;
        }
    }

    public static class NoGeneric {

        @SneakyThrows
        public static Object createObject(Class clazz) {
            return clazz.getDeclaredConstructor().newInstance();
        }

        public static int max(int number1, int number2) {
            return number1 > number2 ? number1 : number2;
        }

        public static long max(long number1, long number2) {
            return number1 > number2 ? number1 : number2;
        }

        public static double max(double number1, double number2) {
            return number1 > number2 ? number1 : number2;
        }
        //float, short, byte...
    }
}
