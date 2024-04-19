package org.uepb;

import org.uepb.controller.algorithms.sorting.SortingController;
import org.uepb.controller.utils.ArrayController;
import org.uepb.model.algorithms.sorting.SortingAlgorithm;
import org.uepb.model.algorithms.sorting.bubble.BubbleSort;
import org.uepb.model.algorithms.sorting.bubble.OptimizedBubbleSort;
import org.uepb.model.algorithms.sorting.insertion.InsertionSort;
import org.uepb.model.algorithms.sorting.merge.MergeSort;
import org.uepb.model.algorithms.sorting.quick.QuickSort;
import org.uepb.model.algorithms.sorting.selection.OptimizedSelectionSort;
import org.uepb.model.algorithms.sorting.selection.SelectionSort;
import org.uepb.service.ArrayService;
import org.uepb.view.algorithms.sorting.SortingComparisonTerminal;

import java.util.*;

import static java.util.Arrays.sort;
import static org.uepb.utils.ArrayUtils.generateRandomArray;
import static org.uepb.utils.ArrayUtils.generateUniqueIntArray;
import static org.uepb.utils.FileUtils.readArrayFromFile;
import static org.uepb.utils.FileUtils.writeArrayToFile;

public class Main {
    public static void main(String[] args) {

    }
}
