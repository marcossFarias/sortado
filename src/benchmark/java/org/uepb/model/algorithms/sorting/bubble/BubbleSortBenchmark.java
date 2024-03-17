package org.uepb.model.algorithms.sorting.bubble;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.ArrayUtils.generateRandomArray;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BubbleSortBenchmark {
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
    public double[] benchmark() {
        BubbleSort bubbleSort = new BubbleSort();
        return bubbleSort.sort(inputArray.clone());
    }
}
