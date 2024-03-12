package org.uepb;

import org.uepb.insights.SortingComparisonR;
import org.uepb.insights.SortingComparisonTerminal;

import javax.script.ScriptException;

/*
* https://fastercapital.com/content/Comparisons-and-Swaps--Understanding-Sortinoratio-Operations.html
* https://stackoverflow.com/questions/42810832/number-of-swaps-and-comparisons-in-bubble-selection-insertion-and-quick-sorts
* https://www.baeldung.com/java-measure-elapsed-time
* https://www.baeldung.com/java-microbenchmark-harness
* https://www.baeldung.com/cs/straight-selection-sort
*
* */

public class Main {
    public static void main(String[] args) {
        double[] numbers = {10, 48, 29, 47, 15.4, 3, 41, -2, -45, 11, 19, 4, 27, -27.43, 23.93, 12, 45, 44.345, 34, 25, 41, 20};
        SortingComparisonTerminal.compareSortingAlgorithms(numbers);

        try {
            SortingComparisonR.gen(numbers);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }
}
