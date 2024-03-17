package org.uepb;

import org.uepb.view.SortingComparisonR;
import org.uepb.view.SortingComparisonTerminal;

import javax.script.ScriptException;

import static org.uepb.utils.ArrayUtils.generateRandomArray;

public class Main {
    public static void main(String[] args) {
        //double[] numbers = {10, 48, 29, 47, 15.4, 3, -2, -45, 11, 19, 4, 27, -27.43, 23.93, 12, 44.345, 34, 25, 41, 20};

        double[] numbers = {8, 5, 9, 2, 6, 3};

        SortingComparisonTerminal.compareSortingAlgorithms(numbers);

        try {
            SortingComparisonR.gen(numbers);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }

        int[] sizes = {10, 20, 30};
        for (int size : sizes) {
            double[] arrays = generateRandomArray(size);
            SortingComparisonTerminal.compareSortingAlgorithms(arrays);
        }
    }


}
