package org.uepb.controller;

import java.util.HashMap;
import java.util.Map;
import org.uepb.model.algorithms.InsertionSort;
import org.uepb.model.algorithms.MergeSort;
import org.uepb.model.algorithms.SortingAlgorithm;
import org.uepb.service.CsvSortingService;

/**
 * This class is responsible for managing sorting algorithms and their usage in
 * CSV operations.
 */
public class OrdinationsCsvController {
  private static Map<String, SortingAlgorithm> sortAlgorithms;

  private OrdinationsCsvController() {
    throw new IllegalStateException("Utility class");
  }

  static {
    sortAlgorithms = new HashMap<>();
    sortAlgorithms.put("bubble", new InsertionSort());
    sortAlgorithms.put("quick", new MergeSort());
  }

  /**
   * Sorts a CSV file by the specified column using the given sorting algorithm
   * and writes the sorted data to a new CSV file.
   *
   * @param inputFile    The path to the input CSV file.
   * @param outputFile   The path to the output CSV file where sorted data will be
   *                     written.
   * @param columnToSort The name of the column to sort.
   * @param algorithm    The sorting algorithm to be used.
   */
  public static void sortCsvFileByColumnWithAlgorithm(
      String inputFile,
      String outputFile,
      String columnToSort,
      SortingAlgorithm algorithm) {
    CsvSortingService sortingService = new CsvSortingService(algorithm);
    sortingService.sortCsvFileByColumn(inputFile, outputFile, columnToSort);
  }

  /**
   * Sorts a CSV file by the specified column using each sorting algorithm and
   * writes the sorted data to a new CSV file.
   *
   * @param inputFile    The path to the input CSV file.
   * @param outputFile   The path to the output CSV file where sorted data will be
   *                     written.
   * @param columnToSort The name of the column to sort.
   */
  public static void sortCsvFileByColumnForAllAlgorithms(
      String inputFile,
      String outputFile,
      String columnToSort) {
    for (Map.Entry<String, SortingAlgorithm> entry : sortAlgorithms.entrySet()) {
      String algorithmName = entry.getKey();
      SortingAlgorithm algorithm = entry.getValue();

      sortCsvFileByColumnWithAlgorithm(
          inputFile,
          outputFile + "_" + algorithmName + ".csv",
          columnToSort,
          algorithm);
    }
  }
}
