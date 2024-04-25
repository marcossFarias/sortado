package org.uepb;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.uepb.model.algorithms.sorting.BubbleSort;
import org.uepb.model.algorithms.sorting.CountingSort;
import org.uepb.model.algorithms.sorting.SortingAlgorithm;
import org.uepb.model.algorithms.sorting.InsertionSort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.uepb.utils.CSVUtils.*;

public class Main {
    public static void mai2n(String[] args) throws IOException {
        String road_acccidents_inputFile = "./src/main/resources/databases/leda/road_accidents_czechia_2016_2022.csv";
        String pedestrian_inputFile = "./src/main/resources/databases/leda/pedestrian.csv";

        // Gere um arquivo chamado “alcohol_accidents.csv” a partir do arquivo “road_accidents_czechia_2016_2022.csv”,
        // filtrar os acidentes em que houve detecção do ingerimento de bebida alcoólica. (filtrar pelo campo alcohol)
        String alcohol_OutputFile = "./src/main/resources/databases/leda/alcohol_accidents.csv";
        filterCSV(road_acccidents_inputFile, 9, "yes", alcohol_OutputFile);


        //  Gere um arquivo chamado ”accidents_NCBMV.csv”, filtre pelo campo “crash_kind” os acidentes em que não houve
        //  colisão entre veículos em movimento. (filtrando por: not an option It is not a collision between moving vehicles)
        String accidentsNCBMV_OutputFile = "./src/main/resources/databases/leda/accidents_NCBMV.csv";
        filterCSV(road_acccidents_inputFile, 5, "not an option", accidentsNCBMV_OutputFile);


        // Considere o arquivo gerado no item 2 (accidents_NCBMV.csv), filtre pelo campo “accident_kind” os acidentes
        // causados por animais da floresta. (collision with forest animals)
        String accident_kind_OutputFile = "./src/main/resources/databases/leda/accident_kind.csv";
        filterCSV(accidentsNCBMV_OutputFile, 4, "forest animals", accident_kind_OutputFile);

        // Filtre pela coluna “pedestrian_category.csv” no arquivo “pedestre.csv” os pedestres que estavam sob a
        // influência de álcool.
        String drunk_pedestrians_OutputFile = "./src/main/resources/databases/leda/drunk_pedestrians.csv";
        filterCSV(pedestrian_inputFile, 3, "alcohol", drunk_pedestrians_OutputFile);


    }

    public static void main2(String[] args) {
        String[][] data =  readCSV("./src/main/resources/databases/leda/test.csv");


        double[] numbers = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            numbers[i] = Double.parseDouble(data[i][3]);
        }

        long[] ids = new long[data.length];
        for (int i = 0; i < data.length; i++) {
            ids[i] = Integer.parseInt(data[i][0]);
        }

        SortingAlgorithm sortingAlgorithm = new InsertionSort();
        // sortingAlgorithm.sort(numbers);

        String[][] sortedData = new String[numbers.length][1];
        for (int i = 0; i < numbers.length; i++) {
            sortedData[i][0] = String.valueOf(numbers[i]);
        }

        String[] headers = {
                "id",
                "communication_kind",
                "date",
                "time",
                "accident_kind",
                "crash_kind",
                "fixed_precaution_kind",
                "injury",
                "cause_of_accident",
                "alcohol",
                "main_cause_of_accident",
                "killed_persons",
                "severely_injured_persons",
                "slightly_injured_persons",
                "total_material_damage",
                "road_surface_type",
                "condition_of_vehicle_surface",
                "condition_of_communication",
                "weather_conditions_at_the_time_of_accident",
                "visibility",
                "visibility_ratios",
                "communication_division",
                "communication_accident_situation",
                "traffic_control_at_the_time_of_an_accident",
                "local_administration_priority_in_traffic",
                "specific_location_and_objects_in_the_location_of_the_accident",
                "directional_rates",
                "number_of_vehicles_involved",
                "location_of_the_traffic_accident",
                "vehicle_type",
                "vehicle_brand",
                "year_of_manufacture",
                "vehicle_owner",
                "skid",
                "vehicle_sequel",
                "leakage_of_transported_materials",
                "way_of_releasing_persons_from_the_vehicle",
                "direction_of_movement",
                "damage_to_the_vehicle(in_hundred_crowns)",
                "driver_category",
                "driver_condition",
                "driver_external_influence",
                "city",
                "street",
                "road_type",
                "location"
        };

        writeCSV("./src/main/resources/databases/leda/test_output.csv", headers, ids, sortedData, data);
    }

    public static void main3(String[] args) {
        Integer[] array = {5, 3, 8, 4, 2};
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        insertionSort.sort(array);
        for (Integer num : array) {
            System.out.print(num + " ");
        }

        System.out.println();

        Integer[] array2 = {5, 3, 8, 4, 2};
        CountingSort<Integer> countingSort = new CountingSort<>();
        countingSort.sort(array2);
        for (Integer num : array2) {
            System.out.print(num + " ");
        }

        System.out.println();

        Integer[] array3 = {5, 3, 8, 4, 2};
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(array3);
        for (Integer num : array3) {
            System.out.print(num + " ");
        }

    }

    public static void main(String[] args) throws IOException {
        String inputFile = "./src/main/resources/databases/leda/test.csv";
        String outputFile = "./src/main/resources/databases/leda/test-output.csv";
        String outputFile2 = "./src/main/resources/databases/leda/test-output2.csv";
        String outputFile3 = "./src/main/resources/databases/leda/test-output3.csv";

        // Read the CSV file
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
        List<CSVRecord> allData = parser.getRecords();

        // 2. Extrair a coluna numérica que você deseja ordenar
        List<Integer> numericColumn = new ArrayList<>();
        for (CSVRecord row : allData) {
            numericColumn.add(Integer.parseInt(row.get("time")));
        }
        // 3. Ordenar a lista usando o algoritmo BubbleSort
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] numericArray = numericColumn.toArray(new Integer[0]);
        bubbleSort.sort(numericArray);
        try (CSVPrinter printer = CSVFormat.EXCEL.print(new FileWriter(outputFile))) {
            for (Integer sortedValue : numericArray) {
                for (CSVRecord row : allData) {
                    if (Integer.parseInt(row.get("time")) == sortedValue) {
                        printer.printRecord(row);
                        break;
                    }
                }
            }
        }



        List<Long> dateColumn = new ArrayList<>();
        for (CSVRecord row : allData) {
            String dateString = row.get("date");
            Long dateValue = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE).toEpochDay() * 24 * 60 * 60; // Convert to Unix timestamp
            dateColumn.add(dateValue);
        }

        BubbleSort<Long> bubbleSort2 = new BubbleSort<>();
        Long[] dateArray = dateColumn.toArray(new Long[0]);
        bubbleSort2.sort(dateArray);

        try (CSVPrinter printer = CSVFormat.EXCEL.print(new FileWriter(outputFile2))) {
            for (Long sortedValue : dateArray) {
                for (CSVRecord row : allData) {
                    if ((long) LocalDate.parse(row.get("date"), DateTimeFormatter.ISO_DATE).toEpochDay() * 24 * 60 * 60 == sortedValue) { // Convert back to date string
                        printer.printRecord(row);
                        break;
                    }
                }
            }
        }



        List<String> communicationKindColumn = new ArrayList<>();
        for (CSVRecord row : allData) {
            String communicationKind = row.get("communication_kind");
            communicationKindColumn.add(communicationKind);
        }

        BubbleSort<String> bubbleSort3 = new BubbleSort<>();
        String[] communicationKindArray = communicationKindColumn.toArray(new String[0]);
        bubbleSort3.sort(communicationKindArray);

        try (CSVPrinter printer = CSVFormat.EXCEL.print(new FileWriter(outputFile3))) {
            for (String sortedValue : communicationKindArray) {
                for (CSVRecord row : allData) {
                    if (row.get("communication_kind").equals(sortedValue)) {
                        printer.printRecord(row);
                        break;
                    }
                }
            }
        }




    }
}
