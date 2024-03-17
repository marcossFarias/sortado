package org.uepb.model.algorithms.sorting.quick;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.ArrayUtils.generateRandomArray;

@State(Scope.Benchmark)
@Fork(value = 3)
@Warmup(iterations = 3)
@Timeout(time = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class QuickSortBenchmark {
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
        QuickSort quickSort = new QuickSort();
        return quickSort.sort(inputArray.clone());
    }
}
