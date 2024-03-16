package org.uepb.algorithms;

import org.openjdk.jmh.annotations.*;
import org.uepb.algorithms.derivations.OptimizedBubbleSort;
import org.uepb.algorithms.derivations.OptimizedSelectionSort;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.ArrayUtils.generateRandomArray;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SortBenchmark {
    @Param({
            "100",   // 1,000
            "10000",  // 10,000
            "100000"  // 100,000
    })
    private int ARRAY_SIZE;

    @Setup
    public void setup() {
        inputArray = generateRandomArray(ARRAY_SIZE);
    }

    private double[] inputArray;

    @Benchmark
    public double[] benchmarkBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        return bubbleSort.sort(inputArray.clone());
    }
    @Benchmark
    public double[] benchmarkOptimizedBubbleSort() {
        OptimizedBubbleSort optimizedBubbleSort = new OptimizedBubbleSort();
        return optimizedBubbleSort.sort(inputArray.clone());
    }

    @Benchmark
    public double[] benchmarkInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        return insertionSort.sort(inputArray.clone());
    }

    @Benchmark
    public double[] benchmarkSelectionSort() {
        SelectionSort selectionSort = new SelectionSort();
        return selectionSort.sort(inputArray.clone());
    }
    @Benchmark
    public double[] benchmarkOptimizedSelectionSort() {
        OptimizedSelectionSort optimizedSelectionSort = new OptimizedSelectionSort();
        return optimizedSelectionSort.sort(inputArray.clone());
    }
}
