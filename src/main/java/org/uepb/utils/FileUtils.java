package org.uepb.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * This class provides utility methods for file operations.
 */
public class FileUtils {
  private FileUtils() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Deletes all files within a directory.
   *
   * @param directoryPath The path to the directory.
   * @return True if all files are successfully deleted, otherwise false.
   */
  public static boolean deleteFilesInDirectory(String directoryPath) {
    File directory = new File(directoryPath);

    if (directory.exists() && directory.isDirectory()) {
      File[] files = directory.listFiles();

      if (files != null) {
        for (File file : files) {
          if (!file.delete()) {
            System.err.println("Failed to delete file: " + file.getName());
            return false;
          }
          System.out.println("File deleted: " + file.getName());
        }
        return true;
      } else {
        System.out.println("The directory is empty.");
        return true;
      }
    } else {
      System.err.println("The specified directory does not exist or is not a directory.");
      return false;
    }
  }

  public static void renameAndCopyFile(
        String inputFilePath,
        String additionalNamePart,
        String destinationDirectory) {
    try {
      File inputFile = new File(inputFilePath);
      if (!inputFile.exists()) {
        return;
      }

      String outputFileName = inputFile.getName().replace(".csv", additionalNamePart + ".csv");

      String outputFilePath = destinationDirectory + File.separator + outputFileName;
      Path destinationPath = Paths.get(outputFilePath);

      Files.copy(Paths.get(inputFilePath), destinationPath, StandardCopyOption.REPLACE_EXISTING);

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
