package org.uepb.model.algorithms.sorting.quick;

import org.openjdk.jmh.annotations.Benchmark;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class QuickSortBenchmark extends SortingBenchmark {
    @Benchmark
    public double[] benchmark() {
        QuickSort quickSort = new QuickSort();
        return quickSort.sort(inputArray.clone());
    }
}
