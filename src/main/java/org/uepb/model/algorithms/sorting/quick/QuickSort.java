package org.uepb.model.algorithms.sorting.quick;

import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction {
    private final double[] array;
    private final int left;
    private final int right;

    public QuickSort(double[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            // Parte que envolve a recursão e o fork-join
            int pivotIndex = partition(array, left, right);
            QuickSort leftTask = new QuickSort(array, left, pivotIndex - 1);
            QuickSort rightTask = new QuickSort(array, pivotIndex + 1, right);
            leftTask.fork(); // Fork da tarefa da esquerda
            rightTask.fork(); // Fork da tarefa da direita
            leftTask.join(); // Espera a tarefa da esquerda terminar
            rightTask.join(); // Espera a tarefa da direita terminar
        }
    }

    private int partition(double[] array, int left, int right) {
        double pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        double temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }


}
