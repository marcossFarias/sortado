package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the Counting Sort algorithm.
 */
public class CountingSort implements SortingAlgorithm {
  /**
   * Sorts the given list using the Counting Sort algorithm.
   *
   * @param unsorted the unsorted list
   * @param <T>      the type of elements in the list, must implement Comparable
   *                 interface
   * @return the sorted list
   */
  @Override
  public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
    if (unsorted == null || unsorted.isEmpty()) {
      return new ArrayList<>();
    }

    T max = Collections.max(unsorted);
    T min = Collections.min(unsorted);

    int range = max.compareTo(min) + 1;
    int[] countArray = new int[range];

    for (T t : unsorted) {
      countArray[t.compareTo(min)]++;
    }

    for (int i = 1; i < range; i++) {
      countArray[i] += countArray[i - 1];
    }

    List<T> sortedList = new ArrayList<>(unsorted.size());

    for (int i = unsorted.size() - 1; i >= 0; i--) {
      sortedList.set(countArray[unsorted.get(i).compareTo(min)] - 1, unsorted.get(i));
      countArray[unsorted.get(i).compareTo(min)]--;
    }

    return sortedList;
  }
}
