package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Selection Sort algorithm.
 */
public class SelectionSort implements SortingAlgorithm{
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
