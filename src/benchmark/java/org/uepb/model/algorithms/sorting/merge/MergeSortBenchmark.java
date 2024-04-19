package org.uepb.model.algorithms.sorting.merge;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class MergeSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        MergeSort mergeSort = new MergeSort();
        bh.consume(mergeSort.sort(inputArray.clone()));
    }
}
