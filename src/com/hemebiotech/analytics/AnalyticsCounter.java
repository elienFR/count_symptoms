package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		//Name of the file you want to pick or complete path to it
		String filepath = "symptoms.txt";

		//Beginning of the program to write a file with every symptom's count.
		ISymptomReader symptomsFile = new ReadSymptomDataFromFile(filepath);
		symptomsFile.writeSymptomsCountToFile();

	}
}