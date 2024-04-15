# Machine Learning Model using Naïve Bayes

This was created for my Object Oriented Programming Module.\
It calculates the probability of a given person recieved a loan based on given data.\
The CSV files for training and testing are included.

## Classes
#### Loaner


- Stores each line of a CSV file into a variety of variables so they can be used later, see variables below.
```java
String loanID
String gender
boolean married
String dependants
boolean education
boolean selfEmployed
double applicantIncome
double coapplicantIncome
double loanAmount
double loanTerm
boolean creditHistory
String propertyArea
```
#### Training Loaner

- Inherits from the Loaner class, but has an extra variable **isLoaned** for whether the loan was approved or not.
```java
boolean isLoaned
```

#### Probability Calculator

- Uses the data stored in the Training Loaner class to calculate probabilites of something being True/False through the use of 
  various functions.

#### Main

- Initialises the GUI and allows the user to interact with the Application by inputting data to be tested.

##  Core Functionality 

- Allows user to load in the training data so that the application can calculate the probability of events.
- Allows the user to load in the testing data and test it using the probabilities calculated from the training data.
- Outputs the applications accuracy based on its testing.

## Optional Functionality

- Improved and detailed GUI to enhance the user experience
- User can manually enter in user information and be informed whether they would recieve a loan, and how confident the application is of this assumption
- Detailed information is printed out in the IDE


## Author  

Jamie Turpin - [My Github](https://github.com/JamieIsMe)