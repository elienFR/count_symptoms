package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class WriteMapStringIntegerToFile implements ISymptomWriter {
    private String outputFilePath;
    private Map<String, Integer> mapToBeWritten;

    /**
     * Constructor creates empty map
     */
    public WriteMapStringIntegerToFile(){
        this.mapToBeWritten = new HashMap<>();
    }

    /**
     * Constructor with specific map
     * @param pMap is the Map to be written to file later
     *
     */
    public WriteMapStringIntegerToFile(Map<String, Integer> pMap){
        this.mapToBeWritten = pMap;
    }


    /**
     * Methods that writes the content of mapToBeWritten
     * in the root folder to a file called result.out
     */
    public void writeToFile(){
        this.writeToFile("results.out");
    }

    /**
     * Methods that writes the content of mapToBeWritten
     * in the root folder to a file called with what pFilePath contains
     * @param pFilePath is the name of the output file create
     */
    public void writeToFile(String pFilePath){
        try{
            FileWriter writer = new FileWriter (pFilePath);

            System.out.println("\nStart writing file...");

            writer.write("This file has been generated by " + this.getClass() + " :\n\n");

            for (Object s : this.mapToBeWritten.keySet().toArray()){
                writer.write(s + ", " + this.mapToBeWritten.get(s) + "\n");
            }
            writer.write("\nEnd of counting.");

            System.out.println("\nFile written ! Closing buffer...");
            writer.close();
            System.out.println("Closed, writing ended normally.");

        } catch(Exception e) {
            System.out.println("An error occurred during file writing.");
            System.out.println("See error below :\n");
            e.printStackTrace();
        }
    }

    /**
     * Shows what is going to be written in the output file
     */
    public void show(){
        System.out.println("\nHere is what is going to be written in the file :");
        System.out.println("------------------- BEGINNING -------------------");
        System.out.print("This file has been generated by " + this.getClass() + " :\n\n");
        for (Object s : this.mapToBeWritten.keySet().toArray()){
            System.out.print(s + ", " + this.mapToBeWritten.get(s) + "\n");
        }
        System.out.print("\nEnd of counting.\n");
        System.out.println("-------------------    END    -------------------");
    }
}