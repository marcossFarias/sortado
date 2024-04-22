package org.uepb;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;
import org.uepb.model.algorithms.sorting.bubble.BubbleSort;
import org.uepb.model.algorithms.sorting.counting.CountingSort;
import org.uepb.model.algorithms.sorting.insertion.InsertionSort;
import org.uepb.model.algorithms.sorting.merge.MergeSort;
import org.uepb.model.algorithms.sorting.quick.QuickSort;
import org.uepb.model.algorithms.sorting.selection.SelectionSort;


import java.io.*;

import static org.uepb.utils.FileUtils.readArrayFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        double[] array = readArrayFromFile("");

        SortingAlgorithm[] sortingAlgorithms = {
                new BubbleSort(),
                new CountingSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort(),
                new SelectionSort()
        };

        for (SortingAlgorithm algorithm : sortingAlgorithms) {
            algorithm.sort(array);
        }
    }
}
