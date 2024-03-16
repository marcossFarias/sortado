package org.uepb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();

        String fileName = "BenchmarkRunner_output" + dtf.format(now) + ".txt";

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
