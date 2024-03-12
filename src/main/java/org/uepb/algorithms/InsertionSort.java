package org.uepb.algorithms;

public class InsertionSort extends SortAlgorithm {
    @Override
    public double[] sort(double[] array) {
        int array_length = array.length;

        for (int i = 1; i < array_length; i++) {
            double key = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j] > key)) {
                numberOfComparisons = numberOfComparisons + 1;

                if (array[j] > key) {
                    array[j + 1] = array[j];
                    numberOfSwaps = numberOfSwaps + 1;
                }

                j = j -1;
            }

            array[j+1] = key;
        }
        return array;
    }
}
