package org.uepb.model.algorithms.sorting.selection;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class OptimizedSelectionSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        OptimizedSelectionSort optimizedSelectionSort = new OptimizedSelectionSort();
        bh.consume(optimizedSelectionSort.sort(inputArray.clone()));
    }
}
