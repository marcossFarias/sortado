package org.uepb.model.algorithms.sorting;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.FileUtils.readArrayFromFile;


@State(Scope.Benchmark)
@Fork(value = 3)
@Warmup(iterations = 3)
@Timeout(time = 60)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SortingBenchmark {
    @Param({
            "./array100.txt",
            "./array1000.txt",
            "./array10000.txt"
    })
    public String ARRAY_FILE_PATH;

    protected double[] inputArray;

    @Setup
    public void setup() {
        inputArray = readArrayFromFile(ARRAY_FILE_PATH);
    }
}
