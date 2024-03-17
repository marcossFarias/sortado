package org.uepb.model.algorithms.sorting.insertion;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

public class InsertionSort extends SortingAlgorithm {
    @Override
    public double[] sort(double[] array) {
        // Start from the second element of the array
        for (int j = 1; j < array.length; j++) {
            // Save the current element
            double n = array[j];
            int i = j - 1;

            // Compare the current element with the previous elements
            while ((i >= 0) && (array[i] > n)) {
                // Shift the previous element to the right
                array[i+1] = array[i];
                i = i - 1;
                incrementSwaps();
                incrementComparisons();
            }
            // Insert the current element in its correct position
            array[i+1] = n;

            if (i >= 0) {
                // Accounts for the last failed comparison in the while loop,
                // either i is no longer >= 0 or array[i] is no longer > key.
                incrementComparisons();
            }
        }
        return array;
    }
}
