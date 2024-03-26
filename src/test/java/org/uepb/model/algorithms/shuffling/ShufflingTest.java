package org.uepb.model.algorithms.shuffling;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.uepb.utils.ArrayUtils.generateRandomArray;

public abstract class ShufflingTest {
    protected ShufflingAlgorithm shuffle;

    @Test

    public void testArrayWithVariousSizes() {
        for (int size = 10; size <= 100; size++) {
            double[] input = generateRandomArray(size);

            shuffle.shuffle(input);

            boolean isUnordered = isUnordered(input);

            assertTrue(isUnordered);
        }
    }

    @Test
    public void testArrayIsUnorderedAfterRun() {
        double[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        shuffle.shuffle(input);

        boolean isUnordered = isUnordered(input);

        assertTrue(isUnordered);
    }
    private boolean isUnordered(double[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testArrayWithRepeatedValues() {
        double[] input = {1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 8, 9, 10};
        shuffle.shuffle(input);
        boolean hasRepeatedValues = hasRepeatedValues(input);
        assertTrue(hasRepeatedValues);
    }
    private boolean hasRepeatedValues(double[] array) {
        Set<Double> set = new HashSet<>();
        for (double value : array) {
            if (set.contains(value)) {
                return true;
            }
            set.add(value);
        }
        return false;
    }

    // Special Cases Tests
    @Test
    public void testEmptyArray() {
        double[] input = {};
        double[] expected = {};

        shuffle.shuffle(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElementArray() {
        double[] input = {42};
        double[] expected = {42};

        shuffle.shuffle(input);

        assertArrayEquals(expected, input);
    }
}
