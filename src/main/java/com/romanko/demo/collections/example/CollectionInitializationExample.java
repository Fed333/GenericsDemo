package com.romanko.demo.collections.example;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.4
 * */
public class CollectionInitializationExample {

    public static void main(String[] args) {

    }

    public static class ListInitializationExample {
        public static List<Integer> simpleInitialization() {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            return list;
        }

        public static List<Integer> arraysAsList() {
            List<Integer> list = Arrays.asList(1, 2, 3);
            return list;
        }

        public static List<Integer> wrappedArraysAsList() {
            List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3)); //Why do we need such wrapping?
            return list;
        }

        public static List<Integer> singletonList() {
            return Collections.singletonList(1);
        }

        public static List<Integer> streamOf() {
            return Stream.of(1, 2, 3).collect(Collectors.toList());
        }

        public static List<Integer> unmodifiableList() {
            List<Integer> list = simpleInitialization();
            List<Integer> immutableList = Collections.unmodifiableList(list); //The list will be completely immutable, but it doesn't prevent us from hand references
//            immutableList.add(4); // this will fail
//            list.add(4);          // but this will work
            return immutableList;
        }
    }

    public static class MapInitializationExample {
        public static Map<String, Integer> simpleInitialization() {
            Map<String, Integer> map = new HashMap<>();
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
            return map;
        }

        public static Map<String, Integer> streamInitialization() {
            Map<String, Integer> map = Stream.of(
                    new AbstractMap.SimpleImmutableEntry<>("one", 1),
                    new AbstractMap.SimpleImmutableEntry<>("two", 2),
                    new AbstractMap.SimpleImmutableEntry<>("two", 3)
            ).collect(Collectors.toMap(AbstractMap.SimpleImmutableEntry::getKey, AbstractMap.SimpleImmutableEntry::getValue));
            return map;
        }

        public static Map<String, Integer> mapOf() {
            return Map.of(                             // Pay attention the created map is unmodifiable
                    "one", 1,
                    "two", 2,
                    "three", 3
            );
        }
    }

}
