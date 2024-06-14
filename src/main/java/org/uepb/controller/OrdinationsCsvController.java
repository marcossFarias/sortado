package org.uepb.controller;

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

  public static void startCsvOrdinations() {
    FileUtils.deleteFilesInDirectory("resources/ordinations");
    
    logger.info("Starting CSV ordinations...");
    ordinateByTime();
    ordinateByDate();
    ordinateByLexical();
    logger.info("CSV ordinations completed.");
  }

  private static void ordinateByTime() {
    logger.info("Sorting CSV file by time...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        "resources/test.csv",
        "resources/ordinations/accidents_NCBMV_time",
        "time");
    logger.info("CSV file sorted by time.");
  }

  private static void ordinateByDate() {
    logger.info("Sorting CSV file by date...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        "resources/test.csv",
        "resources/ordinations/accidents_NCBMV_date",
        "date");
    logger.info("CSV file sorted by date.");
  }

  private static void ordinateByLexical() {
    logger.info("Sorting CSV file by lexical...");
    CsvSortingService.sortCsvFileByColumnForAllAlgorithms(
        "resources/test.csv",
        "resources/ordinations/accidents_NCBMV_communication_kind",
        "communication_kind");
    logger.info("CSV file sorted by date.");
  }
}
