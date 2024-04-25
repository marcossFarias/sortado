package org.uepb.utils.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.uepb.model.algorithms.sorting.BubbleSort;
import org.uepb.model.algorithms.sorting.InsertionSort;
import org.uepb.model.algorithms.sorting.SortingAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeSorter {
    public void sort(String inputFile, String outputFile, String algorithm) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
        List<CSVRecord> allData = parser.getRecords();

        List<Integer> numericColumn = new ArrayList<>();
        for (CSVRecord row : allData) {
            numericColumn.add(Integer.parseInt(row.get("time")));
        }

        SortingAlgorithm<Integer> sortAlgorithm;
        switch (algorithm) {
            case "bubble":
                sortAlgorithm = new BubbleSort<>();
                break;
            case "insertion":
                sortAlgorithm = new InsertionSort<>();
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm specified");
        }

        Integer[] numericArray = numericColumn.toArray(new Integer[0]);
        sortAlgorithm.sort(numericArray);

        try (CSVPrinter printer = CSVFormat.EXCEL.print(new FileWriter(outputFile))) {
            for (Integer sortedValue : numericArray) {
                for (CSVRecord row : allData) {
                    if (Integer.parseInt(row.get("time")) == sortedValue) {
                        printer.printRecord(row);
                        break;
                    }
                }
            }
        }
    }
}

