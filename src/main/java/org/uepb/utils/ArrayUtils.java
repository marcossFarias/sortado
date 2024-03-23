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
// unicos
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

    public static Map<Integer, Integer> checkRepeatedNumbers(int[] array) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int num : array) {
            if (numberCount.containsKey(num)) {
                numberCount.put(num, numberCount.get(num) + 1);
            } else {
                numberCount.put(num, 1);
            }
        }
        return numberCount;
    }

    public static void main(String[] args) {
        int[] array = (generateUniqueIntArray(Integer.MIN_VALUE, Integer.MAX_VALUE, 1_000_000));
        FileUtils.printArrayToFile(array, "./test-array-1M");
        System.out.println(array.length);

        int[] array2 = (generateUniqueIntArray(Integer.MIN_VALUE, Integer.MAX_VALUE, 2_000_000));
        FileUtils.printArrayToFile(array2, "./test-array-2M");
        System.out.println(array2.length);

        int[] array3 = (generateUniqueIntArray(Integer.MIN_VALUE, Integer.MAX_VALUE, 3_000_000));
        FileUtils.printArrayToFile(array3, "./test-array-3M");
        System.out.println(array3.length);
    }
}
