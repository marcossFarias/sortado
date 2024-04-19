package org.uepb.utils;

import java.io.*;
import java.util.Scanner;

import static org.uepb.utils.TimeUtils.dateTimeFormatter;

public class FileUtils {
    public static double[] readArrayFromFile(String path) {
        try {
            File file = new File(path);

            Scanner scanner = new Scanner(file);
            int count = countNumbersInFile(scanner);
            scanner.close(); //  Garantia de que o método readNumbersIntoArray usará outra instância de Scanner

            scanner = new Scanner(file);
            double[] array = readNumbersIntoArray(scanner, count);
            scanner.close();

            return array;

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
            return null;
        }
    }

    public static String writeArrayToFile(double[] array, String path) {
        String fileName = path + "_" + dateTimeFormatter() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double value : array) {
                writer.write(Double.toString(value));
                writer.newLine();
            }
            System.out.println("Array successfully written to file: " + path);
        } catch (IOException e) {
            System.err.println("Error writing array to file: " + e.getMessage());
        }

        return fileName;
    }

    private static int countNumbersInFile(Scanner scanner) {
        int count = 0;
        while (scanner.hasNextDouble()) {
            count++;
            scanner.nextDouble();
        }
        scanner.close();
        return count;
    }

    private static double[] readNumbersIntoArray(Scanner scanner, int count) {
        double[] array = new double[count];
        for (int i = 0; i < count; i++) {
            if (scanner.hasNextDouble()) {
                array[i] = scanner.nextDouble();
            }
        }
        return array;
    }
}
