package org.uepb.model.algorithms.sorting.insertion;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.InsertionSort;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class InsertionSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        InsertionSort insertionSort = new InsertionSort();
        bh.consume(insertionSort.sort(inputArray.clone()));
    }
}
