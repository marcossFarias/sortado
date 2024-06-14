package org.uepb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import org.uepb.model.algorithms.BubbleSort;
import org.uepb.model.algorithms.QuickSort;
import org.uepb.model.algorithms.SortingAlgorithm;
import org.uepb.service.CsvSortingService;
import org.uepb.utils.CsvUtils;
import org.uepb.utils.FileUtils;

/**
 * This class is responsible for managing sorting algorithms and their usage in
 * CSV operations.
 */
public class OrdinationsCsvController {
  private OrdinationsCsvController() {
    throw new IllegalStateException("Utility class");
  }

  private static final Logger logger = Logger.getLogger(OrdinationsCsvController.class.getName());

  private static final String CSV_FILE = "resources/transformations/accidents_NCBMV.csv";
  private static final String TIME_COLUMN = "time";
  private static final String DATE_COLUMN = "date";
  private static final String LEXICAL_COLUMN = "communication_kind";

  /**
   * Deletes existing files in the "resources/ordinations" directory
   * and performs CSV ordinations by time, date, and lexical order.
   */
  public static void startCsvOrdinations() {
    FileUtils.deleteFilesInDirectory("resources/ordinations");
    FileUtils.deleteFilesInDirectory("resources/ordinations/to_ordinate");

    generateBestCase();
    generateWorstCase();

    logger.info("Starting CSV ordinations...");

    List<String> filePaths = getFilePaths();
    for (String filePath : filePaths) {
      ordinateByTime(filePath);
      ordinateByDate(filePath);
      ordinateByLexical(filePath);
    }

    logger.info("CSV ordinations completed.");
  }

  private static List<String> getFilePaths() {
    String folderPath = "resources/ordinations/to_ordinate";

    List<String> filePaths = new ArrayList<>();

    File folder = new File(folderPath);

    if (folder.exists() && folder.isDirectory()) {
      File[] files = folder.listFiles();

      if (files != null) {
        for (File file : files) {
          if (file.isFile()) {
            String relativePath = folderPath + File.separator + file.getName();
            filePaths.add(relativePath);
          }
        }
      }
    }

    return filePaths;
  }

  private static void ordinateByTime(String filePath) {
    String filePathWithoutExtensionAndParentDir = 
        filePath.substring(0, filePath.indexOf('/',
            filePath.indexOf('/') + 1))
            + filePath.substring(filePath.lastIndexOf('/'), filePath.lastIndexOf('.'));

    logger.info("Sorting CSV file by time...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        filePath,
        filePathWithoutExtensionAndParentDir,
        TIME_COLUMN);
    logger.info("CSV file sorted by time.");
  }

  private static void ordinateByDate(String filePath) {
    String filePathWithoutExtensionAndParentDir = 
        filePath.substring(0, filePath.indexOf('/',
            filePath.indexOf('/') + 1))
            + filePath.substring(filePath.lastIndexOf('/'), filePath.lastIndexOf('.'));
    logger.info("Sorting CSV file by date...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        filePath,
        filePathWithoutExtensionAndParentDir,
        DATE_COLUMN);
    logger.info("CSV file sorted by date.");
  }

  private static void ordinateByLexical(String filePath) {
    String filePathWithoutExtensionAndParentDir = 
        filePath.substring(0, filePath.indexOf('/',
            filePath.indexOf('/') + 1))
            + filePath.substring(filePath.lastIndexOf('/'), filePath.lastIndexOf('.'));
    logger.info("Sorting CSV file by lexical...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        filePath,
        filePathWithoutExtensionAndParentDir,
        LEXICAL_COLUMN);
    logger.info("CSV file sorted by date.");
  }

  private static void generateBestCase() {
    sortCsvFile(
        CSV_FILE, 
        "resources/ordinations/to_ordinate/accidents_NCBMV_time_melhorCaso.csv",
        TIME_COLUMN,
        new BubbleSort());

    sortCsvFile(
        CSV_FILE, 
        "resources/ordinations/to_ordinate/accidents_NCBMV_date_melhorCaso.csv",
        DATE_COLUMN,
        new BubbleSort());

    sortCsvFile(
        CSV_FILE,
        "resources/ordinations/to_ordinate/accidents_NCBMV_communication_kind_melhorCaso.csv",
        LEXICAL_COLUMN,
        new QuickSort());
  }

  private static void generateWorstCase() {
    reverseRows(
        "resources/ordinations/to_ordinate/accidents_NCBMV_time_melhorCaso.csv",
        TIME_COLUMN,
        "resources/ordinations/to_ordinate/accidents_NCBMV_time_piorCaso.csv");

    reverseRows(
        "resources/ordinations/to_ordinate/accidents_NCBMV_date_melhorCaso.csv",
        DATE_COLUMN,
        "resources/ordinations/to_ordinate/accidents_NCBMV_date_piorCaso.csv");

    reverseRows(
        "resources/ordinations/to_ordinate/accidents_NCBMV_communication_kind_melhorCaso.csv",
        LEXICAL_COLUMN,
        "resources/ordinations/to_ordinate/accidents_NCBMV_communication_kind_piorCaso.csv");
  }


  private static void sortCsvFile(
      String inputFile,
      String outputFile,
      String column,
      SortingAlgorithm algorithm) {
    CsvSortingService.sortCsvFileByColumnWithAlgorithm(inputFile, outputFile, column, algorithm);
  }

  private static void reverseRows(String inputFile, String column, String outputFile) {
    List<String[]> data = CsvUtils.readCsv(inputFile);

    int columnIndex = -1;
    String[] header = data.get(0);
    for (int i = 0; i < header.length; i++) {
      if (header[i].equals(column)) {
        columnIndex = i;
        break;
      }
    }

    if (columnIndex != -1) {
      Collections.reverse(data.subList(1, data.size()));
    }

    CsvUtils.writeCsv(outputFile, data);
  }
}
