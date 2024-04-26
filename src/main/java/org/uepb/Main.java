package org.uepb;

import com.opencsv.exceptions.CsvException;
import org.uepb.utils.csv.CommunicationKindSorter;
import org.uepb.utils.csv.DateSorter;
import org.uepb.utils.csv.TimeSorter;

import java.io.IOException;

import static org.uepb.utils.csv.CSVUtils.filterCSV;


public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        // Tratando a base de dados
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


        // Ordenando a base de dados filtrada
        String inputFile = "./src/main/resources/databases/leda/test.csv";
        String outputFile = "./src/main/resources/databases/leda/test_medio_caso.csv";

        String[] algorithms = {"bubble", "counting", "heap", "insertion", "merge", "quick", "quickm3", "selection"};

        for (String algorithm : algorithms) {
            TimeSorter timeSorter = new TimeSorter();
            long startTime = System.nanoTime();
            timeSorter.sort(inputFile, outputFile, algorithm);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Algorithm: " + algorithm + ", Metric: Time" + ", Time elapsed: " + timeElapsed + " nanos");

            DateSorter dateSorter = new DateSorter();
            startTime = System.nanoTime();
            dateSorter.sort(inputFile, outputFile, algorithm);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Algorithm: " + algorithm + ", Metric: Date" + ", Time elapsed: " + timeElapsed + " nanos");

            CommunicationKindSorter communicationSorter = new CommunicationKindSorter();
            startTime = System.nanoTime();
            communicationSorter.sort(inputFile, outputFile, algorithm);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Algorithm: " + algorithm + ", Metric: CommunicationKind" + ", Time elapsed: " + timeElapsed + " nanos");
        }
    }
}
