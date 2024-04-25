package org.uepb.model.algorithms.sorting;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        // Start from the second element of the array
        for (int i = 1; i < array.length; i++) {
            // Save the current element
            T key = array[i];
            int j = i - 1;

            // Compare the current element with the previous elements
            while (j >= 0 && array[j].compareTo(key) > 0) {
                // Shift the previous element to the right
                array[j + 1] = array[j];
                j--;
            }

            // Insert the current element in its correct position
            array[j + 1] = key;
        }
    }
}
