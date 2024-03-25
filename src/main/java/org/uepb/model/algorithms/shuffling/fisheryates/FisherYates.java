package org.uepb.model.algorithms.shuffling.fisheryates;

import org.uepb.model.algorithms.shuffling.ShufflingAlgorithm;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public class FisherYates extends ShufflingAlgorithm {
    @Override
    public double[] shuffle(double[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            double temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void shuffleArrayPart(double[] array, int start, int end) {
        Random rnd = new Random();
        for (int i = end; i > start; i--) {
            int index = rnd.nextInt(i + 1 - start) + start;
            double temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static int getIndexFromPercentage(double[] array, double percentage) {
        int totalElements = array.length;
        int index = (int) Math.round(totalElements * percentage / 100.0) - 1;

        if (percentage < 0) {
            index = Math.abs(index + totalElements) + 1;
        }

        return index;
    }

    public static void shuffleArrayPortion(double[] array, double percentage) {
        int start = getIndexFromPercentage(array, percentage);

        if (percentage > 0) {
            shuffleArrayPart(array, 0, start);
        } else {
            shuffleArrayPart(array, array.length - start, array.length - 1);
        }
    }

    public static void main(String[] args) {
        double[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffleArrayPortion(testArray, 50);
        System.out.println(Arrays.toString(testArray));
    }
}
