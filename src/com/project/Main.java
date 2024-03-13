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
		BufferedReader reader = new BufferedReader(new FileReader("loan_data.csv"));
		int dataSize = 0;
		while (reader.readLine() != null) dataSize+=1;
		reader.close();
		
		Scanner in = new Scanner(new FileReader("loan_data.csv"));
		Loaner[] testing = new Loaner[dataSize];
		int i = 0;
		try {
			List<List<String>> line = new ArrayList<>();
			
			
			
			
			
			//Adds each line of the CSV to an array as an array of its own
			line.add(Arrays.asList(in.nextLine().split(",")));
			line.add(Arrays.asList(in.nextLine().split(",")));

			while (in.hasNextLine()) {
				//System.out.print(line.get(i) +"\n"); 
				
				testing[i] = new Loaner(line.get(i+1));
				line.add(Arrays.asList(in.nextLine().split(",")));  
				/*
				 * line.add(Arrays.asList(in.nextLine().split(","))); Loaner test = new
				 * Loaner(line.get(i)); Training.add(test);
				 */
				i+=1;
			}
			testing[i] = new Loaner(line.get(i+1));
			
		} finally {
			
			System.out.println(i);
			in.close();
		}
	
		testing[16].showData();
	}
}
