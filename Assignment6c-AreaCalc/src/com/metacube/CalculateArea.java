package com.metacube;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateArea {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// variable to store option selected by user
		int choice = 0;
		
		// variable for sides of triangle, rectangle, square and cricle radius
		double side1, side2;
		
		try {
			do {
				// show options to user
				System.out.println("Find area");
				System.out.println("1. Triangle\n2. Circle\n3. Rectangle\n4. Square\n0. Exit");
				
				// get option as input from user
				choice = input.nextInt();
				
				// create an object of Area class
				Area area = new Area();
				
				// options matching
				if (choice == 1) {
					
					System.out.println("Enter base ");
					side1 = input.nextDouble();
					System.out.println("Enter height ");
					side2 = input.nextDouble();
					System.out.println("Area of triangle " + String.format("%.2f", area.getTriangleArea(side1, side2)));
				
				} else if (choice == 2) {
					
					System.out.println("Enter radius ");
					side1 = input.nextDouble();
					System.out.println("Area of circle " + String.format("%.2f", area.getCircleArea(side1)));
				
				} else if (choice == 3) {
					
					System.out.println("Enter length ");
					side1 = input.nextDouble();
					System.out.println("Enter breadth ");
					side2 = input.nextDouble();
					System.out.println("Area of rectangle " + String.format("%.2f", area.getRectangleArea(side1, side2)));
				
				} else if (choice == 4) {
					
					System.out.println("Enter side ");
					side1 = input.nextDouble();
					System.out.println("Area of square " + String.format("%.2f", area.getSquareArea(side1)));
				
				} else if (choice == 0) {
					break;
				} else {
					System.out.println("Invalid input");
				}
			} while (choice != 0);
			
		} catch (InputMismatchException exception) {
			System.out.println("Invalid input");
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
		}
		
		input.close();
	}

}
