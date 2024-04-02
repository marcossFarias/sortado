package org.uepb.model.algorithms.sorting.quick;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class QuickSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        QuickSort quickSort = new QuickSort();
        bh.consume(quickSort.sort(inputArray.clone()));
    }
}
