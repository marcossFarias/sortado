package org.uepb;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.uepb.model.algorithms.sorting.BubbleSort;
import org.uepb.utils.csv.CommunicationKindSorter;
import org.uepb.utils.csv.DateSorter;
import org.uepb.utils.csv.TimeSorter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "./src/main/resources/databases/leda/test.csv";
        String outputFile = "./src/main/resources/databases/leda/test-output-time.csv";
        String outputFile2 = "./src/main/resources/databases/leda/test-output-date.csv";
        String outputFile3 = "./src/main/resources/databases/leda/test-output-communication.csv";

        // Read the CSV file
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
        List<CSVRecord> allData = parser.getRecords();

        TimeSorter timeSorter = new TimeSorter();
        timeSorter.sort(inputFile, outputFile, "insertion");

        DateSorter dateSorter = new DateSorter();
        dateSorter.sort(inputFile, outputFile2, "insertion");

        CommunicationKindSorter communicationSorter = new CommunicationKindSorter();
        communicationSorter.sort(inputFile, outputFile3, "insertion");
    }
}
