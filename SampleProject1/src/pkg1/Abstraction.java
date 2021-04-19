package pkg1;

import java.util.Scanner;

abstract class Shape {  
	abstract void draw();  
}  
  
class Rectangle extends Shape 
{  
	double area;
	void draw() 
	{
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the length of Rectangle:");
		double length = s1.nextDouble();
		System.out.println("Enter the width of Rectangle:");
		double width = s1.nextDouble();
   
		area = length*width;
		System.out.println("Area of Rectangle is:"+area);
		s1.close();
	}  
}  
class Circle extends Shape 
{  
	int radius;
	double pi = 3.14, area;
	void draw() 
	{
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the radius :");
		radius = s1.nextInt();
		area = pi * radius * radius;
        System.out.println("Area of circle:"+area);
        s1.close();
	}  
}  
  