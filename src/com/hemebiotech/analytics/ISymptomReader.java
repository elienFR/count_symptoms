package com.hemebiotech.analytics;

import java.util.List;

/**
 * An interface to read unique symptoms from a text file.
 * @author Elien
 * @version 0.2.0
 * @see ExtractLinesFromFile
 */
public interface ISymptomReader {
	/**
	 * Lists every symptom a text file without blank lines and without duplicates.
	 * @return a list of unique symptom.
	 */
	List<String> extractSymptoms();
}
