package com.project;

public class Probability2 {
	TrainingLoaner[] trainingData;
	
	public Probability2(TrainingLoaner[] trainingData) {
		this.trainingData = trainingData;
	}
	
	public double findYesToday(Loaner testData) {
		double prob;
		
		prob = findGenderY(testData.gender)*findMarriedY(testData.married)*findDependantsY(testData.dependants)
				*findEducationY(testData.education)*findSelfEmployedY(testData.selfEmployed)*findIncomeY(testData.applicantIncome)
				*findCoIncomeY(testData.coapplicantIncome)*findLoanAmountY(testData.loanAmount)*findLoanTermY(testData.loanTerm)
				*findCreditHistoryY(testData.creditHistory)*findPropertyAreaY(testData.propertyArea);
		
		return prob;
	}
	
	public double findNoToday(Loaner testData) {
		double prob;
		
		prob = findGenderN(testData.gender)*findMarriedN(testData.married)*findDependantsN(testData.dependants)
				*findEducationN(testData.education)*findSelfEmployedN(testData.selfEmployed)*findIncomeN(testData.applicantIncome)
				*findCoIncomeN(testData.coapplicantIncome)*findLoanAmountN(testData.loanAmount)*findLoanTermN(testData.loanTerm)
				*findCreditHistoryN(testData.creditHistory)*findPropertyAreaN(testData.propertyArea);
		
		return prob;
	}
	public double findGenderY(String gender) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].gender.equals(gender) & trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findGenderN(String gender) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].gender.equals(gender) &! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
				
		return matching/Yes;
	}
	
	public double findMarriedY(boolean married) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if(trainingData[i].married==married & trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findMarriedN(boolean married) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if(trainingData[i].married==married &! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findDependantsY(String dependants) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].dependants.equals(dependants) & trainingData[i].isLoaned) {
				matching++;
				Yes++;
			} 
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findDependantsN(String dependants) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].dependants.equals(dependants) &! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			} 
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findEducationY(boolean education) {
		double matching=0;
		double Yes=0;
		
		for (int i=0; i<trainingData.length-1;i++) {
			if (trainingData[i].education == education & trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findEducationN(boolean education) {
		double matching=0;
		double Yes=0;
		
		for (int i=0; i<trainingData.length-1;i++) {
			if (trainingData[i].education == education &! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findSelfEmployedY(boolean selfEmployed) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].selfEmployed == selfEmployed & trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findSelfEmployedN(boolean selfEmployed) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].selfEmployed == selfEmployed &! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	//Maybe adjust number ranges?
	public double findIncomeY(double income) {
		int range;
		double matching=0;
		double Yes=0;

		if (income>=8000) range=8000;
		else if (income>=6000) range=6000;
		else if (income>=4000) range=4000;
		else if (income>=2000) range=2000;
		else range=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if ((trainingData[i].applicantIncome >= (range) && trainingData[i].applicantIncome < ((range==8000) ? 50000 : range+2000))
				& trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findIncomeN(double income) {
		int range;
		double matching=0;
		double Yes=0;
		
		if (income>=8000) range=8000;
		else if (income>=6000) range=6000;
		else if (income>=4000) range=4000;
		else if (income>=2000) range=2000;
		else range=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			
			if ((trainingData[i].applicantIncome >= (range) && trainingData[i].applicantIncome < ((range==8000) ? 50000 : range+2000)) 
				&! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findCoIncomeY(double coIncome) {
		int range;
		double matching=0;
		double Yes=0;
		
		if (coIncome>=8000) range=8000;
		else if (coIncome>=6000) range=6000;
		else if (coIncome>=4000) range=4000;
		else if (coIncome>=2000) range=2000;
		else range=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if ((trainingData[i].coapplicantIncome >= (range) && trainingData[i].applicantIncome < ((range==8000) ? 50000 : range+2000)) 
				& trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findCoIncomeN(double coIncome) {
		int range;
		double matching=0;
		double Yes=0;
		

		if (coIncome>=8000) range=8000;
		else if (coIncome>=6000) range=6000;
		else if (coIncome>=4000) range=4000;
		else if (coIncome>=2000) range=2000;
		else range=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if ((trainingData[i].coapplicantIncome >= (range) && trainingData[i].applicantIncome <  ((range==8000) ? 50000 : range+2000)) 
				&! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	
	public double findLoanAmountY(double loanAmount) {
		int range;
		double matching=0;
		double Yes=0;
		
		if (loanAmount>=100) range=100;
		else if (loanAmount>=50) range=50;
		else range=0;
		
		
		for (int i=0;i<trainingData.length-1;i++) {
			if ((trainingData[i].loanAmount>=(range) && trainingData[i].loanAmount< ((range==100) ? 50000 : range+50))
				& trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findLoanAmountN(double loanAmount) {
		int range;
		double matching=0;
		double Yes=0;
		
		if (loanAmount>=100) range=100;
		else if (loanAmount>=50) range=50;
		else range=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if ((trainingData[i].loanAmount>(range) && trainingData[i].loanAmount<((range==100) ? 50000 : range+50))
				&! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findLoanTermY(double loanTerm) {
		int range;
		double matching=0;
		double Yes=0;
		
		if (loanTerm>=400) range=400;
		else if (loanTerm>=300) range=300;
		else if (loanTerm>=200) range=200;
		else if (loanTerm>=100) range=100;
		else range=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if ((trainingData[i].loanTerm>range && trainingData[i].loanTerm< ((range==400) ? 50000 : range+100))
				& trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findLoanTermN(double loanTerm) {
		int range;
		double matching=0;
		double Yes=0;
		
		if (loanTerm>=400) range=400;
		else if (loanTerm>=300) range=300;
		else if (loanTerm>=200) range=200;
		else if (loanTerm>=100) range=100;
		else range=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if ((trainingData[i].loanTerm>range && trainingData[i].loanTerm< ((range==400) ? 50000 : range+100))
				&! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findCreditHistoryY(boolean creditHistory) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].creditHistory == creditHistory & trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findCreditHistoryN(boolean creditHistory) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].creditHistory == creditHistory &! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findPropertyAreaY(String propertyArea) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].propertyArea.equals(propertyArea) & trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
	
	public double findPropertyAreaN(String propertyArea) {
		double matching=0;
		double Yes=0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].propertyArea.equals(propertyArea) &! trainingData[i].isLoaned) {
				matching++;
				Yes++;
			}
			else if (!trainingData[i].isLoaned) {
				Yes++;
			}
		}
		
		return matching/Yes;
	}
}
