package com.hemebiotech.analytics;

/**
 * This is the main program that counts symptoms in a text file and write them in an output file
 *
 * @author Elien
 * @version 0.1.0
 */
public abstract class Main {
    /**
     *  The method where the program starts
     *  @param args nothing to say.
     */
    public static void main(String[] args) {
        //----------- Variables to be modified to change input and output files ---------------------
        String sourceFilePath = "symptoms.txt";
        String outFilePath = "results.out";
        //--------------------------------------------------------------------------------------------


        //-------------------------- main program (not to be touched) --------------------------------
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(sourceFilePath,outFilePath);
        analyticsCounter.execute();
        //--------------------------------------------------------------------------------------------
    }
}
