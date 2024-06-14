package org.uepb.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for handling CSV files.
 */
public class CsvUtils {
  private CsvUtils() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Reads data from a CSV file.
   *
   * @param inputFile The path to the input CSV file.
   * @return A List of String arrays representing the CSV data.
   */
  public static List<String[]> readCsv(String inputFile) {
    List<String[]> csvData = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
      csvData = reader.readAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return csvData;
  }

  /**
   * Writes data to a CSV file.
   *
   * @param outputFile The path to the output CSV file.
   * @param data       The data to be written to the CSV file.
   */
  public static void writeCsv(String outputFile, List<String[]> data) {
    try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
      writer.writeAll(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Filters CSV data based on a specific column and a string value.
   *
   * @param csvData        The List of String arrays representing the CSV to be filtered.
   * @param columnToFilter The name of the column to filter.
   * @param stringToFilter The string value to filter by.
   * @return A List of String arrays representing the filtered CSV data.
   */
  public static List<String[]> filterCsv(
      List<String[]> csvData,
      String columnToFilter,
      String stringToFilter) {

    List<String[]> filteredData = new ArrayList<>();
    int columnIndex = getColumnIndex(csvData.get(0), columnToFilter);

    filteredData.add(csvData.get(0)); // Add CSV header
    for (String[] row : csvData.subList(1, csvData.size())) {
      if (row.length > columnIndex && row[columnIndex].contains(stringToFilter)) {
        filteredData.add(row.clone());
      }
    }
    return filteredData;
  }

  /**
   * Finds the index of a column in the CSV headers.
   *
   * @param headers     The array of header names.
   * @param columnName  The name of the column to find.
   * @return The index of the column in the headers, or -1 if not found.
   */
  public static int getColumnIndex(String[] headers, String columnName) {
    for (int i = 0; i < headers.length; i++) {
      if (headers[i].equalsIgnoreCase(columnName)) {
        return i;
      }
    }
    return -1;
  }
}
