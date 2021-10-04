package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private List<String> symptomsEnumeration;

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
		return this.symptomsEnumeration;
	}

}
