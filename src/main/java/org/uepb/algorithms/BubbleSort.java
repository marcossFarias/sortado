package org.uepb.algorithms;

public class BubbleSort extends SortAlgorithm {
    @Override
    public double[] sort(double[] array) {
        int n = array.length;

        // Outer loop: iterate over each element in the array
        for(int i=0; i < (n - 1); i++) {
            // Inner loop: compare adjacent elements in the array
            // The (n - i - 1) ensures we don't compare elements that are already sorted

            for(int j=0; j < (n - i - 1); j++) {
                incrementComparisons();
                if(array[j] > array[j+1]) {
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    incrementSwaps();
                }
            }
        }
        return array;
    }
}
