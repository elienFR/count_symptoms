package com.hemebiotech.analytics;

import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class that implements the interface ISymptoms reader and that defines methods to read
 * and extract the symptoms of a file line by line.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private List<String> symptomsEnumeration;
	private Map<String,Integer> TreeMapOfSymptomsAndCounts;

	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> enumerateSymptoms(boolean verboseMode) {

		System.out.println("Starting enumerating Symptoms...");

		this.symptomsEnumeration = new ArrayList<String>();

		if (this.filepath != null) {
			try {
				boolean alreadyExists = false;		//Is the current line already exists in this.symptomsEnumeration
				boolean firstInjection = true;		//Used to increment the this.symptomsEnumeration array list for the first time

				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					//This part deals with empty lines to prevent them from being treated
					if (!line.equals("")) {
						if(firstInjection) {
							this.symptomsEnumeration.add(line);
							firstInjection = false;
						}

						else {
							for (int i = 0; i < this.symptomsEnumeration.size(); i++) {
								if (line.equals(this.symptomsEnumeration.get(i))) {
									alreadyExists = true;
									break;
								}

								else {
									alreadyExists = false;
								}
							}

							if (!alreadyExists){
								this.symptomsEnumeration.add(line);
							}
						}
					}

					line = reader.readLine();
				}

				reader.close();
				System.out.println("Enumeration ended successfully.");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if(verboseMode) {
			System.out.println("Here is the list of unique symptoms extracted from the file !");
			for(int i=0; i<this.symptomsEnumeration.size();i++){
				System.out.println(i + " : " + this.symptomsEnumeration.get(i));
			}
			System.out.println("There are " + this.symptomsEnumeration.size() + " different symptoms in total.");
		}

		//we sort the symptoms in the ArrayList
		Collections.sort(this.symptomsEnumeration);

		return this.symptomsEnumeration;
	}

	/**
	 *
	 * These methods will read each line of the text file loaded with ReadSymptomDataFromFile
	 * It will compare each line with a list of unique symptoms and count them in a Map of
	 * unique key that match the symptoms list.
	 *
	 * @param display Does the methods shows the created Map ?
	 * @param pSymptomsList The list of String that have to be counted in the file
	 * @return a Map of symptoms (key) and their associated count
	 */
	@Override
	public Map<String,Integer> countSymptoms(boolean display, @NotNull List<String> pSymptomsList) {
		this.TreeMapOfSymptomsAndCounts = new TreeMap<String, Integer>();

		System.out.println("Starting counting symptoms...");

		try {
			BufferedReader reader = new BufferedReader (new FileReader(this.filepath));
			String line = reader.readLine();

			//Init of the TreeMap
			for(int i = 0; i < pSymptomsList.size(); i++){
				this.TreeMapOfSymptomsAndCounts.put(pSymptomsList.get(i), 0);
			}

			//We read every line of the fill until it reaches the end
			while (line!=null){
				//We check if the line's not empty so we do not overprocess the file
				if(!line.equals("")) {
					if(pSymptomsList.contains(line)) {
						this.TreeMapOfSymptomsAndCounts.put(line, this.TreeMapOfSymptomsAndCounts.get(line) + 1);
					}
				}
				line = reader.readLine();
			}

			reader.close();
			System.out.println("Counting ended successfully.");

			//If verbose is activated, the methods print the HashMap
			if (display) {
				System.out.println("================================");
				System.out.println("||   Symptoms   |    Counts   ||");
				System.out.println("||----------------------------||");
				for (int i = 0; i < pSymptomsList.size(); i++) {
					if (!pSymptomsList.get(i).equals("")) {
						System.out.println("||   " + pSymptomsList.get(i) + "   |   " + this.TreeMapOfSymptomsAndCounts.get(pSymptomsList.get(i)));
					}
				}
				System.out.println("================================");
			}

		} catch (Exception e) {
			System.out.println("\n \n \n==========================================================");
			System.out.println("Error !  make sure list is ok with no null values inside.");
			System.out.println("==========================================================\n");
			e.printStackTrace();	}

		return	this.TreeMapOfSymptomsAndCounts;
	}
}
