package org.uepb.model.algorithms.sorting;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        if (array.length <= 1) {
            return;
        }
        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        MergeSort<T> leftSort = new MergeSort<>();
        leftSort.sort(left);
        MergeSort<T> rightSort = new MergeSort<>();
        rightSort.sort(right);

        merge(array, left, right);
    }

    private void merge(T[] array, T[] left, T[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
