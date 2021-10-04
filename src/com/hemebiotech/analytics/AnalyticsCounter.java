package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

public class AnalyticsCounter {

	private ISymptomReader symptomsList;
	private ISymptomCounter symptomCounter;
	private ISymptomWriter symptomWriter;
	private String sourceFilePath;
	private String outFilePath;

	public AnalyticsCounter(String sourceFilePath, String outFilePath){
		this.sourceFilePath=sourceFilePath;
		this.outFilePath=outFilePath;
	}

	public void execute(){
		this.symptomsList = new ExtractLinesFromFile(this.sourceFilePath);
		this.symptomCounter = new CountDataFromFile
				(this.sourceFilePath,this.symptomsList.extract
						(false,false,true,true));
		this.symptomWriter = new WriteMapStringIntegerToFile(this.symptomCounter.count());
		symptomWriter.writeToFile(this.outFilePath);
	}
}
