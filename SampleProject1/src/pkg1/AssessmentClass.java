package pkg1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AssessmentClass implements CalculatorInterface 
{

	public static void main(String[] args) 
	{
		AssessmentClass t = new AssessmentClass();
        t.display();
	}
	
	public void display()
	{
		try {
			int option, shape;
				
			String greet = "Welcome User "+ LocalDateTime.now()+"\n";
			System.out.println(greet);
			// writing the content to file
			this.writetoFile(greet+" \n");
			
			// TODO Auto-generated method stub
			Scanner s1 = new Scanner(System.in);
			System.out.println("Please provide the input in numeric format: "+ "\n"
					+ "1) Addition" + "\n"
					+ "2) Subtraction" + "\n"
					+ "3) Division" + "\n"
					+ "4) Multiplication" + "\n"
					+ "5) Shape ( 1. Circle 2. Rectangle )");
			
			option  = s1.nextInt();
			
			switch (option) {
				case 1:
					this.add();
					break;
				case 2:
					this.substract();
					break;
				case 3:
					this.division();
					break;
				case 4:
					this.multiply();
					break;
				case 5:
					System.out.println("Please Enter the Shape 1 for Circle and 2 for Rectangle:");
					shape = s1.nextInt();
					
					if (shape == 1) {
						this.writetoFile("User Entered Shape Circle \n");
						Shape s = new Circle();  
						s.draw(); 
					} else {
						this.writetoFile("User Entered Shape Rectangle \n");
						Shape s = new Rectangle();  
						s.draw();
					}				
					break;
								
			}
			s1.close();
			
		} catch(InputMismatchException e) {
			System.out.print("Invalid number entered. ");
		}		
	}
	
	/**
	 * Function used for adding multiple numbers
	 */
	public void add()
	{
		// writing the content to file
		this.writetoFile("----- User selected option Addition -------- \n ");
		int sum=0;
		System.out.print("Enter a series of values: ");
		Scanner input = new Scanner(System.in);
		String line;
        while (!(line = input.nextLine()).isEmpty()) {
            sum = sum + Integer.parseInt(line);
            this.writetoFile("User entered number "+ Integer.parseInt(line)+" \n");
        }

        System.out.println("The sum of the numbers is " + sum);
        this.writetoFile("--------------The sum of the numbers is "+ sum +" -------------- \n ");
        input.close();
	}
	
	/**
	 * Function used for subtraction
	 */
	public void substract()
	{
		this.writetoFile("----- User selected option Subtractiooin -------- \n ");
		int num1, num2;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Input first number :");
		num1 = s1.nextInt();
		this.writetoFile("User entered first number "+ num1 +" \n");
		System.out.println("Input second number :");
		num2 = s1.nextInt();
		this.writetoFile("User entered second number "+ num2 +" \n");
		
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		this.writetoFile("--------------Subtraction of numbers "+ num1 + " - " + num2 + " = " + (num1 - num2) +" -------------- \n");
		s1.close();
	}
	
	/**
	 * Function used for multiplication
	 */
	public void multiply()
	{
		this.writetoFile("----- User selected option Multiplication -------- \n ");
		int multiplication = 1;
		System.out.print("Enter a series of values: ");
		Scanner scObj = new Scanner(System.in);
		String strLine;
        while (!(strLine = scObj.nextLine()).isEmpty()) {
        	multiplication = multiplication * Integer.parseInt(strLine);
        	this.writetoFile("User entered number "+ Integer.parseInt(strLine)+" \n");
        }

        System.out.println("The multiplication of the numbers is " + multiplication);
        this.writetoFile("-------------- The multiplication of the numbers is "+ multiplication +" -------------- \n");
        scObj.close();
	}
	
	/**
	 * Function used for division
	 */
	public void division()
	{
		this.writetoFile("----- User selected option Division -------- \n ");
		int num1, num2;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Input first number :");
		num1 = s1.nextInt();
		this.writetoFile("User entered first number "+ num1 +" \n");
		System.out.println("Input second number :");
		num2 = s1.nextInt();
		this.writetoFile("User entered second number "+ num2 +" \n");
		
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		this.writetoFile("-------------- Division of numbers is "+ num1 + " / " + num2 + " = " + (num1 / num2) +" -------------- \n");
		s1.close();
	}
	
	/**
	 * This function is used to write the contents to file
	 * @param input
	 */
	public void writetoFile(String input)
	{
		try {
			//Specify the file name and path here
	    	File file =new File("C://Users/VEDIKA/eclipse-workspace/myfile.txt");

	    	/* This logic is to create the file if the
	    	 * file is not already present
	    	 */ 
	    	if (!file.exists()) {
	    	   file.createNewFile();
	    	}
	    	
	    	//Here true is to append the content to file
	    	FileWriter fw = new FileWriter(file,true);
	    	//BufferedWriter writer give better performance
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	
	    	bw.write(input);
	    	//Closing BufferedWriter Stream
	    	bw.close();
		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
	    	ioe.printStackTrace();
		}		
	}
}
