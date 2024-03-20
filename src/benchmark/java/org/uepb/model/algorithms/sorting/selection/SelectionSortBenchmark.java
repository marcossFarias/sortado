package org.uepb.model.algorithms.sorting.selection;

import org.openjdk.jmh.annotations.Benchmark;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class SelectionSortBenchmark extends SortingBenchmark {
    @Benchmark
    public double[] benchmark() {
        SelectionSort selectionSort = new SelectionSort();
        return selectionSort.sort(inputArray.clone());
    }
}
