package org.uepb.algorithms.derivations;

import org.uepb.algorithms.SortAlgorithm;

public class OptimizedSelectionSort extends SortAlgorithm {
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
            // only if the minimum is not in the correct position
            if (min_idx != i) {
                double smallerNumber = array[min_idx];
                array[min_idx] = array[i];
                array[i] = smallerNumber;
                incrementSwaps();
            }
        }
        return array;
    }
}
