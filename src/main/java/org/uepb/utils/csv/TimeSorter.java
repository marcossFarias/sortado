package org.uepb.utils.csv;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.uepb.model.algorithms.sorting.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeSorter {
    public void sort(String inputFile, String outputFile, String algorithm) throws IOException, CsvException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(inputFile))
                .withCSVParser(new CSVParserBuilder().withQuoteChar('\'').build())
                .withSkipLines(1) // indica que a primeira linha contém o cabeçalho
                .build();
        List<String[]> allData = new ArrayList<>();
        String[] nextRecord;
        while ((nextRecord = reader.readNext()) != null) {
            allData.add(nextRecord);
        }

        List<Double> numericColumn = new ArrayList<>();
        for (String[] row : allData) {
            String time = row[3];
            if (time.matches("\\d+(?:\\.\\d+)?")) {
                double value = Double.parseDouble(time);
                numericColumn.add(value);
            } else {
                System.err.println("Invalid long value: " + time);
            }
        }

        SortingAlgorithm<Double> sortAlgorithm;
        int lastIndexOf = outputFile.lastIndexOf(".");
        String fileName = outputFile.substring(0, lastIndexOf);
        String suffix = "";
        switch (algorithm) {
            case "bubble":
                sortAlgorithm = new BubbleSort<>();
                suffix = "_bubble";
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

        Double[] numericArray = numericColumn.toArray(new Double[0]);
        sortAlgorithm.sort(numericArray);

        CSVWriter writer = new CSVWriter(new FileWriter(fileName + suffix + "_sort_time" + ".csv"));

        for (Double sortedValue : numericArray) {
            for (String[] row : allData) {
                if (Double.parseDouble(row[3]) == sortedValue) {
                    writer.writeNext(row);
                    break;
                }
            }
        }

        writer.close();
        reader.close();
    }
}
