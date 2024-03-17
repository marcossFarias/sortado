package org.uepb;

import org.uepb.controller.algorithms.sorting.SortingController;
import org.uepb.model.algorithms.sorting.SortingAlgorithm;
import org.uepb.model.algorithms.sorting.bubble.BubbleSort;
import org.uepb.model.algorithms.sorting.bubble.OptimizedBubbleSort;
import org.uepb.model.algorithms.sorting.insertion.InsertionSort;
import org.uepb.model.algorithms.sorting.selection.OptimizedSelectionSort;
import org.uepb.model.algorithms.sorting.selection.SelectionSort;
import org.uepb.view.algorithms.sorting.SortingComparisonTerminal;

import static org.uepb.utils.ArrayUtils.generateRandomArray;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new OptimizedBubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new OptimizedSelectionSort(),
        };

        SortingController controller = new SortingController(algorithms, new SortingComparisonTerminal());

        //double[] array = {8, 5, 9, 2, 6, 3};
        double[] array = generateRandomArray(50);
        controller.compareAlgorithms(array);
    }
}
