package org.uepb.model.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

  private <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
    List<T> result = new ArrayList<>();
    Stack<T> leftStack = new Stack<>();
    Stack<T> rightStack = new Stack<>();

    for (T element : left) {
      leftStack.push(element);
    }
    for (T element : right) {
      rightStack.push(element);
    }

    while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
      T leftTop = leftStack.peek();
      T rightTop = rightStack.peek();

      if (leftTop.compareTo(rightTop) < 0) {
        result.add(leftStack.pop());
      } else {
        result.add(rightStack.pop());
      }
    }

    while (!leftStack.isEmpty()) {
      result.add(leftStack.pop());
    }
    while (!rightStack.isEmpty()) {
      result.add(rightStack.pop());
    }

    return result;
  }
}
