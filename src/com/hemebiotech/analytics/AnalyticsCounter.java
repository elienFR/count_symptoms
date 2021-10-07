package com.hemebiotech.analytics;

/**
 * Creates an analytics object used to list and count distinct lines contained in a text file.<br/>
 * It will not count blank lines.
 * @author Elien
 * @version 0.2.0
 * @see ExtractLinesFromFile Distinguish lines
 * @see CountDataFromFile Count Lines
 * @see WriteMapStringIntegerToFile Write Map
 */
public class AnalyticsCounter {

	/**
	 * Used to distinguish unique lines of a text file.
	 */
	private ISymptomReader symptomsList;
	/**
	 * Used to count occurrences of symptoms in a text file.
	 */
	private ISymptomCounter symptomCounter;
	/**
	 * Used to write a symptoms count map into a text file.
	 */
	private ISymptomWriter symptomWriter;
	/**
	 * Contains file path leading to the file to be counted
	 */
	private String sourceFilePath;
	/**
	 * Contains the destination file path of an output file.
	 */
	private String outFilePath;

	/**
	 * Create an object able to count the occurrences of distinct lines contained in its Input file,<br/>and write the count in a destination file.
	 * @param sourceFilePath Input file to be analysed.
	 * @param outFilePath Output file path.
	 */
	public AnalyticsCounter(String sourceFilePath, String outFilePath){
		this.sourceFilePath=sourceFilePath;
		this.outFilePath=outFilePath;
	}

	/**
	 * execute the counting in a source file and write it in a destination file.
	 */
	public void execute(){
		this.symptomsList = new ExtractLinesFromFile(this.sourceFilePath);
		this.symptomCounter = new CountDataFromFile
				(this.sourceFilePath,this.symptomsList.extractSymptoms());
		this.symptomWriter = new WriteMapStringIntegerToFile(this.symptomCounter.countSymptoms(), this.outFilePath);
		symptomWriter.writeSymptomsFile();
	}
}
