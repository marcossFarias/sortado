package org.uepb.insights;

import org.uepb.algorithms.BubbleSort;
import org.uepb.algorithms.InsertionSort;
import org.uepb.algorithms.SelectionSort;
import org.uepb.algorithms.SortAlgorithm;

import java.util.Arrays;

public class SortingComparisonTerminal {
    public static void compareSortingAlgorithms(double[] array) {
        SortAlgorithm[] algorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
        };

        for (SortAlgorithm algorithm : algorithms) {
            double[] arrayCopy = array.clone();
            double[] sortedArray = algorithm.sort(arrayCopy);
            int numberOfSwaps = algorithm.getNumberOfSwaps();
            int numberOfComparisons = algorithm.getNumberOfComparisons();
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
