package org.uepb.model.algorithms.sorting.selection;

import org.openjdk.jmh.annotations.Benchmark;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class OptimizedSelectionSortBenchmark extends SortingBenchmark {
    @Benchmark
    public double[] benchmark() {
        OptimizedSelectionSort optimizedSelectionSort = new OptimizedSelectionSort();
        return optimizedSelectionSort.sort(inputArray.clone());
    }
}
