package org.uepb.model.algorithms.shuffling.fisheyates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uepb.model.algorithms.shuffling.ShufflingTest;
import org.uepb.model.algorithms.shuffling.fisheryates.FisherYates;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FisherYatesTest extends ShufflingTest {
    @BeforeEach
    public void setup() {
        shuffle = new FisherYates();
    }

    @Test
    public void testPartialArrayIsUnorderedUsingIndexesAfterShuffle() {
        int startIndex = 0;
        int endIndex = 3;
        double[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        double[] output = FisherYates.shuffleArrayPart(input, startIndex, endIndex);

        boolean isPartiallyUnordered = isPartiallyUnordered(output, startIndex, endIndex);

        assertTrue(isPartiallyUnordered);
    }
    private boolean isPartiallyUnordered(double[] array, int startIndex, int endIndex) {
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i - 1] > array[i]) {
                return true;
            }
        }
        return false;
    }



    @Test
    public void testPositivePercentageArrayIsUnorderedUsingPercentageAfterShuffle() {
        int percentage = 40;
        double[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numElements = (int) Math.ceil(input.length * percentage/100.0);

        double[] output = FisherYates.shuffleArrayPortion(input, percentage);
        System.out.println(Arrays.toString(output));
        boolean isPartiallyUnordered = isPartiallyUnorderedPercentage(output, numElements);

        assertTrue(isPartiallyUnordered);
    }
    private boolean isPartiallyUnorderedPercentage(double[] array, int numElements) {
        for (int i = 1; i <= numElements; i++) {
            if (array[i - 1] > array[i]) {
                return true;
            }
        }
        return false;
    }



    @Test
    public void testNegativePercentageArrayIsUnorderedUsingPercentageAfterShuffle() {
        int percentage = -40;
        double[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numElementsFromEnd = (int) Math.ceil(input.length * Math.abs(percentage/100.0));


        double[] output = FisherYates.shuffleArrayPortion(input, percentage);
        System.out.println(Arrays.toString(output));
        boolean isPartiallyUnorderedFromEnd = isPartiallyUnorderedFromEnd(output, numElementsFromEnd);

        assertTrue(isPartiallyUnorderedFromEnd);
    }
    private boolean isPartiallyUnorderedFromEnd(double[] array, int numElementsFromEnd) {
        for (int i = array.length - numElementsFromEnd - 1; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
