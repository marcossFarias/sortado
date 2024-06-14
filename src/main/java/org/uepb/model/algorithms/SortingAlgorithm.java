package org.uepb.model.algorithms;

import java.util.List;

/**
 * The common interface of most sorting algorithms.
 */
public interface SortingAlgorithm {
  /**
   * Main method for sorting lists.
   *
   * @param unsorted - a list to be sorted
   * @return a sorted list
   */
  <T extends Comparable<T>> List<T> sort(List<T> unsorted);
}
