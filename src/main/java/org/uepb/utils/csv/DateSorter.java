package org.uepb.utils.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.uepb.model.algorithms.sorting.BubbleSort;
import org.uepb.model.algorithms.sorting.InsertionSort;
import org.uepb.model.algorithms.sorting.SortingAlgorithm;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateSorter {
    public void sort(String inputFile, String outputFile, String algorithm) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
        List<CSVRecord> allData = parser.getRecords();

        List<Long> dateColumn = new ArrayList<>();
        for (CSVRecord row : allData) {
            String dateString = row.get("date");
            Long dateValue = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE).toEpochDay() * 24 * 60 * 60;
            dateColumn.add(dateValue);
        }

        SortingAlgorithm<Long> sortAlgorithm;
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

        Long[] dateArray = dateColumn.toArray(new Long[0]);
        sortAlgorithm.sort(dateArray);

        try (CSVPrinter printer = CSVFormat.EXCEL.print(new FileWriter(outputFile))) {
            for (Long sortedValue : dateArray) {
                for (CSVRecord row : allData) {
                    if ((long) LocalDate.parse(row.get("date"), DateTimeFormatter.ISO_DATE).toEpochDay() * 24 * 60 * 60 == sortedValue) {
                        printer.printRecord(row);
                        break;
                    }
                }
            }
        }
    }
}
