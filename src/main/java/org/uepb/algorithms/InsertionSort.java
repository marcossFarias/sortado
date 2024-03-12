package org.uepb.algorithms;

public class InsertionSort extends SortAlgorithm {
    @Override
    public double[] sort(double[] array) {
        int n = array.length;

        for (int j = 1; j < n; j++) {
            double key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;

                numberOfComparisons = numberOfComparisons + 1;
                numberOfSwaps = numberOfSwaps + 1;
            }
            array[i+1] = key;
        }

        return array;
    }
}
