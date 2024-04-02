package org.uepb.model.algorithms.sorting;

import java.util.concurrent.atomic.LongAdder;

public abstract class SortingAlgorithm {
    private final LongAdder numberOfComparisons = new LongAdder();
    private final LongAdder numberOfSwaps = new LongAdder();

    /**
     * Returns the number of comparisons performed during the last sort operation.
     *
     * @return the number of comparisons
     */
    public long getNumberOfComparisons() {
        return numberOfComparisons.longValue();
    }

    /**
     * Returns the number of swaps performed during the last sort operation.
     *
     * @return the number of swaps
     */
    public long getNumberOfSwaps() {
        return numberOfSwaps.longValue();
    }

    /**
     * Sorts the given array and returns the sorted array.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public abstract double[] sort(double[] array);

    /**
     * Measures the execution time of the sorting algorithm on the given array.
     *
     * @param array the array to be sorted
     * @return the execution time in nanoseconds
     */
    public long executionTime(double[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    /**
     * Increments the number of comparisons performed.
     */
    protected void incrementComparisons() {
        numberOfComparisons.increment();
    }

    /**
     * Increments the number of swaps performed.
     */
    protected void incrementSwaps() {
        numberOfSwaps.increment();
    }
}
