package com.project;

public class ProbabilityFinder {
	TrainingLoaner[] trainingData;

	double yGivenMale;
	double yGivenFemale;
	double nGivenMale;
	double nGivenFemale;
	
	double yGivenMarried;
	double yGivenNotMarried;
	double nGivenMarried;
	double nGivenNotMarried;
	
	double yGivenZero;
	double yGivenOne;
	double yGivenTwo;
	double yGivenThree;
	double nGivenZero;
	double nGivenOne;
	double nGivenTwo;
	double nGivenThree;
	
	double yGivenEducated;
	double yGivenNotEducated;
	double nGivenEducated;
	double nGivenNotEducated;
	
	double yGivenSelfEmployed;
	double yGivenNotSelfEmployed;
	double nGivenSelfEmployed;
	double nGivenNotSelfEmployed;
	
	double yGiven0kIncome;
	double yGiven2kIncome;
	double yGiven4kIncome;
	double yGiven6kIncome;
	double yGiven8kIncome;
	double nGiven0kIncome;
	double nGiven2kIncome;
	double nGiven4kIncome;
	double nGiven6kIncome;
	double nGiven8kIncome;
	
	double yGiven0kCoIncome;
	double yGiven2kCoIncome;
	double yGiven4kCoIncome;
	double yGiven6kCoIncome;
	double yGiven8kCoIncome;
	double nGiven0kCoIncome;
	double nGiven2kCoIncome;
	double nGiven4kCoIncome;
	double nGiven6kCoIncome;
	double nGiven8kCoIncome;
	
	double yGiven0Loan;
	double yGiven50Loan;
	double yGiven100Loan;
	double nGiven0Loan;
	double nGiven50Loan;
	double nGiven100Loan;
	
	public ProbabilityFinder(TrainingLoaner[] trainingData) {
		this.trainingData = trainingData;
	}
	
	public void findGender() {
		double maleY = 0;
		double maleN = 0;
		double femaleY = 0;
		double femaleN = 0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			
			if (trainingData[i].gender.contains("Male")) {
				if (trainingData[i].isLoaned) {
					maleY++;
				} else {
					maleN++;
				}
			} else {
				if (trainingData[i].isLoaned) {
					femaleY++;
				} else {
					femaleN++;
				}
			}

		}
		yGivenMale = maleY/(maleY+femaleY);
		yGivenFemale =  femaleY/(maleY+femaleY);
		nGivenMale =  maleN/(maleN+femaleN);
		nGivenFemale = femaleN/(maleN+femaleN);
	}
	
	public void findMarried() {
		double marriedY = 0;
		double marriedN = 0;
		double notMarriedY = 0;
		double notMarriedN = 0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			
			if (trainingData[i].married == true) {
				if (trainingData[i].isLoaned) {
					marriedY++;
				} else {
					marriedN++;
				}
			} else {
				if (trainingData[i].isLoaned) {
					notMarriedY++;
				} else {
					notMarriedN++;
				}
			}
			
		}
		yGivenMarried = marriedY/(marriedY+notMarriedY);
		yGivenNotMarried = notMarriedY/(marriedY+notMarriedY);
		nGivenMarried = marriedN/(marriedN+notMarriedN);
		nGivenNotMarried = notMarriedN/(marriedN+notMarriedN);
	}
	
	public void findDependants() {
		double zeroY = 0;
		double zeroN = 0;
		double oneY = 0;
		double oneN = 0;
		double twoY = 0;
		double twoN = 0;
		double threeY = 0;
		double threeN = 0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			
			if (trainingData[i].dependants.equals("0")) {
				if (trainingData[i].isLoaned) {
					zeroY++;
				} else {
					zeroN++;
				}
			} else if (trainingData[i].dependants.equals("1")) {
				if (trainingData[i].isLoaned) {
					oneY++;
				} else {
					oneN++;
				}
			} else if (trainingData[i].dependants.equals("2")) {
				if (trainingData[i].isLoaned) {
					twoY++;
				} else {
					twoN++;
				}
			} else if (trainingData[i].dependants.equals("3+")) {
				if (trainingData[i].isLoaned) {
					threeY++;
				} else {
					threeN++;
				}
			}
		}
		
		yGivenZero = zeroY/(zeroY+oneY+twoY+threeY);
		yGivenOne = oneY/(zeroY+oneY+twoY+threeY);
		yGivenTwo = twoY/(zeroY+oneY+twoY+threeY);
		yGivenThree = threeY/(zeroY+oneY+twoY+threeY);
		
		nGivenZero = zeroN/(zeroN+oneN+twoN+threeN);
		nGivenOne = oneN/(zeroN+oneN+twoN+threeN);
		nGivenTwo = twoN/(zeroN+oneN+twoN+threeN);
		nGivenThree = threeN/(zeroN+oneN+twoN+threeN);
	}
	
	public void findEducation() {
		double educatedY = 0;
		double educatedN = 0;
		double notEducatedY = 0;
		double notEducatedN = 0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].education) {
				if (trainingData[i].isLoaned) {
					educatedY++;
				} else {
					educatedN++;
				} 
			} else {
				if (trainingData[i].isLoaned) {
					notEducatedY++;
				} else {
					notEducatedN++;
				} 
			}
		}
		
		yGivenEducated = educatedY/(educatedY+notEducatedY);
		yGivenNotEducated = notEducatedY/(educatedY+notEducatedY);
		nGivenEducated = educatedN/(educatedN+notEducatedN);
		nGivenNotEducated = notEducatedN/(educatedN+notEducatedN);
		
	}
	
	public void findSelfEmployed() {
		double selfEmployedY = 0;
		double selfEmployedN = 0;
		double notSelfEmployedY = 0;
		double notSelfEmployedN = 0;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].selfEmployed) {
				if (trainingData[i].isLoaned) {
					selfEmployedY++;
				} else {
					selfEmployedN++;
				}
			} else {
				if (trainingData[i].isLoaned) {
					notSelfEmployedY++;
				} else {
					notSelfEmployedN++;
				}
			}
		}
		
		yGivenSelfEmployed = selfEmployedY/(selfEmployedY+notSelfEmployedY);
		yGivenNotSelfEmployed = notSelfEmployedY/(selfEmployedY+notSelfEmployedY);
		nGivenSelfEmployed = selfEmployedN/(selfEmployedN+notSelfEmployedN);
		nGivenNotSelfEmployed = notSelfEmployedN/(selfEmployedN+notSelfEmployedN);
		
	}
	
	//Applicant Income will be sorted by ranges, 0-1999, 2000-3999, 4000-5999, 6000-7999, 8000+
	public void findApplicantIncome() {
		double income0kY = 0;
		double income2kY = 0;
		double income4kY = 0;
		double income6kY = 0;
		double income8kY = 0;
		double income0kN = 0;
		double income2kN = 0;
		double income4kN = 0;
		double income6kN = 0;
		double income8kN = 0;
		
		double yCount;
		double nCount;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].applicantIncome >= 8000) {
				if (trainingData[i].isLoaned) {
					income8kY++;
				} else {
					income8kN++;
				}
			} else if (trainingData[i].applicantIncome >= 6000) {
				if (trainingData[i].isLoaned) {
					income6kY++;
				} else {
					income6kN++;
				}
			} else if (trainingData[i].applicantIncome >= 4000) {
				if (trainingData[i].isLoaned) {
					income4kY++;
				} else {
					income4kN++;
				}
			} else if (trainingData[i].applicantIncome >= 2000) {
				if (trainingData[i].isLoaned) {
					income2kY++;
				} else {
					income2kN++;
				}
			} else {
				if (trainingData[i].isLoaned) {
					income0kY++;
				} else {
					income0kN++;
				}
			}
			yCount = income0kY+income2kY+income4kY+income6kY+income8kY;
			nCount = income0kN+income2kN+income4kN+income6kN+income8kN;
			
			yGiven0kIncome = income0kY/yCount;
			yGiven2kIncome = income2kY/yCount;
			yGiven4kIncome = income4kY/yCount;
			yGiven6kIncome = income6kY/yCount;
			yGiven8kIncome = income8kY/yCount;
			nGiven0kIncome = income0kN/nCount;
			nGiven2kIncome = income2kN/nCount;
			nGiven4kIncome = income4kN/nCount;
			nGiven6kIncome = income6kN/nCount;
			nGiven8kIncome = income8kN/nCount;
		}
	}
	
	//CoApplicant Income will be sorted by ranges, 0-1999, 2000-3999, 4000-5999, 6000-7999, 8000+
	public void findCoApplicantIncome() {
		double income0kY = 0;
		double income2kY = 0;
		double income4kY = 0;
		double income6kY = 0;
		double income8kY = 0;
		double income0kN = 0;
		double income2kN = 0;
		double income4kN = 0;
		double income6kN = 0;
		double income8kN = 0;
		
		double yCount;
		double nCount;
		
		for (int i=0;i<trainingData.length-1;i++) {
			if (trainingData[i].coapplicantIncome >= 8000) {
				if (trainingData[i].isLoaned) {
					income8kY++;
				} else {
					income8kN++;
				}
			} else if (trainingData[i].coapplicantIncome >= 6000) {
				if (trainingData[i].isLoaned) {
					income6kY++;
				} else {
					income6kN++;
				}
			} else if (trainingData[i].coapplicantIncome >= 4000) {
				if (trainingData[i].isLoaned) {
					income4kY++;
				} else {
					income4kN++;
				}
			} else if (trainingData[i].coapplicantIncome >= 2000) {
				if (trainingData[i].isLoaned) {
					income2kY++;
				} else {
					income2kN++;
				}
			} else {
				if (trainingData[i].isLoaned) {
					income0kY++;
				} else {
					income0kN++;
				}
			}
			yCount = income0kY+income2kY+income4kY+income6kY+income8kY;
			nCount = income0kN+income2kN+income4kN+income6kN+income8kN;
			
			yGiven0kCoIncome = income0kY/yCount;
			yGiven2kCoIncome = income2kY/yCount;
			yGiven4kCoIncome = income4kY/yCount;
			yGiven6kCoIncome = income6kY/yCount;
			yGiven8kCoIncome = income8kY/yCount;
			nGiven0kCoIncome = income0kN/nCount;
			nGiven2kCoIncome = income2kN/nCount;
			nGiven4kCoIncome = income4kN/nCount;
			nGiven6kCoIncome = income6kN/nCount;
			nGiven8kCoIncome = income8kN/nCount;
		}
	}

	//Loan Amount will be sorted by ranges, 1-50, 51-100, 101-150 
	public void findLoanAmount() {
		double loan0Y = 0;
		double loan50Y = 0;
		double loan100Y = 0;
		double loan0N = 0;
		double loan50N = 0;
		double loan100N = 0;
		double yCount;
		double nCount;
		for (int i = 0;i<trainingData.length-1;i++) {
			if (trainingData[i].loanAmount >100) {
				if (trainingData[i].isLoaned) {
					loan100Y++;
				} else {
					loan100N++;
				}	
			} else if (trainingData[i].loanAmount > 50) {
				if (trainingData[i].isLoaned) {
					loan50Y++;
				} else {
					loan50N++;
				}
			} else {
				if (trainingData[i].isLoaned) {
					loan0Y++;
				} else {
					loan0N++;
				}
			}
			
			yCount = loan0Y+loan50Y+loan100Y;
			nCount = loan0N+loan50N+loan100N;
			yGiven0Loan = loan0Y/yCount;
			yGiven50Loan = loan50Y/yCount;
			yGiven100Loan = loan100Y/yCount;
			nGiven0Loan = loan0N/nCount;
			nGiven50Loan = loan50N/nCount;
			nGiven100Loan = loan100N/nCount;
			
		}
		
	}
	//Loan Terms will be sorted by ranges, 1-100, 101-200, 201-300, 301-400
	public void findLoanTerm() {
		
	}
}
