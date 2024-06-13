package org.uepb.utils.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor {
  public List<CSVRecord> readCsv(String inputFile) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
    return parser.getRecords();
  }

  public List<String> extractColumn(List<CSVRecord> records, String columnHeader) {
    List<String> columnValues = new ArrayList<>();
    for (CSVRecord record : records) {
        columnValues.add(record.get(columnHeader));
    }
    return columnValues;
  }

  public void printSortedRecords(List<CSVRecord> sortedRecords, String outputFile) throws IOException {
    try (CSVPrinter printer = CSVFormat.EXCEL.print(new FileWriter(outputFile))) {
      for (CSVRecord record : sortedRecords) {
        printer.printRecord(record);
      }
    }
}
}
