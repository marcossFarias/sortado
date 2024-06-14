package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Heap Sort algorithm.
 */
public class HeapSort implements SortingAlgorithm {
  /**
   * Sorts the given list using the Heap Sort algorithm.
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

    Comparable[] array = unsorted.toArray(new Comparable[unsorted.size()]);

    buildHeap(array);

    for (int i = array.length - 1; i > 0; i--) {
      Comparable max = array[0];
      array[0] = array[i];
      array[i] = max;

      heapify(array, 0, i);
    }

    List<T> sortedList = new ArrayList<>();
    for (Comparable element : array) {
      sortedList.add((T) element);
    }

    return sortedList;
  }

  private void buildHeap(Comparable[] array) {
    for (int i = array.length / 2 - 1; i >= 0; i--) {
      heapify(array, i, array.length);
    }
  }

  private void heapify(Comparable[] array, int index, int size) {
    int largest = index;
    int left = 2 * index + 1;
    int right = 2 * index + 2;

    if (left < size && array[left].compareTo(array[largest]) > 0) {
      largest = left;
    }

    if (right < size && array[right].compareTo(array[largest]) > 0) {
      largest = right;
    }

    if (largest != index) {
      Comparable temp = array[index];
      array[index] = array[largest];
      array[largest] = temp;

      heapify(array, largest, size);
    }
  }
}
