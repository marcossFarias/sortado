package org.uepb.controller;

import java.util.logging.Logger;
import org.uepb.service.CsvFilterService;

/**
 * This class is responsible for controlling transformations on CSV files related to accidents.
 */
public class TransformationsCsvConstroller {
  private TransformationsCsvConstroller() {
    throw new IllegalStateException("Utility class");
  }

  private static final Logger logger =
      Logger.getLogger(TransformationsCsvConstroller.class.getName());

  private static final String ROAD_ACCIDENTS_FILE =
      "resources/kaggle/road_accidents_czechia_2016_2022.csv";
  private static final String ALCOHOL_ACCIDENTS_OUTPUT_FILE =
      "resources/transformations/alcohol_accidents.csv";
  private static final String ACCIDENTS_NCBMV_FILE =
      "resources/transformations/accidents_NCBMV.csv";
  private static final String CRASH_KIND_OUTPUT_FILE =
      "resources/transformations/accidents_NCBMV.csv";
  private static final String ACCIDENTS_CWFA_OUTPUT_FILE =  
      "resources/transformations/accidents_CWFA.csv";
  private static final String PEDESTRIAN_INPUT_FILE =
      "resources/kaggle/pedestrian.csv";
  private static final String DRUNK_PEDESTRIANS_OUTPUT_FILE =
      "resources/transformations/drunk_pedestrians.csv";

  /**
   * Main method to start transformations on CSV files.
   */
  public static void startCsvTransformations() {
    logger.info("Starting CSV transformations...");
    filterAlcoholAccidents();
    filterCrashKind();
    filterAccidentKind();
    filterPedestrianCondition();
    logger.info("CSV transformations completed.");
  }

  private static void filterAlcoholAccidents() {
    logger.info("Filtering alcohol-related accidents...");
    CsvFilterService.applyFilter(ROAD_ACCIDENTS_FILE,
        ALCOHOL_ACCIDENTS_OUTPUT_FILE,
        "alcohol",
        "yes");
    logger.info("Alcohol-related accidents filtered successfully.");
  }

  private static void filterCrashKind() {
    logger.info("Filtering crash kind...");
    CsvFilterService.applyFilter(ROAD_ACCIDENTS_FILE,
        CRASH_KIND_OUTPUT_FILE,
        "crash_kind",
        "not an option It is not a collision between moving vehicles");
    logger.info("Crash kind filtered successfully.");
  }

  private static void filterAccidentKind() {
    logger.info("Filtering accident kind...");
    CsvFilterService.applyFilter(ACCIDENTS_NCBMV_FILE, 
        ACCIDENTS_CWFA_OUTPUT_FILE,
        "accident_kind",
        "collision with forest animals");
    logger.info("Accident kind filtered successfully.");
  }

  private static void filterPedestrianCondition() {
    logger.info("Filtering pedestrian condition...");
    CsvFilterService.applyFilter(PEDESTRIAN_INPUT_FILE,
        DRUNK_PEDESTRIANS_OUTPUT_FILE, 
        "pedestrian_condition",
        "alcohol");
    logger.info("Pedestrian condition filtered successfully.");
  }
}
