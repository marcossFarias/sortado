package org.uepb.view;

import org.uepb.model.algorithms.sorting.bubble.OptimizedBubbleSort;
import org.uepb.model.algorithms.sorting.insertion.InsertionSort;
import org.uepb.model.algorithms.sorting.selection.OptimizedSelectionSort;
import org.uepb.model.algorithms.sorting.SortingAlgorithm;
import org.uepb.model.algorithms.sorting.bubble.BubbleSort;
import org.uepb.model.algorithms.sorting.selection.SelectionSort;

import java.util.Arrays;

public class SortingComparisonTerminal {
    public static void compareSortingAlgorithmsVerbose(double[] array) {
        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new OptimizedBubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new OptimizedSelectionSort(),
        };

        for (SortingAlgorithm algorithm : algorithms) {
            double[] arrayCopy = array.clone();
            double[] sortedArray = algorithm.sort(arrayCopy);
            long numberOfSwaps = algorithm.getNumberOfSwaps();
            long numberOfComparisons = algorithm.getNumberOfComparisons();
            long elapsedTime = algorithm.executionTime(arrayCopy);
            System.out.printf("%s:\n\tNumber of swaps = %d\tNumber of comparisons = %d\tElapsed time = %d\n\tOriginal Array = %s\n\tSorted Array = %s\n",
                    algorithm.getClass().getSimpleName(),
                    numberOfSwaps,
                    numberOfComparisons,
                    elapsedTime,
                    Arrays.toString(array),
                    Arrays.toString(sortedArray));
        }
    }

    public static void compareSortingAlgorithms(double[] array) {
        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new OptimizedBubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new OptimizedSelectionSort(),
        };

        for (SortingAlgorithm algorithm : algorithms) {
            double[] arrayCopy = array.clone();
            double[] sortedArray = algorithm.sort(arrayCopy);
            long numberOfSwaps = algorithm.getNumberOfSwaps();
            long numberOfComparisons = algorithm.getNumberOfComparisons();
            long elapsedTime = algorithm.executionTime(arrayCopy);
            System.out.printf("%s:\n\tNumber of swaps = %d\tNumber of comparisons = %d\tElapsed time = %d\n",
                    algorithm.getClass().getSimpleName(),
                    numberOfSwaps,
                    numberOfComparisons,
                    elapsedTime);
        }
    }
}
