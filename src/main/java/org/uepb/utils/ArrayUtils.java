package org.uepb.utils;

import java.util.*;

import org.uepb.utils.FileUtils;

public class ArrayUtils {
    public static double[] generateRandomArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    public static int[] generateUniqueIntArray(int minValue, int maxValue, int size) {
        Random random = new Random();

        Set<Integer> uniqueNumbers = new HashSet<>();
        int[] result = new int[size];

        while (uniqueNumbers.size() < size) {
            int randomValue = random.nextInt(minValue, maxValue);
            uniqueNumbers.add(randomValue);
        }

        int index = 0;
        for (int number : uniqueNumbers) {
            result[index++] = number;
        }

        return result;
    }
}
