package org.uepb.model.algorithms.sorting.quick;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

import java.util.Random;

public class QuickSort extends SortingAlgorithm {
    private static final int CHUNK_SIZE = 50000; // Set the chunk size here

    @Override
    public double[] sort(double[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        quickSort(array, 0, array.length - 1);

        return array;
    }

    private void quickSort(double[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            int leftChunkSize = Math.min(CHUNK_SIZE, pivotIndex - left);
            int rightChunkSize = Math.min(CHUNK_SIZE, right - pivotIndex);

            quickSort(array, left, left + leftChunkSize - 1);
            quickSort(array, right - rightChunkSize, right);

            if (leftChunkSize > 0) {
                sortChunk(array, left, left + leftChunkSize - 1);
            }
            if (rightChunkSize > 0) {
                sortChunk(array, right - rightChunkSize, right);
            }
        }
    }

    private void sortChunk(double[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            sortChunk(array, left, pivotIndex - 1);
            sortChunk(array, pivotIndex + 1, right);
        }
    }

    private int partition(double[] array, int left, int right) {
        Random random = new Random();
        int pivotIndex = random.nextInt(right - left + 1) + left;
        swap(array, pivotIndex, right);

        double pivot = array[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);

        return i;
    }

    private void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
