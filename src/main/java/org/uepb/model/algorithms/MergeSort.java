package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Merge Sort algorithm.
 */
public class MergeSort implements SortingAlgorithm {
  /**
   * Sorts the given list using the Merge Sort algorithm.
   *
   * @param unsorted the unsorted list
   * @param <T>      the type of elements in the list; must implement Comparable
   *                 interface
   * @return a sorted list
   */
  @Override
  public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
    if (unsorted.size() <= 1) {
      return unsorted;
    }

    int mid = unsorted.size() / 2;
    List<T> left = sort(unsorted.subList(0, mid));
    List<T> right = sort(unsorted.subList(mid, unsorted.size()));

    return merge(left, right);
  }

  /**
   * Merges two sorted lists into a single sorted list.
   *
   * @param left  the first sorted list
   * @param right the second sorted list
   * @param <T>   the type of elements in the lists; must implement Comparable
   *              interface
   * @return a merged sorted list
   */
  private <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
    List<T> result = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
        result.add(left.get(leftIndex));
        leftIndex++;
      } else {
        result.add(right.get(rightIndex));
        rightIndex++;
      }
    }

    while (leftIndex < left.size()) {
      result.add(left.get(leftIndex));
      leftIndex++;
    }

    while (rightIndex < right.size()) {
      result.add(right.get(rightIndex));
      rightIndex++;
    }

    return result;
  }
}
