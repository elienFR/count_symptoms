package com.hemebiotech.analytics;

/**
 * This Interface writes the content of a ISymptomCounter Object to a file
 * @author Elien
 * @version 0.2.0
 * @see WriteMapStringIntegerToFile
 */
public interface ISymptomWriter {

    /**
     * Writes the content of the symptomsCountMap to a results.out file
     * in main directory
     */
    void writeSymptomsFile();

}
