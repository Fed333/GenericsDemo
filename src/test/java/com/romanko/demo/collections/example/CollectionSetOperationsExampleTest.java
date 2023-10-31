package com.romanko.demo.collections.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 1.4
 * */
public class CollectionSetOperationsExampleTest {

    @Test
    public void removeAll() {
        List<Integer> sourceList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> elementsToRemove = new ArrayList<>(Arrays.asList(4, 5));
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3));

        CollectionSetOperationsExample.removeAll(sourceList, elementsToRemove);

        assertEquals(expectedList, sourceList);
    }

    @Test
    public void addAll() {
        List<Integer> sourceList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> elementsToAdd = new ArrayList<>(Arrays.asList(4, 5));
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        CollectionSetOperationsExample.addAll(sourceList, elementsToAdd);

        assertEquals(expectedList, sourceList);
    }

    @Test
    public void retainAll() {
        List<Integer> sourceList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> elementsToRetain = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(2, 3));

        CollectionSetOperationsExample.retainAll(sourceList, elementsToRetain);

        assertEquals(expectedList, sourceList);
    }
}