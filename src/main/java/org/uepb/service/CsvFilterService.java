package org.uepb.service;

import java.util.List;
import org.uepb.utils.CsvUtils;

/**
 * Service class for applying filters to CSV files.
 */
public class CsvFilterService {
  private CsvFilterService() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Filters and write a CSV file based on a specific column and a string value.
   *
   * @param inputFile      The path to the input CSV file.
   * @param columnToFilter The name of the column to filter.
   * @param stringToFilter The string value to filter by.
   */
  public static void applyFilter(
      String inputFile,
      String outputFile,
      String columnToFilter,
      String stringToFilter) {

    List<String[]> data = CsvUtils.readCsv(inputFile);

    List<String[]> filteredData = CsvUtils.filterCsv(data, columnToFilter, stringToFilter);

    CsvUtils.writeCsv(outputFile, filteredData);
  }
}
