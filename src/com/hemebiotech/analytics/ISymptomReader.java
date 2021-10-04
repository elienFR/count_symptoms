package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms unically picked from a data  file
	 * withoput any duplicates.
	 * It also count the number of unique symptoms found.
	 *
	 */
	List<String> enumerateSymptoms(boolean verbose);
}