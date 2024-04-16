package org.uepb.model.algorithms.sorting.counting;

import org.uepb.model.algorithms.sorting.SortingAlgorithm;

public class CountingSort extends SortingAlgorithm {
    @Override
    public double[] sort(double[] array) {
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

                incrementSwapsCount();
            }
            incrementComparisonsCount();
        }

        return array;
    }
}