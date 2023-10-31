package com.romanko.demo.collections.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionSetOperationsExample {

    public static List<Integer> removeAll(List<Integer> list1, List<Integer> list2) {
        boolean b = list1.removeAll(list2);
        return list1;
    }

    public static List<Integer> addAll(List<Integer> list1, List<Integer> list2) {
        boolean b = list1.addAll(list2);
        return list1;
    }

    public static List<Integer> retainAll(List<Integer> list1, List<Integer> list2) {
        boolean b = list1.retainAll(list2);
        return list1;
    }


}
