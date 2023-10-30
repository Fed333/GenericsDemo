package com.romanko.demo.generics.examples;

import com.romanko.demo.generics.entity.Chicken;
import com.romanko.demo.generics.example.GenericVsNoGenericComparison;
import org.junit.Assert;
import org.junit.Test;

/**
 * 2.1 What generics are and why we need them.
 * */
public class GenericVsNoGenericComparisonTest {

    @Test
    public void max_genericCompareTwoIntegers() {
        Integer expected = 3;
        Integer actual = GenericVsNoGenericComparison.Generic.max(2, 3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void max_genericCompareTwoLongs() {
        Long expected = 3L;
        Long actual = GenericVsNoGenericComparison.Generic.max(2L, 3L);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void max_noGenericCompareTwoDouble() {
        Double expected = 3.7;
        Double actual = GenericVsNoGenericComparison.NoGeneric.max(2.3, 3.7);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void max_noGenericCompareTwoIntegers() {
        Integer expected = 3;
        Integer actual = GenericVsNoGenericComparison.NoGeneric.max(2, 3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void max_noGenericCompareTwoLongs() {
        Long expected = 3L;
        Long actual = GenericVsNoGenericComparison.NoGeneric.max(2L, 3L);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void max_genericCompareTwoDouble() {
        Double expected = 3.7;
        Double actual = GenericVsNoGenericComparison.Generic.max(2.3, 3.7);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createObject_generic() {
        Chicken chicken = GenericVsNoGenericComparison.Generic.createObject(Chicken.class); //It's more convenient, don't have to cast
        Assert.assertNotNull(chicken);
    }

    @Test
    public void createObject_noGeneric() {
        Chicken chicken = (Chicken) GenericVsNoGenericComparison.NoGeneric.createObject(Chicken.class); //It seems slight awkward, have to cast
        Assert.assertNotNull(chicken);
    }

}