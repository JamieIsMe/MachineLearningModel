package com.project;

import java.util.ArrayList;
import java.util.List;

public class Loaner {
	String loanID;
	String gender;
	boolean married;
	String dependants;
	String education;
	boolean selfEmployed;
	int applicantIncome;
	Float coapplicantIncome;
	Float loanAmount;
	Float loanTerm;
	boolean creditHistory;
	String propertyArea;
	boolean loanStatus;
	
	List<String> line = new ArrayList<>();
	
	public Loaner(String gender, boolean married, String dependants, String education,
			boolean selfEmployed, int applicantIncome, Float coapplicantIncome,
			Float loanAmount, Float loanTerm, boolean creditHistory,
			String propertyArea, boolean loanStatus) {
		this.gender = gender;
		this.married = married;
		this.dependants = dependants;
		this.education = education;
		this.selfEmployed = selfEmployed;
		this.applicantIncome = applicantIncome;
		this.coapplicantIncome = coapplicantIncome;
		this.loanAmount = loanAmount;
		this.loanTerm = loanTerm;
		this.creditHistory = creditHistory;
		this.propertyArea = propertyArea;
		this.loanStatus = loanStatus;
		
		
	}
	public Loaner(List<String> test) {
		this.loanID = test.get(0);
		try {
			this.gender = test.get(1);
		} catch(Exception e){
			this.gender = "Male";
		}
		this.married = test.get(2).contains("Yes");
		
		try {
			this.dependants = test.get(3);
		} catch(Exception e){
			this.dependants = "0";
		}
		this.education = test.get(4);
		
		try {
			this.selfEmployed = test.get(5).contains("Yes");
		} catch(Exception e){
			this.selfEmployed = false;
		}
		
		this.applicantIncome = Integer.valueOf(test.get(6));
		this.coapplicantIncome = Float.valueOf(test.get(7));
		this.loanAmount =Float.valueOf(test.get(8));
		try {
			this.loanTerm = Float.valueOf(test.get(9));
		} catch(Exception e){
			this.loanTerm = (float)360.0;
		}
		this.creditHistory = test.get(10) == "1.0";
		this.propertyArea = test.get(11);
		this.loanStatus = test.get(12)=="Y";

	}
	
	public  void showData() {
		System.out.println(loanID + " " +gender +" " + married + " " + dependants);
	}
}
