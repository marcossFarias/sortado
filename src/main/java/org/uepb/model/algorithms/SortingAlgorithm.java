package org.uepb.model.algorithms;

public interface SortingAlgorithm<T extends Comparable<T>> {
  void sort(T[] array);
}
