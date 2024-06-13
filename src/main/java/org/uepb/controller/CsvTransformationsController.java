package org.uepb.controller;

import org.uepb.service.CsvFilterService;

public class CsvTransformationsController {

  public static void alcoholAccidents() {
    CsvFilterService.applyFilter("resources/road_accidents_czechia_2016_2022.csv",
        "resources/transformations/alcohol_accidents.csv", 
        "alcohol",
        "yes");
  }

  public static void crashKind() {
    CsvFilterService.applyFilter("resources/road_accidents_czechia_2016_2022.csv",
        "resources/transformations/accidents_NCBMV.csv", 
        "crash_kind",
        "not an option It is not a collision between moving vehicles");
  }

  public static void accidentsKind() {
    CsvFilterService.applyFilter("resources/transformations/accidents_NCBMV.csv",
        "resources/transformations/accidents_CWFA.csv",
        "accident_kind",
        "collision with forest animals");
  }

  public static void pedestrianCondition() {
    CsvFilterService.applyFilter("resources/pedestrian.csv",
        "resources/transformations/drunk_pedestrians.csv",
        "pedestrian_condition",
        "alcohol");
  }

  public static void main(String[] args) {
    alcoholAccidents();
    crashKind();
    accidentsKind();
    pedestrianCondition();

  }
}
