package org.uepb.controller.algorithms.sorting;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;
import org.uepb.view.algorithms.sorting.SortingView;

public class SortingController {
    private final SortingAlgorithm[] algorithms;
    private final SortingView view;

    public SortingController(SortingAlgorithm[] algorithms, SortingView view) {
        this.algorithms = algorithms;
        this.view = view;
    }

    public void compareAlgorithms(double[] array) {
        for (SortingAlgorithm algorithm : algorithms) {
            double[] arrayCopy = array.clone();
            double[] sortedArray = algorithm.sort(arrayCopy);
            view.displaySimplifiedResults(algorithm, array, sortedArray);
        }
    }
}
