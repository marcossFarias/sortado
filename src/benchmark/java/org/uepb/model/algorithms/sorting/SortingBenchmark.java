package org.uepb.model.algorithms.sorting;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.ArrayUtils.generateRandomArray;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public abstract class SortingBenchmark {
    protected abstract SortingAlgorithm getSortAlgorithm();
    protected abstract int getArraySize();
    protected abstract double[] getInputArray();

    @Benchmark
    public double[] benchmarkSort() {
        SortingAlgorithm sortingAlgorithm = getSortAlgorithm();
        return sortingAlgorithm.sort(getInputArray().clone());
    }
}
