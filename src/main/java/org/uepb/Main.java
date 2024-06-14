package org.uepb;

import org.uepb.controller.OrdinationsCsvController;
import org.uepb.controller.TransformationsCsvConstroller;

public class Main {
  public static void main(String[] args) {
    TransformationsCsvConstroller.startCsvTransformations();
    OrdinationsCsvController.startCsvOrdinations();
  }
}
