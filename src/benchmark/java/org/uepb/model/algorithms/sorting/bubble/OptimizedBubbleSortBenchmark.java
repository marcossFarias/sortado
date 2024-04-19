package org.uepb.model.algorithms.sorting.bubble;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class OptimizedBubbleSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        OptimizedBubbleSort optimizedBubbleSort = new OptimizedBubbleSort();
        bh.consume(optimizedBubbleSort.sort(inputArray.clone()));
    }
}
