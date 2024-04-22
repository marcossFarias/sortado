package org.uepb.model.algorithms.sorting;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.uepb.utils.FileUtils.readArrayFromFile;


@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3)
@Timeout(time = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SortingBenchmark {
    @Param({
            "./src/main/resources/databases/eda/test-array-1M-desordenado.txt",
            "./src/main/resources/databases/eda/test-array-1M-desordenado-nos-10_-finais.txt",
            "./src/main/resources/databases/eda/test-array-1M-desordenado-nos-10_-iniciais.txt",
            "./src/main/resources/databases/eda/test-array-1M-ordenado-crescente",
            "./src/main/resources/databases/eda/test-array-1M-ordenado-decrescente",
            "./src/main/resources/databases/eda/test-array-1M-constante",

            "./src/main/resources/databases/eda/test-array-2M-desordenado.txt",
            "./src/main/resources/databases/eda/test-array-2M-desordenado-nos-10_-finais.txt",
            "./src/main/resources/databases/eda/test-array-2M-desordenado-nos-10_-iniciais.txt",
            "./src/main/resources/databases/eda/test-array-2M-ordenado-crescente",
            "./src/main/resources/databases/eda/test-array-2M-ordenado-decrescente",
            "./src/main/resources/databases/eda/test-array-2M-constante",

            "./src/main/resources/databases/eda/test-array-3M-desordenado.txt",
            "./src/main/resources/databases/eda/test-array-3M-desordenado-nos-10_-finais.txt",
            "./src/main/resources/databases/eda/test-array-3M-desordenado-nos-10_-iniciais.txt",
            "./src/main/resources/databases/eda/test-array-3M-ordenado-crescente",
            "./src/main/resources/databases/eda/test-array-3M-ordenado-decrescente",
            "./src/main/resources/databases/eda/test-array-3M-constante"
    })
    public String ARRAY_FILE_PATH;

    protected double[] inputArray;

    @Setup(Level.Trial)
    public void setup() {
        inputArray = readArrayFromFile(ARRAY_FILE_PATH);
    }
}
