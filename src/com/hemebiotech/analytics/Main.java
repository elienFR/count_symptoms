package com.hemebiotech.analytics;

/**
 * Main class of the program
 * To be executed
 */
public abstract class Main {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        //----------- Variables to be modified to changes input and output files ---------------------
        String sourceFilePath = "symptoms.txt";
        String outFilePath = "results.out";
        //--------------------------------------------------------------------------------------------


        //-------------------------- main program ----------------------------------------------------
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(sourceFilePath,outFilePath);
        analyticsCounter.execute();
        //--------------------------------------------------------------------------------------------
    }
}
