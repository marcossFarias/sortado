package org.uepb.algorithms;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SortBenchmark {
    @Param({"1000", "10000", "100000"})
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
    public double[] benchmarkQuickSort() {
        InsertionSort quickSort = new InsertionSort();
        return quickSort.sort(inputArray.clone());
    }

    @Benchmark
    public double[] benchmarkMergeSort() {
        SelectionSort mergeSort = new SelectionSort();
        return mergeSort.sort(inputArray.clone());
    }

    private double[] generateRandomArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.random();
        }
        return array;
    }
}
