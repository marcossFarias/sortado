package org.uepb;

import org.uepb.controller.algorithms.sorting.SortingController;
import org.uepb.model.algorithms.sorting.SortingAlgorithm;
import org.uepb.model.algorithms.sorting.bubble.BubbleSort;
import org.uepb.model.algorithms.sorting.bubble.OptimizedBubbleSort;
import org.uepb.model.algorithms.sorting.insertion.InsertionSort;
import org.uepb.model.algorithms.sorting.merge.MergeSort;
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
                new MergeSort(),
        };

        SortingController controller = new SortingController(algorithms, new SortingComparisonTerminal());

        System.out.println("Array Size: 100");
        double[] array100 = generateRandomArray(100);
        controller.compareAlgorithms(array100);
        System.out.print("\n\n\n");

        System.out.println("Array Size: 10,000");
        double[] array10000 = generateRandomArray(10000);
        controller.compareAlgorithms(array10000);
        System.out.print("\n\n\n");

        System.out.println("Array Size: 100,000");
        double[] array100000 = generateRandomArray(100000);
        controller.compareAlgorithms(array100000);
        System.out.print("\n\n\n");
    }
}
