package org.uepb.insights;

import org.renjin.script.RenjinScriptEngineFactory;
import org.uepb.algorithms.BubbleSort;
import org.uepb.algorithms.InsertionSort;
import org.uepb.algorithms.SelectionSort;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class SortingComparisonR {
    public static void gen(int[] numbers) throws ScriptException {
        BubbleSort bubbleSort = new BubbleSort();
        int[] bubbleSort_array = bubbleSort.sort(numbers.clone());
        int bubbleSortComparisons = bubbleSort.getNumberOfComparisons();
        int bubbleSortSwaps = bubbleSort.getNumberOfSwaps();

        InsertionSort insertionSort = new InsertionSort();
        int[] insertionSort_array = insertionSort.sort(numbers.clone());
        int insertionSortComparisons = insertionSort.getNumberOfComparisons();
        int insertionSortSwaps = insertionSort.getNumberOfSwaps();

        SelectionSort selectionSort = new SelectionSort();
        int[] selectionSort_array = selectionSort.sort(numbers.clone());
        int selectionSortComparisons = selectionSort.getNumberOfComparisons();
        int selectionSortSwaps = selectionSort.getNumberOfSwaps();

        RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();

        engine.put("bubbleSortComparisons", bubbleSortComparisons);
        engine.put("bubbleSortSwaps", bubbleSortSwaps);
        engine.put("insertionSortComparisons", insertionSortComparisons);
        engine.put("insertionSortSwaps", insertionSortSwaps);
        engine.put("selectionSortComparisons", selectionSortComparisons);
        engine.put("selectionSortSwaps", selectionSortSwaps);

        engine.eval("png(file='myplot.png')");

        engine.eval("df <- data.frame(Algorithm = c('BubbleSort', 'BubbleSort', 'InsertionSort', 'InsertionSort', 'SelectionSort', 'SelectionSort')," +
                "Type = c('Comparisons', 'Swaps', 'Comparisons', 'Swaps', 'Comparisons', 'Swaps')," +
                "Count = c(bubbleSortComparisons, bubbleSortSwaps, insertionSortComparisons, insertionSortSwaps, selectionSortComparisons, selectionSortSwaps))");

        engine.eval("df$Algorithm <- factor(df$Algorithm, levels = unique(df$Algorithm))");
        engine.eval("df$Type <- factor(df$Type, levels = unique(df$Type))");
        engine.eval("df$Count <- as.numeric(df$Count)");
        engine.eval("bp <- barplot(height = df$Count, names.arg = df$Algorithm, col = rainbow(length(unique(df$Type))), ylim = c(0, max(df$Count) * 1.1), legend.text = unique(df$Type), args.legend = list(x = 'topright'))");

        // Linhas e dados para melhorar a visualização e o entendimento
        engine.eval("text(x = bp, y = df$Count, label = df$Count, pos = 3, cex = 0.8, col = 'black')");
        engine.eval("abline(h = seq(0, max(df$Count), by = max(df$Count)/10), col = \"lightgray\", lty = \"dotted\")");


        engine.eval("par(usr = c(0, 1, 0, log10(max(df$Count) * 1.1)), log = 'y')"); // Garante que o eixo Y nunca seja maior ou menor que os dados

        engine.eval("dev.off()");
    }
}
