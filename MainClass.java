package edu.ilstu;

import java.util.InputMismatchException;
import java.util.Scanner;
//by Suhail Pradip Tailor
//UID 805254601

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Welcome");//prompts user
		int selection =0;//variables are initialized
		String stuName="";
		String name="";
		String fName="";
		String lName="";
		Scanner scan=new Scanner(System.in);//creates scanner object
		StudentReport report=new StudentReport(name);//creates student report object
		
		try {
			while(selection!=5) {
		//loop runs until user selects exit
			
		System.out.println("Please enter a selection"+"\n"+"1. Enter filename to process"+"\n"+"2. Print a list of all students"+"\n"+"3. Generate report card for a student"+"\n"+"4. Display Statistics"+"\n"+"5. Exit");//list is displayed to user
		selection=0;
		
		
		selection=scan.nextInt();//reads input
		
		if(selection==1) {
			System.out.println("Enter file name");//prompts user for input
			name=scan.next();//reads input from user
			
		report.readIntoArray(name);//passes input as parameter into method
		
			}
		else if(selection==2) {//calls method and executes it.
			report.printList();//prints list of students
			System.out.println();
			
		}
		else if(selection==3) {//runs if 3 is selected
			
			System.out.println("Enter Students First Name; ");//prompts user
			fName=scan.next();//reads input
			System.out.println("Enter Students Last Name; ");//prompts user
            lName=scan.next();//reads input
            stuName=fName+" "+lName;//combines input
			report.generateReportCard(stuName);//passes combined input to method 
			System.out.println("Reportcard generated");//alerts user 
			System.out.println();
			
		}
	else if(selection==4) {//runs if 4 is selected
		
		report.displayStats();//calls method to displays class statistics
		System.out.println();
		}
		
	else if(selection<0||selection>5) {
			System.out.println("invalid input\ninput has to be between 1 and 5");//displays if input is invalid

		}
		
		
		}
		}catch(InputMismatchException ex) {//catches the input mismatch error 
			
			scan.next();
		System.out.println("invalid input\ninput has to be between 1 and 5");//displays if error is thrown
			
		}
		System.out.println("_____Program End_____");//executes once 5 is selected
	}

}
