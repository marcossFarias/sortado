package org.uepb.service;


import org.uepb.controller.utils.ArrayController;

import static org.uepb.utils.FileUtils.writeArrayToFile;
import static org.uepb.utils.FileUtils.readArrayFromFile;
import static org.uepb.utils.TimeUtils.dateTimeFormatter;


public class ArrayService {
    private final ArrayController controller;

    public ArrayService(ArrayController controller) {
        this.controller = controller;
    }

    public void shuffleArrayFromFile(String path, int percentage) {
        double[] array = readArrayFromFile(path);
        double[] result = controller.shuffleArray(array, percentage);
        writeArrayToFile(result, "shuffled-array-" + percentage + "-" + dateTimeFormatter() + ".txt");
    }
}
