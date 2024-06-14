package org.uepb.utils;

import java.io.File;

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
}