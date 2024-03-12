package org.uepb.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortTest {
    protected SortAlgorithm sort;
    protected Random random;

    @BeforeEach
    public void setup() {
        random = new Random();
    }

    /* Boundary-value analysis
     * https://en.wikipedia.org/wiki/Boundary-value_analysis
     * */
    @Test
    public void testIntegerLimits() {
        int[] input = {Integer.MAX_VALUE, 0, -1, Integer.MIN_VALUE, 1};
        int[] expected = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
        sort.sort(input);
        assertArrayEquals(expected, input);
    }


    // Special Cases Tests
    @Test
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElementArray() {
        int[] input = {42};
        int[] expected = {42};
        sort.sort(input);
        assertArrayEquals(expected, input);
    }


    // Normal Cases Tests
    @Test
    public void testSortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] input = {5, 3, 1, 4, 2, 3, 1};
        int[] expected = {1, 1, 2, 3, 3, 4, 5};
        sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRandomArray() {
        int[] input = generateRandomArray(1000);
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        sort.sort(input);

        assertArrayEquals(expected, input);
    }
    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }


    // Resilience Cases Tests
    @Test
    public void testLargeArray() {
        int[ ] input = new int[16384];
        for (int i = 0; i < input.length; i++) {
            input[i] = input.length - i;
        }

        int[] expected = new int[input.length];
        System.arraycopy(input, 0, expected, 0, input.length);

        Arrays.sort(expected);

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }
}
