package org.uepb.model.algorithms.sorting.merge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uepb.model.algorithms.sorting.SortingTest;
import org.uepb.model.algorithms.sorting.insertion.InsertionSort;

public class MergeSortTest extends SortingTest{
    @BeforeEach
    public void setup() {
        super.setup();
        sort = new MergeSort();
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
        double[] input = {5, 2, 4, 1, 3};
        sort.sort(input);
        Assertions.assertEquals(9, sort.getNumberOfComparisons());
    }
}
