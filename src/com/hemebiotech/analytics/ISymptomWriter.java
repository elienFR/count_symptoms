package com.hemebiotech.analytics;

public interface ISymptomWriter {

    /**
     *
     * Writes the content of a map to a results.out file
     * in main directory
     */
    void writeToFile();

    /**
     * Writes the content of a map to a results.out file
     * @param pFilePath is the path of the file
     */
    void writeToFile(String pFilePath);

    /**
     * Shows what is going to be written in file.
     */
    void show();
}
