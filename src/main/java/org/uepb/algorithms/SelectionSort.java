package org.uepb.algorithms;

public class SelectionSort extends SortAlgorithm {
    @Override
    public double[] sort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                numberOfComparisons = numberOfComparisons + 1;
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                double smallerNumber = array[index];
                array[index] = array[i];
                array[i] = smallerNumber;
                numberOfSwaps = numberOfSwaps + 1;
            }
        }
        return array;
    }
}
