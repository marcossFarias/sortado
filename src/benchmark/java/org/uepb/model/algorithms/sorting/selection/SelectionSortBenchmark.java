package org.uepb.model.algorithms.sorting.selection;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class SelectionSortBenchmark extends SortingBenchmark {
    @Benchmark
    public void benchmark(Blackhole bh) {
        SelectionSort selectionSort = new SelectionSort();
        bh.consume(selectionSort.sort(inputArray.clone()));
    }
}
