package org.uepb.view.algorithms.sorting;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

import java.util.Arrays;

public class SortingComparisonTerminal implements SortingView {
    @Override
    public void displayResults(SortingAlgorithm algorithm, double[] originalArray, double[] sortedArray) {
        double numberOfSwaps = algorithm.getNumberOfSwaps();
        double numberOfComparisons = algorithm.getNumberOfComparisons();
        double elapsedTime = algorithm.executionTime(originalArray.clone());

        System.out.printf("%s:\n\tNumber of swaps = %.0f\tNumber of comparisons = %.0f\tElapsed time = %.0f\n\tOriginal Array = %s\n\tSorted Array = %s\n",
                algorithm.getClass().getSimpleName(),
                numberOfSwaps,
                numberOfComparisons,
                elapsedTime,
                Arrays.toString(originalArray),
                Arrays.toString(sortedArray));
    }

    @Override
    public void displaySimplifiedResults(SortingAlgorithm algorithm, double[] originalArray, double[] sortedArray) {
        double numberOfSwaps = algorithm.getNumberOfSwaps();
        double numberOfComparisons = algorithm.getNumberOfComparisons();
        double elapsedTime = algorithm.executionTime(originalArray.clone());

        System.out.printf("%s:\n\tNumber of swaps = %.0f\tNumber of comparisons = %.0f\tElapsed time = %.0f\n",
                algorithm.getClass().getSimpleName(),
                numberOfSwaps,
                numberOfComparisons,
                elapsedTime);
    }
}
