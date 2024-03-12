package org.uepb.algorithms;

public abstract class SortAlgorithm {
    protected int numberOfComparisons;

    protected int numberOfSwaps;

    public SortAlgorithm() {
        this.numberOfComparisons = 0;
        this.numberOfSwaps = 0;
    }

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public int getNumberOfSwaps() {
        return numberOfSwaps;
    }

    public abstract double[] sort(double[] array);

    public long executionTime(double[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }
}
