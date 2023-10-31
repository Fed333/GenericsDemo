package com.romanko.demo.collections.example;

import java.util.Arrays;
import java.util.List;

/**
 * 1.2 Arrays limitations
 * */
public class ArraysVsListsExample {

   public static int[] addToArray(int[] arr, int element) {
      int[] newArr = Arrays.copyOf(arr, arr.length + 1);
      newArr[arr.length] = element;
      return newArr;
   }

   public static int[] removeFromArrayByIndex(int[] arr, int index) {
      int[] subArr1 = Arrays.copyOfRange(arr, 0, index);
      int[] subArr2 = Arrays.copyOfRange(arr, index + 1, arr.length);

      int[] newArr = new int[arr.length - 1];
      int indexOfNewArr = 0;

      for (int value : subArr1) {
         newArr[indexOfNewArr++] = value;
      }
      for (int value : subArr2) {
         newArr[indexOfNewArr++] = value;
      }
      return newArr;
   }

   public static List<Integer> removeFromListByIndex(List<Integer> list, int index) {
      list.remove(index);
      return list;
   }

   public static List<Integer> addToList(List<Integer> list, int element) {
      list.add(element);
      return list;
   }

}
