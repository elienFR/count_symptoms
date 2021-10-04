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
	 * Extract each lines of a file in the element of an ArrayList<String>
	 * @param verbose true activates verbose mode of the method
	 * @param catchBlankLines true catch the file's blank lines
	 * @param withoutDuplicates true create a list without duplicates.
	 * @return a list of the string lines contained in a file
	 */
	List<String> extract(boolean verbose,boolean catchBlankLines,boolean withoutDuplicates,boolean sort);





}
