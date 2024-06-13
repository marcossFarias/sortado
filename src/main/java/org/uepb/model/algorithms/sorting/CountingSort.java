package org.uepb.model.algorithms.sorting;

import java.util.Arrays;

public class CountingSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
  @Override
  public void sort(T[] array) {
    if (array == null || array.length == 0) {
      return;
    }

    T max = array[0];
    T min = array[0];

    for (T t : array) {
      if (t.compareTo(max) > 0) {
        max = t;
      }
      if (t.compareTo(min) < 0) {
        min = t;
      }
    }

    int range = max.compareTo(min) + 1;
    int[] countArray = new int[range];

    for (T t : array) {
      countArray[t.compareTo(min)]++;
    }

    for (int i = 1; i < range; i++) {
      countArray[i] += countArray[i - 1];
    }

    T[] sortedArray = Arrays.copyOf(array, array.length);

    for (int i = array.length - 1; i >= 0; i--) {
      sortedArray[countArray[array[i].compareTo(min)] - 1] = array[i];
      countArray[array[i].compareTo(min)]--;
    }

    System.arraycopy(sortedArray, 0, array, 0, array.length);
  }
}
