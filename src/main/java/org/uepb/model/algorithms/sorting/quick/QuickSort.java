package org.uepb.model.algorithms.sorting.quick;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

public class QuickSort extends SortingAlgorithm {
    @Override
    public double[] sort(double[] array) {
        quick(array, 0, array.length - 1);
        return array;
    }
    private void quick(double[] array, int left, int right){
        if(left < right){
            int pivot = partition(array, left, right);
            quick(array, left, pivot - 1);
            quick(array, pivot + 1, right);
        }

    }
    private int partition(double[] array, int left, int right){
        double pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (array[j] <= pivot) {
                i++;

                // Troca array[i] e array[j]
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Troca array[i+1] e array[right] (ou seja, o pivot)
        double temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1;
    }
}
