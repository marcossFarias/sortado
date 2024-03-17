package org.uepb.model.algorithms.sorting.bubble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uepb.model.algorithms.sorting.SortingTest;

public class BubbleSortTest extends SortingTest {
    @BeforeEach
    public void setup() {
        super.setup();
        sort = new BubbleSort();
    }

    // Functionality Tests
    @Test
    public void testNumberOfSwaps() {
        double[] input = {5, 3, 1, 4, 2};
        sort.sort(input);
        Assertions.assertEquals(7, sort.getNumberOfSwaps());
    }

    @Test
    public void testNumberOfComparisons() {
        double[] input = {5, 3, 1, 4, 2};
        sort.sort(input);
        Assertions.assertEquals(10, sort.getNumberOfComparisons());
    }
}
