package org.uepb.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectionSortTest extends SortTest {
    @BeforeEach
    public void setup() {
        super.setup();
        sort = new SelectionSort();
    }

    // Functionality Tests
    @Test
    public void testNumberOfSwaps() {
        double[] input = {5, 3, 1, 4, 2};
        sort.sort(input);
        Assertions.assertEquals(3, sort.getNumberOfSwaps());
    }

    @Test
    public void testNumberOfComparisons() {
        // numberOfComparison is (n*(n-1)) / 2
        double[] input = {5, 3, 1, 4, 2};
        sort.sort(input);
        Assertions.assertEquals(10, sort.getNumberOfComparisons());
    }
}
