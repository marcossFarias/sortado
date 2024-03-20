package org.uepb.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

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
