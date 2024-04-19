package org.uepb.model.algorithms.sorting.bubble;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class BubbleSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        OptimizedBubbleSort optimizedBubbleSort = new OptimizedBubbleSort();
        bh.consume(optimizedBubbleSort.sort(inputArray.clone()));
    }
}
