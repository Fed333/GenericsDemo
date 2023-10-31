package com.romanko.demo.collections.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArraysVsListsExampleTest {

    @Test
    public void addToArray() {
        int[] source = {1, 2, 3};
        int[] expected = {1, 2, 3, 4};

        int[] actual = ArraysVsListsExample.addToArray(source, 4);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addToList() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        List<Integer> actual = ArraysVsListsExample.addToList(source, 4);

        assertEquals(expected, actual);
    }

    @Test
    public void removeFromArrayByIndex() {
        int[] source = {1, 2, 3, 4};
        int indexToRemove = 2;
        int[] expected = {1, 2, 4};

        int[] actual = ArraysVsListsExample.removeFromArrayByIndex(source, indexToRemove);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeFromListByIndex() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int indexToRemove = 2;
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 4));

        List<Integer> actual = ArraysVsListsExample.removeFromListByIndex(source, indexToRemove);

        assertEquals(expected, actual);
    }
}