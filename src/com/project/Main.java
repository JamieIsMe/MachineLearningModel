package com.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;


public class Main {
	int dataSize = 0;
	int trainingDataSize = 0;
	TrainingLoaner[] trainingData = null;
	TrainingLoaner[] testingData;
	Probability2 probabilities;
	JLabel status;
	JLabel predictionText;
	private JFrame frmMachineLearningModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					
					window.frmMachineLearningModel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frmMachineLearningModel = new JFrame();
		frmMachineLearningModel.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frmMachineLearningModel.getContentPane().setForeground(new Color(255, 255, 255));
		frmMachineLearningModel.getContentPane().setBackground(new Color(60, 63, 65));
		frmMachineLearningModel.setBackground(new Color(60, 63, 65));
		frmMachineLearningModel.setTitle("Machine Learning Model");
		frmMachineLearningModel.setResizable(false);
		frmMachineLearningModel.setBounds(100, 100, 450, 400);
		frmMachineLearningModel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMachineLearningModel.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Training/Testing Data");
		lblNewLabel.setForeground(new Color(187, 187, 187));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 11, 250, 23);
		frmMachineLearningModel.getContentPane().add(lblNewLabel);
		
		JButton loadTrainData = new JButton("Load Training");
		loadTrainData.setFocusable(false);
		loadTrainData.setForeground(new Color(187, 187, 187));
		loadTrainData.setBackground(new Color(60, 63, 65));
		loadTrainData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					readTrainData();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loadTrainData.setBounds(13, 40, 129, 23);
		frmMachineLearningModel.getContentPane().add(loadTrainData);
		
		JButton loadTestData = new JButton("Load Testing");
		loadTestData.setFocusable(false);
		loadTestData.setForeground(new Color(187, 187, 187));
		loadTestData.setBackground(new Color(60, 63, 65));
		loadTestData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					readTestData();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		loadTestData.setBounds(152, 40, 129, 23);
		frmMachineLearningModel.getContentPane().add(loadTestData);
		
		JButton testTestData = new JButton("Test Testing");
		testTestData.setFocusable(false);
		testTestData.setForeground(new Color(187, 187, 187));
		testTestData.setBackground(new Color(60, 63, 65));
		testTestData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testTestData();
			}
			
		});
		
		testTestData.setBounds(291, 40, 129, 23);
		frmMachineLearningModel.getContentPane().add(testTestData);
		
		status = new JLabel("");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Tahoma", Font.PLAIN, 15));
		status.setForeground(new Color(187, 187, 187));
		status.setBounds(110, 74, 214, 33);
		frmMachineLearningModel.getContentPane().add(status);
		
		JButton EnterInfo = new JButton("Enter Info");
		EnterInfo.setForeground(new Color(187, 187, 187));
		EnterInfo.setFocusable(false);
		EnterInfo.setBackground(new Color(60, 63, 65));
		EnterInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testLoaner();	
			}
			
		});
		EnterInfo.setBounds(152, 158, 129, 23);
		frmMachineLearningModel.getContentPane().add(EnterInfo);
		
		predictionText = new JLabel("");
		predictionText.setHorizontalAlignment(SwingConstants.CENTER);
		predictionText.setForeground(new Color(187, 187, 187));
		predictionText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		predictionText.setBounds(110, 118, 214, 33);
		frmMachineLearningModel.getContentPane().add(predictionText);
	}
	
	
	//Reads in the training data CVS file and runs each line into an object of my "trainingLoaner" class to store the data
	public void readTrainData() throws IOException {
		//Only runs if trainingData is empty
		if (trainingData == null) {
			//Read each line, incrementing a counter by 1 for each line to find out the size of my class array
			BufferedReader reader = new BufferedReader(new FileReader("loan_data.csv"));
			while (reader.readLine() != null) dataSize+=1;
			reader.close();
			reader = new BufferedReader(new FileReader("loan_data.csv"));
			trainingData = new TrainingLoaner[dataSize];
			
			int i = 0;
			
			String line;
			line = reader.readLine();
			//Adds each line of the CSV to an array as an array of its own
			while ((line = reader.readLine()) != null) {
				trainingData[i] = new TrainingLoaner(Arrays.asList(line.split(",")));
				i++;
			}	
			//While there is a next line, adds the line to The TrainingLoaner class array,
			//reads the next line and increments the counter
			for (int y=0; y<trainingData.length-1;y++) {
				trainingData[y].displayData();
			}
			status.setText("Loaded Training Data");
		} else {
			//Displays a message to say the data is already loaded if tried to load again
			System.out.println("Training Data has already been loaded");
			status.setText("Training Data already loaded");
		}
		probabilities = new Probability2(trainingData);
		
	}
	
	//Reads in the testing data CVS file and runs each line into an object of my "trainingLoaner" class to store the data
	public void readTestData() throws IOException{
		if (testingData == null) {
			BufferedReader reader = new BufferedReader(new FileReader("train_data.csv"));
			while (reader.readLine() != null) trainingDataSize+=1;
			reader.close();
			reader = new BufferedReader(new FileReader("train_data.csv"));
			testingData = new TrainingLoaner[trainingDataSize];
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				testingData[i] = new TrainingLoaner(Arrays.asList(line.split(",")));
				i++;
			}
			reader.close();
			for (int y=0; y<testingData.length-1;y++) {
				testingData[y].displayData();
			}
			status.setText("Loaded Testing Data");
		} else {
			System.out.println("Testing Data has already been loaded");
			status.setText("Testing Data already loaded");
		}
		
	}
	
	//This tests the stored testing data against the probabilities from the training data and returns the result
	public void testTestData() {
		if (trainingData!=null & testingData!=null) {
			int right=0;
			int wrong=0;
			for (int x=0;x<testingData.length;x++) {
	
				double yes = probabilities.findYesToday(testingData[x]);
				double no = probabilities.findNoToday(testingData[x]);
				if ((yes/(yes+no)>no/(yes+no)) == testingData[x].isLoaned) {
					right++;
				} else {
					wrong++;
				}
			}
			int percent = (int) Math.round((double)right/(right+wrong)*100);
			System.out.println("Correct predictions: " + right);
			System.out.println("Incorrect predictions: " + wrong);
			System.out.println("Total predictions: "+ (right+wrong));
			System.out.println(percent);
			status.setText("Test Accuracy: " + percent + "%");
		} else {
			status.setText("Data not fully loaded");
			System.out.println("Data not fully loaded");
		}
	}
	
	//Creates the pop-up window to test individual data, and displays the result
	public void testLoaner() {
		Loaner test1;
		List<String> info = new ArrayList<String>();
		UIManager.put("OptionPane.background",new Color(60, 63, 65));
		UIManager.put("Panel.background",new Color(60, 63, 65));
		UIManager.put("Label.foreground",new Color(187, 187, 187));
		JPanel pane = new JPanel();
		JTextField gender;
		JTextField married;
		JTextField dependants;
		JTextField education;
		JTextField selfEmployed;
		JTextField income;
		JTextField coIncome;
		JTextField loanAmount;
		JTextField loanTerm;
		JTextField creditHistory;
		JTextField propertyArea;
		
		pane.setLayout(new GridLayout(0,2,2,2));
		pane.add(new JLabel("Enter gender"));
		pane.add(gender = new JTextField("Male or Female"));
		pane.add(new JLabel("Are you married?"));
		pane.add(married = new JTextField("Yes or No"));
		pane.add(new JLabel("How many dependants?"));
		pane.add(dependants = new JTextField("A Number"));
		pane.add(new JLabel("Are you educated?"));
		pane.add(education = new JTextField("Graduate or Not Graduate"));
		pane.add(new JLabel("Are you self-employed?"));
		pane.add(selfEmployed = new JTextField("Yes or No"));
		pane.add(new JLabel("What is your income?"));
		pane.add(income = new JTextField("A Number"));
		pane.add(new JLabel("What is your co-income?"));
		pane.add(coIncome = new JTextField("A Number"));
		pane.add(new JLabel("What is the loan amount?"));
		pane.add(loanAmount = new JTextField("A Number"));
		pane.add(new JLabel("What is the loan term?"));
		pane.add(loanTerm = new JTextField("A Number"));
		pane.add(new JLabel("Do you have a credit history?"));
		pane.add(creditHistory = new JTextField("1 or 0"));
		pane.add(new JLabel("What is the property Area?"));
		pane.add(propertyArea = new JTextField("Urban, Rural or Semiurban"));
		JOptionPane.showMessageDialog(pane, pane);
		info.add("1");
		info.add(gender.getText());
		info.add(married.getText());
		info.add(dependants.getText());
		info.add(education.getText());
		info.add(selfEmployed.getText());
		info.add(income.getText());
		info.add(coIncome.getText());
		info.add(loanAmount.getText());
		info.add(loanTerm.getText());
		info.add(creditHistory.getText());
		info.add(propertyArea.getText());
		test1 = new Loaner(info);
		test1.displayData();
		
		double yes = probabilities.findYesToday(test1);
		double no = probabilities.findNoToday(test1);
		System.out.println(yes + " " + no);
		
		if ((yes/(yes+no)>no/(yes+no))){
			predictionText.setText((int) Math.round((double)(yes/(yes+no))*100) + "% would be approved");
			System.out.println((int) Math.round((double)(yes/(yes+no))*100) + "% would be approved");
		} else {
			predictionText.setText((int) Math.round((double)(no/(yes+no))*100) + "% would be denied");
			System.out.println((int) Math.round((double)(no/(yes+no))*100) + "% would be denied");
		}
	}
}
