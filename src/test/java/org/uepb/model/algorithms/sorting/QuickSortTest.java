package org.uepb.model.algorithms.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickSortTest extends SortingTest {
    @BeforeEach
    public void setup() {
        super.setup();
        sort = new QuickSort();
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
