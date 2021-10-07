package com.hemebiotech.analytics;

import java.util.Map;

/**
 * An interface to count unique symptoms from a text file.
 * @author Elien
 * @version 0.2.0
 * @see CountDataFromFile
 */
public interface ISymptomCounter {
    /**
     * Will count the number of occurrences a symptom is found in a text file.
     * @return a map with symptoms as key and their associated integer count.
     */
    Map<String, Integer> countSymptoms();
}
