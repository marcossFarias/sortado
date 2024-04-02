package org.uepb.model.algorithms.shuffling;

import java.security.SecureRandom;

public abstract class ShufflingAlgorithm {
    protected static final SecureRandom secureRnd = new SecureRandom();

    public abstract double[] shuffle(double[] array);

}
