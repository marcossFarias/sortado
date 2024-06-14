package org.uepb.model.algorithms;

import java.util.List;

/**
 * Implementation of the Insertion Sort algorithm.
 */
public class QuickSort implements SortingAlgorithm {
  /**
   * Sorts the given list using the Quick Sort algorithm.
   *
   * @param unsorted the unsorted list
   * @param <T>      the type of elements in the list; must implement Comparable
   *                 interface
   * @return a sorted list
   */
  @Override
  public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
    quickSort(unsorted, 0, unsorted.size() - 1);
    return unsorted;
  }

  private <T extends Comparable<T>> void quickSort(List<T> arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private <T extends Comparable<T>> int partition(List<T> arr, int low, int high) {
    T pivot = arr.get(high);
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr.get(j).compareTo(pivot) <= 0) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return i + 1;
  }

  private <T extends Comparable<T>> void swap(List<T> arr, int i, int j) {
    T temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }
}
