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
		
	}
}
