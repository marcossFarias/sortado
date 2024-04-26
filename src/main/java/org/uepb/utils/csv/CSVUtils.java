package org.uepb.utils.csv;

import java.io.*;

public class CSVUtils {
    public static void filterCSV(String inputFile, int columnIndex, String filterValue, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String headerLine = reader.readLine();
            writer.write(headerLine);
            writer.newLine();

            // Process the data lines
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > columnIndex && columns[columnIndex].trim().contains(filterValue)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
