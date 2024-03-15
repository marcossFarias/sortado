package org.uepb;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(new String[]{
                "-rf", "csv",
                "-rff", "./benchmarks.csv"
        });
    }
}
