package com.project;

public class Loaner {
	String gender;
	String married;
	int dependants;
	String education;
	boolean selfEmployed;
	int applicantIncome;
	int coapplicantIncome;
	int loanAmount;
	int loanTerm;
	boolean creditHistory;
	String propertyArea;
	boolean loanStatus;
	
	
	
	public Loaner(String gender, String married, int dependants, String education,
			boolean selfEmployed, int applicantIncome, int coapplicantIncome,
			int loanAmount, int loanTerm, boolean creditHistory,
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
}
