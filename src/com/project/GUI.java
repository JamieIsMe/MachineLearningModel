package com.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class GUI{
	private JFrame frame;
	private JTextField input;
	private JLabel label;
	private JLabel title;
	private JButton display;
	private JButton add;
	private JButton edit;
	private JButton save;
	private JButton clear;
	private int width;
	private int height;
	private ArrayList<String> names =  new ArrayList<String>();
	private String words = "<html>";
	String[] stuff;

	public GUI(int w, int h) {
		frame = new JFrame();
		label = new JLabel("");
		title = new JLabel("Training/Test Data");
		input = new JTextField(10);
		input.setText("");
		display = new JButton("Display");
		add = new JButton("Add");
		edit = new JButton("Edit");
		clear = new JButton("Clear");
		save = new JButton("Save");
		width = w;
		height = h;
	}
		
	public void setUpGUI() {
		Container pane = frame.getContentPane();
		FlowLayout flow = new FlowLayout();
		pane.setLayout(flow);
		frame.setSize(width,height);
		frame.setTitle("MLM");
		pane.add(title);
		pane.add(label);
		pane.add(display);
		pane.add(add);
		pane.add(edit);
		pane.add(clear);
		pane.add(save);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);		
	}
	
	public void setUpButtonListeners() throws IOException, FileNotFoundException{
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object o = ae.getSource();
				if(o == display) {
					try {
						names.clear();
						Scanner in = new Scanner(new FileReader("phonedirectory.txt"));
						while (in.hasNextLine()) {
							names.add(in.nextLine());
						}
						for (int i = 0;i<names.size();i++) {
							words+=names.get(i)+"<br>";
						}
						label.setText(words);
						words="<html>";
						in.close();
						
					} catch(Exception e ) {
						System.out.println(e);
					}
				} else if (o == add) {
					String path = JOptionPane.showInputDialog("Enter a Name");
					String p = JOptionPane.showInputDialog("Enter a Number");

					for (int i = 0;i<names.size();i++) {
						words+=names.get(i)+"<br>";
					}
					names.add(path+","+p);
					words+=path+","+p+"<br>";
					label.setText(words);
					words="<html>";
					}
				else if (o == edit) {
					String path = JOptionPane.showInputDialog("Enter element number");
					String word = JOptionPane.showInputDialog("Enter a Name");
					String p = JOptionPane.showInputDialog("Enter a Number");
					names.set(Integer.parseInt(path), word+","+p);
					for (int i = 0;i<names.size();i++) {
						words+=names.get(i)+"<br>";
					}
					label.setText(words);
					words="<html>";
				} else if (o==save) {
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("staffphone.txt"));
						for (int i = 0;i<names.size();i++) {
							writer.append(names.get(i)+"\n");
						}
			
					    
					    writer.close();
					} catch(Exception e){
						System.out.println(e);
					}
				} else if (o==clear){
					names.clear();
					label.setText("");
				}
				
			}

		};

		display.addActionListener(buttonListener);
		add.addActionListener(buttonListener);	
		edit.addActionListener(buttonListener);
		save.addActionListener(buttonListener);
		clear.addActionListener(buttonListener);
	}
	
}