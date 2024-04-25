package org.uepb;

import com.opencsv.exceptions.CsvException;
import org.uepb.utils.csv.CommunicationKindSorter;
import org.uepb.utils.csv.DateSorter;
import org.uepb.utils.csv.TimeSorter;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        String inputFile = "./src/main/resources/databases/leda/test.csv";
        String outputFile = "./src/main/resources/databases/leda/test_medio_caso.csv";

        String[] algorithms = {"bubble", "counting", "heap", "insertion", "merge", "quick", "quickm3", "selection"};

        for (String algorithm : algorithms) {
            TimeSorter timeSorter = new TimeSorter();
            long startTime = System.nanoTime();
            timeSorter.sort(inputFile, outputFile, algorithm);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Algorithm: " + algorithm + ", Metric: Time" + ", Time elapsed: " + timeElapsed + " nanos");

            DateSorter dateSorter = new DateSorter();
            startTime = System.nanoTime();
            dateSorter.sort(inputFile, outputFile, algorithm);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Algorithm: " + algorithm + ", Metric: Date" + ", Time elapsed: " + timeElapsed + " nanos");

            CommunicationKindSorter communicationSorter = new CommunicationKindSorter();
            startTime = System.nanoTime();
            communicationSorter.sort(inputFile, outputFile, algorithm);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Algorithm: " + algorithm + ", Metric: CommunicationKind" + ", Time elapsed: " + timeElapsed + " nanos");
        }
    }
}
