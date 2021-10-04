package com.hemebiotech.analytics;

import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountDataFromFile implements ISymptomCounter{

    private String filepath;
    private List<String> listToCountInFile;
    private Map<String, Integer> mapOfCount;

    /**
     * Constructor that instantiates its mapOfCount, and its default blank ArrayList<String> and filepath "file.txt"
     */
    public CountDataFromFile(){
        this.filepath = "file.txt";
        this.listToCountInFile = new ArrayList<String>();
        this.mapOfCount = new TreeMap<>();
    }

    /**
     * Constructor that instantiates a CountDataFromFile Object
     * with a blank HashMap<String, Integer> as it mapOfCount
     * @param pFilePath is the relative filepath of the file to be read and counted
     * @param pList is a list of String compared to each line in the file you want to count. If lines and String in the list are the same then it will be counted in the map with count() method.
     */
    public CountDataFromFile(String pFilePath, List<String> pList){
        this.filepath = pFilePath;
        this.listToCountInFile = pList;
        this.mapOfCount = new TreeMap<>();
    }

    /**
     * A method that will count number of line of the same occurrence.
     * @return a map containing each line as a key and its associated integer number as the count.
     */
    @Override
    public Map<String, Integer> count(){
        return this.count(false);
    }
    /**
     * A method that will count number of line of the same occurrence.
     * @param verbose true enables the bermose mode of the method.
     * @return a map containing each line as a key and its associated integer number as the count.
     */
    public Map<String, Integer> count(boolean verbose){
        if(verbose){System.out.println("\nStarting counting symptoms...");}

        //Init keys of the map and associates 0 as value.
        for(int i = 0; i < this.listToCountInFile.size(); i++){
            this.mapOfCount.put(listToCountInFile.get(i), 0);
        }

        try{
            //Creation of a buffer "line" that will run through each line of the counted file.
            BufferedReader reader = new BufferedReader (new FileReader(this.filepath));
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

    void checkDuplicates(){
        System.out.println("\nBe careful your list contains duplicates\n");
    }
}
