package org.uepb.model.algorithms.sorting;

import java.util.Arrays;

public class CountingSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        T maxValue = getMaxValue(array);
        int[] counts = new int[maxValue.compareTo(getMinValue(array)) + 1];
        T[] output = Arrays.copyOf(array, array.length);

        for (T element : array) {
            counts[element.compareTo(getMinValue(array))]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            array[counts[output[i].compareTo(getMinValue(array))] - 1] = output[i];
            counts[output[i].compareTo(getMinValue(array))]--;
        }
    }

    private T getMaxValue(T[] array) {
        T maxValue = array[0];
        for (T element : array) {
            if (element.compareTo(maxValue) > 0) {
                maxValue = element;
            }
        }
        return maxValue;
    }

    private T getMinValue(T[] array) {
        T minValue = array[0];
        for (T element : array) {
            if (element.compareTo(minValue) < 0) {
                minValue = element;
            }
        }
        return minValue;
    }
}