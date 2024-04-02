package org.uepb.controller.utils;

import org.uepb.model.algorithms.shuffling.fisheryates.FisherYates;

public class ArrayController {
    public double[] shuffleArray(double[] array, int percentage) {
        try {
            return FisherYates.shuffleArrayPortion(array, percentage);
        }
        catch (NullPointerException e) {
            System.out.println(e);
            return null;
        }
    }
}
