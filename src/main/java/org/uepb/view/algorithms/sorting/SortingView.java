package org.uepb.view.algorithms.sorting;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

public interface SortingView {
    void displayResults(SortingAlgorithm algorithm, double[] originalArray, double[] sortedArray);

    void displaySimplifiedResults(SortingAlgorithm algorithm, double[] originalArray, double[] sortedArray);

}
