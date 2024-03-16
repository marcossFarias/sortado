package org.uepb;

import org.uepb.insights.SortingComparisonR;
import org.uepb.insights.SortingComparisonTerminal;

import javax.script.ScriptException;

/*
* https://fastercapital.com/content/Comparisons-and-Swaps--Understanding-Sortinoratio-Operations.html
* https://stackoverflow.com/questions/42810832/number-of-swaps-and-comparisons-in-bubble-selection-insertion-and-quick-sorts
* https://www.baeldung.com/java-measure-elapsed-time
* https://www.baeldung.com/java-microbenchmark-harness
* https://www.baeldung.com/cs/straight-selection-sort
*
* */

public class Main {
    public static void main(String[] args) {
        //double[] numbers = {10, 48, 29, 47, 15.4, 3, -2, -45, 11, 19, 4, 27, -27.43, 23.93, 12, 44.345, 34, 25, 41, 20};
        /*
        double[] numbers = {8, 5, 9, 2, 6, 3};

        SortingComparisonTerminal.compareSortingAlgorithms(numbers);

        try {
            SortingComparisonR.gen(numbers);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        */
        int[] sizes = {10, 20, 30};
        for (int size : sizes) {
            double[] arrays = generateRandomArray(size);
            SortingComparisonTerminal.compareSortingAlgorithms(arrays);
        }
    }

    private static double[] generateRandomArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.random();
        }
        return array;
    }
}
