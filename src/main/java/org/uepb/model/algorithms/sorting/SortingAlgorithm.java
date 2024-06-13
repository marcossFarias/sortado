package org.uepb.model.algorithms.sorting;

public interface SortingAlgorithm<T extends Comparable<T>> {
  void sort(T[] array);
}
