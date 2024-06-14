package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Bubble Sort algorithm.
 */
public class BubbleSort implements SortingAlgorithm {
  /**
   * Sorts the given list using the Bubble Sort algorithm.
   *
   * @param unsorted the unsorted list
   * @param <T>      the type of elements in the list, must implement Comparable
   *                 interface
   * @return the sorted list
   */
  @Override
  public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
    if (unsorted == null || unsorted.isEmpty()) {
      return unsorted;
    }

    @SuppressWarnings("unchecked")
    T[] array = (T[]) unsorted.toArray(new Comparable[unsorted.size()]);

    int n = array.length;
    for (int i = 0; i < (n - 1); i++) {
      for (int j = 0; j < (n - i - 1); j++) {
        if (array[j].compareTo(array[j + 1]) > 0) {
          T temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }

    List<T> sortedList = new ArrayList<>();
    for (T element : array) {
      sortedList.add(element);
    }

    return sortedList;
  }
}
