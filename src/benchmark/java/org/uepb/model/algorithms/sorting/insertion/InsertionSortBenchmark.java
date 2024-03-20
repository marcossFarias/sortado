package org.uepb.model.algorithms.sorting.insertion;

import org.openjdk.jmh.annotations.Benchmark;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class InsertionSortBenchmark extends SortingBenchmark {
    @Benchmark
    public double[] benchmark() {
        InsertionSort insertionSort = new InsertionSort();
        return insertionSort.sort(inputArray.clone());
    }
}
