package org.uepb.model.algorithms.sorting.counting;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class CountingSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        CountingSort CountingSort = new CountingSort();
        bh.consume(CountingSort.sort(inputArray.clone()));
    }
}
