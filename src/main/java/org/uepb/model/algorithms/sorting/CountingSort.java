package org.uepb.model.algorithms.sorting;


public class CountingSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        T max = array[0];
        for (T t : array) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }

        int maxValue = max.compareTo(array[0]) + 1;
        int[] countArray = new int[maxValue];

        for (T t : array) {
            countArray[t.compareTo(array[0])]++;
        }

        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                array[index++] = getValueAtIndex(array, i);
                countArray[i]--;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private T getValueAtIndex(T[] array, int index) {
        return array[index];
    }
}
