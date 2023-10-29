package com.romanko.demo.generics.example;

public class GenericVsNoGenericComparison {

    public static class Generic {
        public static <T extends Comparable<T>> T max(T obj1, T obj2) {
            return obj1.compareTo(obj2) > 0 ? obj1 : obj2;
        }
    }

    public static class NoGeneric {
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
