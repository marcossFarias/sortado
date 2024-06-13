package org.uepb.model.algorithms;

public class HeapSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
  @Override
  public void sort(T[] array) {
    buildHeap(array);

    for (int i = array.length - 1; i > 0; i--) {
      T max = array[0];
      array[0] = array[i];
      array[i] = max;

      heapify(array, 0, i);
    }
  }

  private void buildHeap(T[] array) {
    for (int i = array.length / 2 - 1; i >= 0; i--) {
      heapify(array, i, array.length);
    }
  }

  private void heapify(T[] array, int index, int size) {
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
      T temp = array[index];
      array[index] = array[largest];
      array[largest] = temp;

      heapify(array, largest, size);
    }
  }
}