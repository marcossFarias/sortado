package org.uepb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        String fileName = "BenchmarkRunner_output.txt";
        FileOutputStream outputFile = new FileOutputStream(fileName);
        PrintStream fileStream = new PrintStream(outputFile);
        PrintStream consoleStream = System.out;

        PrintStream dualStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                consoleStream.write(b);
                fileStream.write(b);
            }
        });

        System.setOut(dualStream);
        org.openjdk.jmh.Main.main(new String[]{
                "-rf", "csv",
                "-rff", "./BenchmarkRunner.csv"
        });

        outputFile.close();
    }
}
