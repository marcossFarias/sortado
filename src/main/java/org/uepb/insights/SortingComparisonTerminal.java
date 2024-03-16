package org.uepb.insights;

import org.uepb.algorithms.*;
import org.uepb.algorithms.derivations.OptimizedBubbleSort;
import org.uepb.algorithms.derivations.OptimizedSelectionSort;

import java.util.Arrays;

public class SortingComparisonTerminal {
    public static void compareSortingAlgorithms(double[] array) {
        SortAlgorithm[] algorithms = {
                new BubbleSort(),
                new OptimizedBubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new OptimizedSelectionSort(),
        };

        for (SortAlgorithm algorithm : algorithms) {
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
}
