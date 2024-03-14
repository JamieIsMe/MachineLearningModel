package com.project;

import java.util.List;

public class TrainingLoaner extends Loaner {
	boolean loanStatus;
	
	
	public TrainingLoaner(List<String> test1) {
		super(test1);
		//Is set to TRUE if loan status is marked as Y, otherwise is set to false
		this.loanStatus = test1.get(12).contains("Y");
	}
	
	@Override
	//Prints out all the variables in a human readable format
	public void displayData() {
		System.out.println(loanID + " " + gender + " " + married + " " + dependants + " " + education
				+" "+ selfEmployed + " " + applicantIncome + " " + coapplicantIncome + " " +
				loanAmount + " " +loanTerm+" "+ creditHistory + " " + propertyArea + " " + loanStatus);
	}
	
}
