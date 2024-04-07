package com.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	TrainingLoaner[] trainingData;
	public static void main(String args[]) throws IOException {
		int dataSize = 0;
		int trainingDataSize = 0;
		List<String> headers;
		
		//Reads the file to find out how many lines it contains, and therefore how large the array 
		//that contains the test data needs to be
		BufferedReader reader = new BufferedReader(new FileReader("loan_data.csv"));
		while (reader.readLine() != null) dataSize+=1;
		reader.close();
		
		
		Scanner in = new Scanner(new FileReader("loan_data.csv"));
		//Creates an array of the loaner class with the size of the dataset
		TrainingLoaner[] trainingData = new TrainingLoaner[dataSize];
		
		Probability2 test;
		
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
				trainingData[i] = new TrainingLoaner(line.get(i+1));
				line.add(Arrays.asList(in.nextLine().split(",")));  
				i+=1;
			}
			//Adds the final line to the TrainingLoaner class array
			trainingData[i] = new TrainingLoaner(line.get(i+1));
			
		} finally {
			//Closes the scanner after it is finished
			in.close();
		}
		
		//Section dedicated to calculating probabilities from the training dataset
		test = new Probability2(trainingData);
		//System.out.println(test.findDependantsN("3+"));
		
		
		System.out.println(headers);
		for (int y=0; y<trainingData.length-1;y++) {
			//trainingData[y].displayData();
		}
		
		//Section to reading and storing testing dataset
		reader = new BufferedReader(new FileReader("train_data.csv"));
		while (reader.readLine() != null) trainingDataSize+=1;
		reader.close();
		reader = new BufferedReader(new FileReader("train_data.csv"));
		TrainingLoaner[] testingData = new TrainingLoaner[trainingDataSize];
		String line;
		int y = 0;
		while ((line = reader.readLine()) != null) {
			testingData[y] = new TrainingLoaner(Arrays.asList(line.split(",")));
			y++;
		}
		reader.close();
		int right=0;
		int wrong=0;
		for (int x=0;x<testingData.length;x++) {

			double yes = test.findYesToday(testingData[x]);
			double no = test.findNoToday(testingData[x]);
			if ((yes/(yes+no)>no/(yes+no)) == testingData[x].isLoaned) {
				right++;
			} else {
				System.out.println((yes/(yes+no) + " " + no/(yes+no)));
				wrong++;}
			
			//System.out.println((yes/(yes+no)>no/(yes+no)) +" " + testingData[x].isLoaned);
			//testingData[x].displayData();
		}
		System.out.println("Correct predictions: " + right);
		System.out.println("Incorrect predictions: " + wrong);
		System.out.println("Total predictions: "+ (right+wrong));
		//double yes = test.findYesToday(plswork);
		//double no = test.findNoToday(plswork);
		GUI n = new GUI(500,500);
		//GUI2 a = new GUI2(500,500);
		//a.setupGUI();
        //n.setUpGUI();
        //n.setUpButtonListeners();
		
		//System.out.println(yes/(yes+no));
		//System.out.println(no/(yes+no));
		//System.out.println(yes/(yes+no)>no/(yes+no)); 
	}
	
	public void loadTrainingData() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("loan_data.csv"));
		int i=0;
		try {
			List<List<String>> line = new ArrayList<>();
			
			//Adds each line of the CSV to an array as an array of its own
			line.add(Arrays.asList(in.nextLine().split(",")));
			line.add(Arrays.asList(in.nextLine().split(",")));

			//While there is a next line, adds the line to The TrainingLoaner class array,
			//reads the next line and increments the counter
			while (in.hasNextLine()) {
				trainingData[i] = new TrainingLoaner(line.get(i+1));
				line.add(Arrays.asList(in.nextLine().split(",")));  
				i+=1;
			}
			//Adds the final line to the TrainingLoaner class array
			trainingData[i] = new TrainingLoaner(line.get(i+1));
			
		} finally {
			//Closes the scanner after it is finished
			in.close();
		}
	}
}
