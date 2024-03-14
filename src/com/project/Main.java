package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException {
		int dataSize = 0;
		List<String> headers;
		
		//Reads the file to find out how many lines it contains, and therefore how large the array 
		//that contains the test data needs to be
		BufferedReader reader = new BufferedReader(new FileReader("loan_data.csv"));
		while (reader.readLine() != null) dataSize+=1;
		reader.close();
		
		Scanner in = new Scanner(new FileReader("loan_data.csv"));
		//Creates an array of the loaner class with the size of the dataset
		TrainingLoaner[] testing = new TrainingLoaner[dataSize];
		
		//A counter for keeping track how far into the data set we are
		int i = 0;
		
		try {
			List<List<String>> line = new ArrayList<>();
			
			//Adds each line of the CSV to an array as an array of its own
			line.add(headers = Arrays.asList(in.nextLine().split(",")));
			line.add(Arrays.asList(in.nextLine().split(",")));

			//While there is a next line, adds the line to The TrainingLoaner class array,
			//reads the next line and increments the counter
			while (in.hasNextLine()) {
				testing[i] = new TrainingLoaner(line.get(i+1));
				line.add(Arrays.asList(in.nextLine().split(",")));  
				i+=1;
			}
			//Adds the final line to the TrainingLoaner class array
			testing[i] = new TrainingLoaner(line.get(i+1));
			
		} finally {
			//Closes the scanner after it is finished
			in.close();
		}
		System.out.println(headers);
		for (int y=0; y<testing.length-1;y++) {
			testing[y].displayData();
		}
		
	}
}
