package com.project;

import java.util.List;

public class Loaner {
	String loanID;
	String gender;
	boolean married;
	String dependants;
	boolean education;
	boolean selfEmployed;
	int applicantIncome;
	Double coapplicantIncome;
	Double loanAmount;
	double loanTerm;
	boolean creditHistory;
	String propertyArea;
	
	
	public Loaner(List<String> test) {
		this.loanID = test.get(0);
		
		//Checks if its a string of either male or female, otherwise sets it to male as its the most common
		if (test.get(1).contains("Male") | test.get(1).contains("Female")) {
			this.gender = test.get(1);
		} else this.gender = "Male";
		
		//Is set to TRUE if married is marked as Yes, otherwise is set to false	
		this.married = test.get(2).contains("Yes");
		
		//Checks if the string contains an integer, otherwise sets it to 0 as its the most common
		if (test.get(3).matches(".*\\d.*")) {
			this.dependants = test.get(3);
		}
		else {
			this.dependants = "0";
		}

		this.education = test.get(4).contains("Graduate");
		
		//Is set to TRUE if self employed is marked as Yes, otherwise is set to false
		this.selfEmployed = test.get(5).contains("Yes");
		
		this.applicantIncome = Integer.valueOf(test.get(6));
		this.coapplicantIncome = Double.valueOf(test.get(7));
		this.loanAmount = Double.valueOf(test.get(8));
		
		//Trys to see if the string has a double, otherwise sets it to 360 as its the most common
		try {
			this.loanTerm = Double.parseDouble(test.get(9));
		} catch(Exception e){
			this.loanTerm = 360.0;
		}
		//Is set to TRUE if credit history is marked as 1, otherwise is set to false
		this.creditHistory = test.get(10).contains("1");
		this.propertyArea = test.get(11);

	}
	
	//Prints out all the variables in a human readable format
	public void displayData() {
		System.out.println(loanID + " " + gender + " " + married + " " + dependants + " " + education
				+" "+ selfEmployed + " " + applicantIncome + " " + coapplicantIncome + " " +
				loanAmount + " " +loanTerm+" "+ creditHistory + " " + propertyArea);
	}
}
