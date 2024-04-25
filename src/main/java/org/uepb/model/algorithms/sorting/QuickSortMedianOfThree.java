package org.uepb.model.algorithms.sorting;

public class QuickSortMedianOfThree<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    private int partition(T[] array, int low, int high) {
        T pivot = medianOfThree(array, low, high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
    }

    private T medianOfThree(T[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (array[low].compareTo(array[mid]) > 0) {
            if (array[mid].compareTo(array[high]) < 0) {
                return array[mid];
            } else if (array[low].compareTo(array[high]) > 0) {
                return array[high];
            } else {
                return array[low];
            }
        } else {
            return array[low];
        }
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}