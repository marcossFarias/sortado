package org.uepb.algorithms;

public class BubbleSort extends SortAlgorithm {
    @Override
    public double[] sort(double[] array) {
        int n = array.length;
        double temp = 0;

        for(int i=0; i < n; i++) {
            for(int j=1; j < (n-i); j++) {
                incrementComparisons();

                if(array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    incrementSwaps();
                }
            }
        }
        return array;
    }
}
