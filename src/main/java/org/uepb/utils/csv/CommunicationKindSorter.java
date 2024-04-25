package org.uepb.utils.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.uepb.model.algorithms.sorting.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommunicationKindSorter {
    public void sort(String inputFile, String outputFile, String algorithm) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
        List<CSVRecord> allData = parser.getRecords();

        List<String> communicationKindColumn = new ArrayList<>();
        for (CSVRecord row : allData) {
            String communicationKind = row.get("communication_kind");
            communicationKindColumn.add(communicationKind);
        }

        SortingAlgorithm<String> sortAlgorithm;
        int lastIndexOf = outputFile.lastIndexOf(".");
        String fileName = outputFile.substring(0, lastIndexOf);
        String suffix = "";
        switch (algorithm) {
            case "bubble":
                sortAlgorithm = new BubbleSort<>();
                suffix = "_bubble";
                break;
            case "counting":
                sortAlgorithm = new CountingSort<>();
                suffix = "_counting";
                break;
            case "heap":
                sortAlgorithm = new HeapSort<>();
                suffix = "_heap";
                break;
            case "insertion":
                sortAlgorithm = new InsertionSort<>();
                suffix = "_insertion";
                break;
            case "merge":
                sortAlgorithm = new MergeSort<>();
                suffix = "_merge";
                break;
            case "quick":
                sortAlgorithm = new QuickSort<>();
                suffix = "_quick";
                break;
            case "quickm3":
                sortAlgorithm = new QuickSortMedianOfThree<>();
                suffix = "_quickm3";
                break;
            case "selection":
                sortAlgorithm = new SelectionSort<>();
                suffix = "_selection";
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm specified");
        }

        String[] communicationKindArray = communicationKindColumn.toArray(new String[0]);
        sortAlgorithm.sort(communicationKindArray);

        try (CSVPrinter printer = CSVFormat.EXCEL.print(new FileWriter(fileName + suffix + "_sort_communication_kind" + ".csv"))) {
            for (String sortedValue : communicationKindArray) {
                for (CSVRecord row : allData) {
                    if (row.get("communication_kind").equals(sortedValue)) {
                        printer.printRecord(row);
                        break;
                    }
                }
            }
        }
    }
}
