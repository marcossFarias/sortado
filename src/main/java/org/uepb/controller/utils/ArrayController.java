package org.uepb.controller.utils;

import org.uepb.model.algorithms.shuffling.fisheryates.FisherYates;

public class ArrayController {
    public double[] shuffleArray(double[] array, int percentage) {
        if (array == null) {
            return null;
        }
        return FisherYates.shuffleArrayPortion(array, percentage);
    }
}
