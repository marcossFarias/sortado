package org.uepb.model.algorithms.sorting.bubble;

import org.openjdk.jmh.annotations.Benchmark;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class BubbleSortBenchmark extends SortingBenchmark {
    @Benchmark
    public double[] benchmark() {
        OptimizedBubbleSort optimizedBubbleSort = new OptimizedBubbleSort();
        return optimizedBubbleSort.sort(inputArray.clone());
    }
}
