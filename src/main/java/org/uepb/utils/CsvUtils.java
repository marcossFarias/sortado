package org.uepb.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class CsvUtils {
  private CsvUtils() {
    throw new IllegalStateException("Utility class");
  }

  public static List<String[]> readCsv(String inputFile) {
    List<String[]> csvData = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
      csvData = reader.readAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return csvData;
  }

  public static void writeCsv(String outputFile, List<String[]> data) {
    try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
      writer.writeAll(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<String[]> filterCsv(
        String inputFile,
        String columnToFilter,
        String stringToFilter) {

    List<String[]> filteredData = new ArrayList<>();
    List<String[]> csvData = readCsv(inputFile);
    int columnIndex = getColumnIndex(csvData.get(0), columnToFilter);
    
    filteredData.add(csvData.get(0)); // Add CSV header
    for (String[] row : csvData.subList(1, csvData.size())) {
      if (row.length > columnIndex && row[columnIndex].contains(stringToFilter)) {
        filteredData.add(row.clone());
      }
    }
    return filteredData;
  }


  private static int getColumnIndex(String[] headers, String columnName) {
    for (int i = 0; i < headers.length; i++) {
      if (headers[i].equalsIgnoreCase(columnName)) {
        return i;
      }
    }
    return -1;
  }
}
