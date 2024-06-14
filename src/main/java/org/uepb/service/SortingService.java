package org.uepb.service;

import java.util.ArrayList;
import java.util.List;
import org.uepb.model.algorithms.SortingAlgorithm;
import org.uepb.utils.CsvUtils;

/**
 * Sorts CSV files by a specified column using a given sorting algorithm.
 */
public class SortingService {

  private final SortingAlgorithm sortingAlgorithm;

  /**
   * Constructs a SortingService object with the specified sorting algorithm.
   *
   * @param sortingAlgorithm the sorting algorithm to be used
   */
  public SortingService(SortingAlgorithm sortingAlgorithm) {
    this.sortingAlgorithm = sortingAlgorithm;
  }
  
  /**
   * Sorts a CSV file by the specified column and writes the sorted data to a new CSV file.
   *
   * @param inputFile    The path to the input CSV file.
   * @param outputFile   The path to the output CSV file where sorted data will be written
   * @param columnToSort The name of the column to sort.
   */
  public void sortCsvFileByColumn(
      String inputFile,
      String outputFile,
      String columnToSort) {
        
    List<String[]> data = CsvUtils.readCsv(inputFile);

    int columnIndex = CsvUtils.getColumnIndex(data.get(0), columnToSort);
    List<String[]> sortedData = sortLines(data, columnIndex);

    CsvUtils.writeCsv(outputFile, sortedData);
  }

  private List<String[]> sortLines(List<String[]> lines, int columnIndex) {
    List<SortableStringArray> sortableLines = new ArrayList<>();
    for (String[] line : lines.subList(1, lines.size())) {
      sortableLines.add(new SortableStringArray(line, columnIndex));
    }

    List<SortableStringArray> sortedSortableLines = sortingAlgorithm.sort(sortableLines);

    List<String[]> sortedLines = new ArrayList<>();
    sortedLines.add(lines.get(0));
    for (SortableStringArray sortableLine : sortedSortableLines) {
      sortedLines.add(sortableLine.getStringArray());
    }

    return sortedLines;
  }

  private static class SortableStringArray implements Comparable<SortableStringArray> {
    private final String[] stringArray;
    private final int index;
    
    /**
     * Constructs a SortableStringArray object with the specified string array and index.
     *
     * @param stringArray the array of strings to be sorted
     * @param index the index of the string within the array to be used for comparison
     */
    public SortableStringArray(String[] stringArray, int index) {
      this.stringArray = stringArray;
      this.index = index;
    }

    /**
     * Gets the string array associated with this object.
     *
     * @return the string array
     */
    public String[] getStringArray() {
      return stringArray;
    }

    @Override
    public int compareTo(SortableStringArray other) {
      String thisValue = stringArray[index].toLowerCase();
      String otherValue = other.stringArray[index].toLowerCase(); 
      return thisValue.compareTo(otherValue);
    }
  }
}
