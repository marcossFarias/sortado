package org.uepb.model.algorithms;

import java.util.List;

/**
 * Implementation of the Quick Sort Median Of Three algorithm.
 */
public class QuickSortMedianOfThree implements SortingAlgorithm {
  /**
   * Sorts the given list using the Quick Sort Median Of Three algorithm.
   *
   * @param unsorted the unsorted list
   * @param <T>      the type of elements in the list; must implement Comparable
   *                 interface
   * @return a sorted list
   */
  @Override
  public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
    if (unsorted == null || unsorted.isEmpty()) {
      return unsorted;
    }

    @SuppressWarnings("unchecked")
    T[] array = (T[]) unsorted.toArray(new Comparable[unsorted.size()]);

    quickSort(array, 0, array.length - 1);

    unsorted.clear();
    for (T element : array) {
      unsorted.add(element);
    }

    return unsorted;
  }

  private <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
    if (low >= high) {
      return;
    }
    int pivotIndex = partition(array, low, high);
    quickSort(array, low, pivotIndex - 1);
    quickSort(array, pivotIndex + 1, high);
  }

  private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
    T pivot = medianOfThree(array, low, high);
    int i = low;
    for (int j = low; j < high; j++) {
      if (array[j].compareTo(pivot) <= 0) {
        swap(array, i, j);
        i++;
      }
    }
    swap(array, i, high);
    return i;
  }

  private <T extends Comparable<T>> T medianOfThree(T[] array, int low, int high) {
    int mid = (low + high) / 2;
    if (array[low].compareTo(array[mid]) > 0) {
      if (array[mid].compareTo(array[high]) < 0) {
        return array[mid];
      } else if (array[low].compareTo(array[high]) > 0) {
        return array[high];
      } else {
        return array[low];
      }
    } else {
      return array[low];
    }
  }

  private <T extends Comparable<T>> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
