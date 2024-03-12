package org.uepb.algorithms;

public class BubbleSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        int n = array.length;
        int temp = 0;

        for(int i=0; i < n; i++) {
            for(int j=1; j < (n-i); j++) {
                numberOfComparisons = numberOfComparisons + 1;

                if(array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    numberOfSwaps = numberOfSwaps + 1;
                }
            }
        }
        return array;
    }
}
