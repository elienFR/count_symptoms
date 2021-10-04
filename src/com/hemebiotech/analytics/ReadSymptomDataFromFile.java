package com.hemebiotech.analytics;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private Map<String,Integer> hashMapOfSymptomsAndCounts;


	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
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
		this.hashMapOfSymptomsAndCounts = new HashMap<String, Integer>();

		System.out.println("Starting counting symptoms...");

		try {
			BufferedReader reader = new BufferedReader (new FileReader(this.filepath));
			String line = reader.readLine();

			//Init of the HashMap
			for(int i = 0; i < pSymptomsList.size(); i++){
				this.hashMapOfSymptomsAndCounts.put(pSymptomsList.get(i), 0);
			}

			//We read every line of the fill until it reaches the end
			while (line!=null){
				//We check if the line's not empty so we do not overprocess the file
				if(!line.equals("")) {
					if(pSymptomsList.contains(line)) {
						this.hashMapOfSymptomsAndCounts.put(line, this.hashMapOfSymptomsAndCounts.get(line) + 1);
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
						System.out.println("||   " + pSymptomsList.get(i) + "   |   " + this.hashMapOfSymptomsAndCounts.get(pSymptomsList.get(i)));
					}
				}
				System.out.println("================================");
			}

		} catch (Exception e) {
			System.out.println("\n \n \n==========================================================");
			System.out.println("Error !  make sure list is ok with no null values inside.");
			System.out.println("==========================================================\n");
			e.printStackTrace();	}


		return	this.hashMapOfSymptomsAndCounts;
	}
}
