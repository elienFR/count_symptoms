package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that implements the interface ISymptoms reader and that defines methods to read
 * and extract the symptoms of a file line by line.
 */
public class ExtractLinesFromFile implements ISymptomReader {

	private String filepath;
	private List<String> symptomsList;

	/**
	 * Class' constructor
	 * by default filepath="file.txt"
	 */
	public ExtractLinesFromFile(){
		this.filepath = "file.txt";
		this.symptomsList = new ArrayList<>();
	}

	/**
	 * Class' constructor of the class
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ExtractLinesFromFile(String filepath) {
		this.filepath = filepath;
		this.symptomsList = new ArrayList<>();
	}

	/**
	 * Extract each lines of a file in the element of an ArrayList<String>
	 * @param verbose true activates verbose mode of the method
	 * @param catchBlankLines true catch the file's blank lines
	 * @param withoutDuplicates true create a list without duplicates.
	 * @return a list of the string lines contained in a file
	 */
	public List<String> extract(boolean verbose, boolean catchBlankLines, boolean withoutDuplicates){

		if(verbose){
			System.out.println("\nStarting extracting lines from file located in :\n");
			System.out.println(filepath);
		}

		try{
			//Creation of a buffer "line" that will run through each line the file.
			BufferedReader reader = new BufferedReader (new FileReader(filepath));
			String line = reader.readLine();

			//Running through the entire file
			while (line!=null) {
				//Check if the line already exists in list
				if(!this.symptomsList.contains(line) || !withoutDuplicates) {
					//Do we catch blank lines ?
					if (line.equals("") && catchBlankLines) {
						this.symptomsList.add(line);
					} else if (!line.equals("")) {
						this.symptomsList.add(line);
					}
				}

				line = reader.readLine();
			}

			reader.close();
			if(verbose){System.out.println("\nExtracting ended successfully.\n");}
		}
		catch (IOException e){
			System.out.println("\nAn error has occured in " + this.getClass()+".");
			System.out.println(this.filepath + " : No such file or directory !");
			System.out.println("Please see details below  :\n");
			e.printStackTrace();
		}
		return this.symptomsList;
	}


	/**
	 * Sorts elements in List
	 */
	public void sortData(){
		try{
			Collections.sort(this.symptomsList);
		} catch (NullPointerException e){
			System.out.println("\n!!! The given list to sort is Null !!!\n");
		}

	}
}
