package org.uepb.model.algorithms.sorting.merge;

import org.openjdk.jmh.annotations.Benchmark;
import org.uepb.model.algorithms.sorting.SortingBenchmark;


public class MergeSortBenchmark extends SortingBenchmark {
    @Benchmark
    public double[] benchmark() {
        MergeSort mergeSort = new MergeSort();
        return mergeSort.sort(inputArray.clone());
    }
}
