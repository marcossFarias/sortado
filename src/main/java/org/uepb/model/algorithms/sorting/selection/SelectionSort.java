package org.uepb.model.algorithms.sorting.selection;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

public class SelectionSort extends SortingAlgorithm {
    @Override
    public double[] sort(double[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // Assume the first element as minimum

            for (int j = i + 1; j < n; j++) {
                incrementComparisons();
                if (array[j] < array[min_idx]) {
                    // If the current element is smaller than the minimum, update the minimum
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element
            double smallerNumber = array[min_idx];
            array[min_idx] = array[i];
            array[i] = smallerNumber;
            incrementSwaps();
        }
        return array;
    }
}
