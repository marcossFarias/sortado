package org.uepb.model.algorithms.sorting;

public class SelectionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            T minValue = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(minValue) < 0) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}