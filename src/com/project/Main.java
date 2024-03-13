package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("loan_data.csv"));
	try {
		String line = r.readLine() ;
		while (line!= null) {
			System.out.print(line +"\n"); 

	        // Prepare for next loop iteration
	        line = r.readLine();
		}
		
	} finally {
		r.close();
	}
	
	}
}
