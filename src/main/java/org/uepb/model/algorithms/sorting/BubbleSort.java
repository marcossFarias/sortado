package org.uepb.model.algorithms.sorting;

public class BubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
  @Override
  public final void sort(final T[] array) {
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
  }
}
