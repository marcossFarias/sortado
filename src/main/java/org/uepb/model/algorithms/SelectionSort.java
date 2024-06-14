package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Selection Sort algorithm.
 */
public class SelectionSort implements SortingAlgorithm {
  /**
   * Sorts the given list using the Selection Sort algorithm.
   *
   * @param unsorted the unsorted list
   * @param <T>      the type of elements in the list; must implement Comparable
   *                 interface
   * @return a sorted list
   */
  @Override
  public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
    List<T> sortedList = new ArrayList<>(unsorted);

    for (int i = 0; i < sortedList.size() - 1; i++) {
      int minIndex = i;
      T minValue = sortedList.get(i);
      for (int j = i + 1; j < sortedList.size(); j++) {
        if (sortedList.get(j).compareTo(minValue) < 0) {
          minIndex = j;
          minValue = sortedList.get(j);
        }
      }
      if (minIndex != i) {
        T temp = sortedList.get(minIndex);
        sortedList.set(minIndex, sortedList.get(i));
        sortedList.set(i, temp);
      }
    }

    return sortedList;
  }
}
