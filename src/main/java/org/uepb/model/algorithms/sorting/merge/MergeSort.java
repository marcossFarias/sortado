package org.uepb.model.algorithms.sorting.merge;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

public class MergeSort extends SortingAlgorithm {
    @Override
    // Método principal para ordenar o array
    public double[] sort(double[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    // Método para dividir o array em subarrays menores e ordená-los
    private void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calcula o ponto médio do array
            mergeSort(array, left, mid);  // Ordena a metade esquerda do array
            mergeSort(array, mid + 1, right); // Ordena a metade direita do array
            merge(array, left, mid, right); // Combina as duas metades ordenadas
        }
    }

    // Método para combinar dois subarrays ordenados em um único array ordenado
    private void merge(double[] array, int left, int mid, int right) {
        // Calcula o tamanho dos dois subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Cria dois subarrays temporários
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copia os elementos dos subarrays originais para os subarrays temporários
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Combina os subarrays temporários de volta ao array original
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes do subarray esquerdo para o array original
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copia os elementos restantes do subarray direito para o array original
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    }

