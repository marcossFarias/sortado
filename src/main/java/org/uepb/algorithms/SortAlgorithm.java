package org.uepb.algorithms;

public abstract class SortAlgorithm {
    protected int numberOfComparisons;

    protected int numberOfSwaps;

    public SortAlgorithm() {
        this.numberOfSwaps = 0;
    }

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public int getNumberOfSwaps() {
        return numberOfSwaps;
    }

    public abstract int[] sort(int[] array);

    public long executionTime(int[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }
}
