package org.uepb.model.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.uepb.utils.ArrayUtils.generateRandomArray;

public abstract class SortingTest {
    protected SortingAlgorithm sort;
    protected Random random;

    @BeforeEach
    public void setup() {
        random = new Random();
    }

    /* Boundary-value analysis
     * https://en.wikipedia.org/wiki/Boundary-value_analysis
     * */
    @Test
    public void testDoubleLimits() {
        double[] input = {Double.MAX_VALUE, 0, -1, Double.MIN_VALUE, 1};
        double[] expected = {-1, Double.MIN_VALUE, 0, 1, Double.MAX_VALUE};

        sort.sort(input);

        assertArrayEquals(expected, input, 0.0001f);
    }


    // Special Cases Tests
    @Test
    public void testEmptyArray() {
        double[] input = {};
        double[] expected = {};

        sort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElementArray() {
        double[] input = {42};
        double[] expected = {42};

        sort.sort(input);

        assertArrayEquals(expected, input);
    }


    // Normal Cases Tests
    @Test
    public void testSortedArray() {
        double[] input = {1, 2, 3, 4, 5};
        double[] expected = {1, 2, 3, 4, 5};

        sort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testArrayWithDuplicates() {
        double[] input = {5, 3, 1, 4, 2, 3, 1};
        double[] expected = {1, 1, 2, 3, 3, 4, 5};

        sort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testRandomArray() {
        double[] input = generateRandomArray(1000);

        double[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        sort.sort(input);

        assertArrayEquals(expected, input);
    }


    // Resilience Cases Tests
    @Test
    public void testLargeArray() {
        double[] input = new double[16_384];
        for (int i = 0; i < input.length; i++) {
            input[i] = input.length - i;
        }

        double[] expected = new double[input.length];
        System.arraycopy(input, 0, expected, 0, input.length);
        Arrays.sort(expected);

        sort.sort(input);

        assertArrayEquals(expected, input);
    }
}
