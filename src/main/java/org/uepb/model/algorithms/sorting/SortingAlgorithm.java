package org.uepb.model.algorithms.sorting;

import java.util.concurrent.atomic.LongAdder;

public abstract class SortingAlgorithm {
    private long executionTime;
    private final LongAdder numberOfComparisons = new LongAdder();
    private final LongAdder numberOfSwaps = new LongAdder();


    // Abstract methods

    /**
     * Sorts the given array and returns the sorted array.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public abstract double[] sort(double[] array);


    // Constructors

    /**
     * Constructs a new SortingAlgorithm instance.
     */
    protected SortingAlgorithm() {

    }

    /**
     * Constructs a new SortingAlgorithm instance and measures the execution time of the sorting algorithm on the given array.
     *
     * @param array the array to be sorted
     */
    protected SortingAlgorithm(double[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();

        this.executionTime = endTime - startTime;
    }


    // Getters

    /**
     * Returns the execution time of the last sort operation in nanoseconds.
     *
     * @return the execution time in nanoseconds
     */
    public long getExecutionTime() {
        return executionTime;
    }

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


    // "Setters"

    /**
     * Increments the number of comparisons performed.
     */
    protected void incrementComparisonsCount() {
        numberOfComparisons.increment();
    }

    /**
     * Increments the number of swaps performed.
     */
    protected void incrementSwapsCount() {
        numberOfSwaps.increment();
    }
}
