package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Creates an object that contains a text source file, a list of its unique distinguished lines, and a Map of these lines and their number occurrences in the source file.
 */
public class CountDataFromFile implements ISymptomCounter{

    /**
     * is the source file path.
     */
    private String filepath;
    /**
     * is the list of each unique lines found in source file.
     */
    private List<String> listToCountInFile;
    /**
     * is a Map with each unique line keys and how many times they are found in text file as key value.
     */
    private Map<String, Integer> mapOfCount;

    /**
     * Instantiates a blank TreeMap, and its default blank ArrayList, filepath "file.txt"
     */
    public CountDataFromFile(){
        this.filepath = "file.txt";
        this.listToCountInFile = new ArrayList<>();
        this.mapOfCount = new TreeMap<>();
    }

    /**
     * Constructor that instantiates a CountDataFromFile Object
     * with a blank TreeMap a specified source file and a specified list of lines which are to be counted in this file.
     * @param pFilePath is the relative filepath of the file to be read and counted
     * @param pList is a list of String compared to each line in the file you want to count. If lines and String in the list are the same then it will be counted in the map with count() method.
     */
    public CountDataFromFile(String pFilePath, List<String> pList){
        this.filepath = pFilePath;
        this.listToCountInFile = pList;
        this.mapOfCount = new TreeMap<>();
    }


    /**
     * A method that will count number of symptom lines of the same occurrence.
     * @return a map containing each line as a key and its associated integer number as the count.
     */
    public Map<String, Integer> countSymptoms(){
        return this.count(false);
    }

    /**
     * A method that will count number of line of the same occurrence.
     * @param verbose true enables the verbose mode.
     * @return a map containing each line as a key and its associated integer number as the count.
     */
    public Map<String, Integer> count(boolean verbose){
        if(verbose){System.out.println("\nStarting counting symptoms...");}

        //Init keys of the map and associates 0 as value.
        for(String element : this.listToCountInFile){
            this.mapOfCount.put(element, 0);
        }

        BufferedReader reader = null;
        try{
            //Creation of a buffer "line" that will run through each line of the counted file.
            reader = new BufferedReader (new FileReader(this.filepath));
            String line = reader.readLine();

            //Read every line of the file until it reaches the end
            while (line!=null){
                if(!line.equals("")) {
                    if(this.listToCountInFile.contains(line)) {
                        this.mapOfCount.put(line, this.mapOfCount.get(line) + 1);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
            if(verbose){System.out.println("Counting ended successfully.");}
        }

        catch(NullPointerException e){
            System.out.println("\n \n \n==========================================================");
            System.out.println("Error !  make sure list is ok with no null values inside.");
            System.out.println("==========================================================\n");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("\nAn error has occured in " + this.getClass()+".");
            System.out.println(this.filepath + " : No such file or directory !");
            System.out.println("Please see details below  :\n");
            e.printStackTrace();
        }

        //Force to close the reader buffer even in case of error throwing
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return this.mapOfCount;
    }

    /**
     * Shows the map
     */
    public void show(){
        System.out.println("\nHere is the list of unique symptoms extracted from the file !");
        System.out.println("\n"+this.mapOfCount.entrySet());
        System.out.println("\nThere are " + this.mapOfCount.keySet().toArray().length + " different symptoms in total.");
    }

}
