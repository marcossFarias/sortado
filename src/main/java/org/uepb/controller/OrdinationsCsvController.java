package org.uepb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.uepb.service.CsvSortingService;
import org.uepb.utils.FileUtils;

/**
 * This class is responsible for managing sorting algorithms and their usage in
 * CSV operations.
 */
public class OrdinationsCsvController {
  private OrdinationsCsvController() {
    throw new IllegalStateException("Utility class");
  }

  private static final Logger logger =
      Logger.getLogger(OrdinationsCsvController.class.getName());

  private static final String TIME_COLUMN = "time";
  private static final String DATE_COLUMN = "date";
  private static final String LEXICAL_COLUMN = "communication_kind";

  public static void startCsvOrdinations() {
    FileUtils.deleteFilesInDirectory("resources/ordinations");
    
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
    List<String> filePaths = new ArrayList<>();
    filePaths.add("resources/test.csv");
    return filePaths;
  }

  private static void ordinateByTime(String filePath) {
    logger.info("Sorting CSV file by time...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        filePath,
        "resources/ordinations/accidents_NCBMV_" + TIME_COLUMN,
        TIME_COLUMN);
    logger.info("CSV file sorted by time.");
  }

  private static void ordinateByDate(String filePath) {
    logger.info("Sorting CSV file by date...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        filePath,
        "resources/ordinations/accidents_NCBMV_" + DATE_COLUMN,
        DATE_COLUMN);
    logger.info("CSV file sorted by date.");
  }

  private static void ordinateByLexical(String filePath) {
    logger.info("Sorting CSV file by lexical...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        filePath,
        "resources/ordinations/accidents_NCBMV_" + LEXICAL_COLUMN,
        LEXICAL_COLUMN);
    logger.info("CSV file sorted by date.");
  }
}
