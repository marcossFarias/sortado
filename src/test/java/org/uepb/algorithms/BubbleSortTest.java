package org.uepb.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest extends SortTest {
    @BeforeEach
    public void setup() {
        super.setup();
        sort = new BubbleSort();
    }

    // Functionality Tests
    @Test
    public void testNumberOfSwaps() {
        int[] input = {5, 3, 1, 4, 2};
        sort.sort(input);
        Assertions.assertEquals(7, sort.getNumberOfSwaps());
    }

    @Test
    public void testNumberOfComparisons() {
        int[] input = {5, 3, 1, 4, 2};
        sort.sort(input);
        Assertions.assertEquals(10, sort.getNumberOfComparisons());
    }
}
