package org.uepb.model.algorithms.sorting.selection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uepb.model.algorithms.sorting.SortingTest;

public class SelectionSortTest extends SortingTest {
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
        Assertions.assertEquals(4, sort.getNumberOfSwaps());
    }

    @Test
    public void testNumberOfComparisons() {
        // numberOfComparison is (n*(n-1)) / 2
        double[] input = {5, 3, 1, 4, 2};
        sort.sort(input);
        Assertions.assertEquals(10, sort.getNumberOfComparisons());
    }
}
