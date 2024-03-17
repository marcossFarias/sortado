package org.uepb.model.algorithms.sorting;

import java.util.concurrent.atomic.LongAdder;

public abstract class SortingAlgorithm {
    protected final LongAdder numberOfComparisons = new LongAdder();
    protected final LongAdder numberOfSwaps = new LongAdder();

    public SortingAlgorithm() {
    }

    public long getNumberOfComparisons() {
        return numberOfComparisons.longValue();
    }

    public long getNumberOfSwaps() {
        return numberOfSwaps.longValue();
    }

    public abstract double[] sort(double[] array);

    public long executionTime(double[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    protected void incrementComparisons() {
        numberOfComparisons.increment();
    }

    protected void incrementSwaps() {
        numberOfSwaps.increment();
    }
}
