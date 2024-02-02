package edu.ilstu;
//by Suhail Pradip Tailor
//UID 805254601

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class StudentReport {
	
private String fileName;//declaration of  variables
private double [][]grades;
private String[]students;
private String[]gradedItems;

public StudentReport(String name) {//constructor that initializes variables by passing through a string
	name=fileName;
	this.grades=new double[100][8];//100 students and  8 elements each
	this.students=new String[100];//100 students
	this.gradedItems=new String[8];//8 graded items
}




public void readIntoArray(String name) {//methods reads data from selected file into arrays
	this.fileName=name;
	File file1=new File(this.fileName);//file object is created
	Scanner scan=null;
	
	
	try { scan=new Scanner(file1);//scanner is initialized
	
	
	
	while(scan.hasNextLine()) {//runs while next line has data
		scan.nextLine();//reads data from line
    
	for(int i=0;i<this.grades.length;i++) {//loop runs till end of array is reached
		if(scan.hasNext()) {//runs if data is available in next position
	  String[] line = scan.nextLine().split(",", -1);//reads data in form of strings separated at comma
	this.students[i]=line[0];//reads data and places it into students array
	
	for(int j=0;j<this.gradedItems.length;j++) {//loop runs through all elements in each line		
		  if(!(line[j+1]==""))
	{ 
		     
			 grades[i][j]=Double.parseDouble(line[j+1]);//takes data from line array and places it accordingly in 2d array in form of double
		  
	   }
	  }
	}
	
}
	readHeadingIntoArray(this.fileName);//filename is passed in to read headings into specific location in graded items array
	System.out.println("File has been processed successfully");//alerts user 

		
	}}catch(FileNotFoundException ex){//catches exception and displays no file found
		System.out.println("No file found!");
		
	}
	
}
public void readHeadingIntoArray(String name) {//reads first row and stores Strings into graded items array
	this.fileName=name;
	
	File file1 = new File(this.fileName);//file object created
	Scanner scan= null;//scanner object created
	try//runs code and throws any exceptions if found
	{
		scan = new Scanner(file1);//scanner initialized
		
		int num=0;//initialize num
		while (num<this.gradedItems.length)//runs while end of array has not be reached
		  { 
			if(scan.hasNext()) {//checks if next line has data
			
			String[] line = scan.nextLine().split(",");//splits data read in form of strings separated at comma
			for(int i=0;i<this.gradedItems.length;i++) {//loops through array
				this.gradedItems[i]=line[i+1];//places data into graded items array at specific locations
				num++;//Increments num
			}
		}	
			
	}}catch(FileNotFoundException e) {//catches exception and displays no file found
			System.out.println("No file found");
		}
	
	
}


public void generateReportCard(String stuName) {//writes report card to file with specific name
	int pos=0;//variables initialized
	int total=0;
	char grade='A';
	PrintWriter pw= null;//printwriter object created
	try {
		pw =new PrintWriter(new FileWriter(stuName,true));//print writer initialized to print to file which is named after input
	
	for(int i=0;i<this.students.length&&this.students[i]!=null;i++) {//loop runs while array has not ended and data is available
	if(this.students[i].equalsIgnoreCase(stuName)&&this.students[i]!=null)//checks if name matches
		pos=i;//changes value of pos to i
	}
	
	
	
	for(int j=0;j<this.gradedItems.length;j++) {//loops through elements
		pw.println(this.gradedItems[j]+"--> "+this.grades[pos][j]);//prints to file all graded items and corresponding score for each student
		total+=this.grades[pos][j];//keeps track of students total
	}
	pw.println("Total-->"+total);//prints the students total
	if(total<90) {//if statements used to determine grade achieved 
		grade='B';
	}if(total<80) {
		grade='C';
	}if(total<70) {
		grade='D';
	}if(total<60) {
		grade='F';
	}
	pw.println("Grade Achieved---> "+grade);//displays grade earned
	pw.close();//closes printer
	}catch (IOException e) {//catches exception
		e.printStackTrace();
	}
	
}
public void printList() {//prints a list of all students
	System.out.println("____");
	for (int i=0;i<this.students.length&&this.students[i]!=null;i++) {//loops through array printing each name 
	System.out.println((i+1)+"<_"+this.students[i]);
}}


public void displayStats() {//displays class statistics
	int num=0;//variable declaration
	double total=0;
	double average=0;
	int count=0;
	DecimalFormat edit=new DecimalFormat("0.00");//used to format data
	for (int i=0;i<this.students.length&&this.students[i]!=null;i++) {//loops through array and counts num of students
		count++;
	}
	
	double[]sums=new double[(count)];//creates array of size count
	for (int i=0;i<count;i++) {//loops through array of grades
		num=0;//variable is reset
		for (int j=0;j<this.grades[i].length;j++) {
			num+=this.grades[i][j];//values are added 
		
		}
		sums[i]=num;//stores data at location i in sum array	
	}
	double min=sums[0];
	double max=sums[0];
	
	for(int i=0;i<sums.length;i++) {//loops through array to calculate class total
		total+=sums[i];
		
	}
	average=total/sums.length;//calculates class average 
	System.out.println("Average-->"+edit.format(average));//displays average
	for(int i=0;i<sums.length;i++) {//loops through all values in sums array
		
		if(sums[i]>max) {//checks value at i to previous value
			max=sums[i];//sets value of max if value found is bigger than previous max
		}
	}for(int i=0;i<sums.length;i++) {//loops through all values in sums array
		
		if(sums[i]<min) {//checks value at i to previous value
			min=sums[i];//sets value of min if value found is less than previous min
		}
	}
	System.out.println("Highest scored by student -->"+max);//prints out max
	System.out.println("Lowest scored by student -->"+min);//prints out minimum
}


}
