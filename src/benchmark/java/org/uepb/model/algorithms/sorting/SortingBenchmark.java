package org.uepb.model.algorithms.sorting;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.FileUtils.readArrayFromFile;


@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SortingBenchmark {
    @Param({
            "./test-array-1M.txt",
            "./test-array-2M.txt",
            "./test-array-3M.txt"
    })
    public String ARRAY_FILE_PATH;

    protected double[] inputArray;

    @Setup(Level.Trial)
    public void setup() {
        inputArray = readArrayFromFile(ARRAY_FILE_PATH);
    }
}
