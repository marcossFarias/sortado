package org.uepb.model.algorithms.sorting.insertion;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.ArrayUtils.generateRandomArray;

@State(Scope.Benchmark)
@Fork(value = 3)
@Warmup(iterations = 3)
@Timeout(time = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class InsertionSortBenchmark {
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
        InsertionSort insertionSort = new InsertionSort();
        return insertionSort.sort(inputArray.clone());
    }
}
