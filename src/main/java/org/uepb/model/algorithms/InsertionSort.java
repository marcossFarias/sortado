package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the Insertion Sort algorithm.
 */
public class InsertionSort implements SortingAlgorithm {
  /**
   * Sorts the given list using the Insertion Sort algorithm.
   *
   * @param unsorted the unsorted list
   * @param <T>      the type of elements in the list, must implement Comparable
   *                 interface
   * @return the sorted list
   */
  @Override
  public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
    int n = unsorted.size();
    for (int i = 1; i < n; ++i) {
      T key = unsorted.get(i);
      int j = i - 1;

      while (j >= 0 && unsorted.get(j).compareTo(key) > 0) {
        unsorted.set(j + 1, unsorted.get(j));
        j = j - 1;
      }
      unsorted.set(j + 1, key);
    }
    return unsorted;
  }
}
