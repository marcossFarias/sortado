package org.uepb.model.algorithms.sorting;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.FileUtils.readArrayFromFile;


@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SortingBenchmark {
    @Param({
            "./test-array-1M_20240320_152732.txt",
            "./test-array-1M_20240320_152733.txt",
            "./test-array-1M_20240320_152735.txt"
    })
    public String ARRAY_FILE_PATH;

    protected double[] inputArray;

    @Setup
    public void setup() {
        inputArray = readArrayFromFile(ARRAY_FILE_PATH);
    }
}
