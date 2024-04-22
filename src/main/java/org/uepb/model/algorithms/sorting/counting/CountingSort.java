package org.uepb.model.algorithms.sorting.counting;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

public class CountingSort extends SortingAlgorithm {
    private static final int CHUNK_SIZE = 50000; // tamanho da parte do array a ser ordenado

    @Override
    public double[] sort(double[] array) {
        if (array.length <= CHUNK_SIZE) {
            return countingSort(array);
        }

        double[] sortedArray = new double[array.length];
        int startIndex = 0;

        while (startIndex < array.length) {
            int endIndex = Math.min(startIndex + CHUNK_SIZE, array.length);
            double[] chunk = new double[endIndex - startIndex];
            System.arraycopy(array, startIndex, chunk, 0, chunk.length);
            double[] sortedChunk = sortAndMerge(chunk);
            System.arraycopy(sortedChunk, 0, sortedArray, startIndex, chunk.length);
            startIndex += CHUNK_SIZE;
        }

        return sortedArray;
    }

    private double[] sortAndMerge(double[] chunk) {
        int length = chunk.length;
        double[] temp = new double[length];
        double[] left = new double[length / 2];
        double[] right = new double[length - length / 2];

        if (length > 1) {
            System.arraycopy(chunk, 0, left, 0, length / 2);
            System.arraycopy(chunk, length / 2, right, 0, length - length / 2);

            left = sortAndMerge(left);
            right = sortAndMerge(right);
        }

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                temp[k++] = left[i++];
            } else {
                temp[k++] = right[j++];
            }
        }

        while (i < left.length) {
            temp[k++] = left[i++];
        }

        while (j < right.length) {
            temp[k++] = right[j++];
        }

        System.arraycopy(temp, 0, chunk, 0, length);
        return chunk;
    }

    private double[] countingSort(double[] array) {
        double maior = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
        }

        double[] count = new double[(int) maior + 1];
        for (int i = 0; i < array.length; i++) {
            count[(int) array[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[index] = i;
                index++;
            }
        }

        return array;
    }
}