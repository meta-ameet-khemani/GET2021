package com.metacube;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Marksheet class which possess different marksheet functions
 * @author ameet.khemani_metacu
 *
 */
public class Marksheet {

	// Decimal format to show values upto 2 decimal points
	static DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of student");
		int numOfStudents = 0;
		try {
			numOfStudents = input.nextInt();
			if (numOfStudents <= 0) {
				throw new InputMismatchException("You must enter positive value");
			}
		} catch (InputMismatchException exception) {
			System.out.println("You must enter positive value");
			System.exit(0);
		}
		
		// we are assuming that there are total 5 subjects 
		int marks[][] = new int[numOfStudents][5];
		getFakeMarks(marks);
		
		// displaying marks for each student
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			System.out.print("Student " + (studentCounter + 1) + " Marks ");
			for (int subjectCounter = 0; subjectCounter < marks[0].length; subjectCounter++) {
				System.out.print(marks[studentCounter][subjectCounter] + " ");
			}
			System.out.println();
		}
		
		double averageMarks[] = getAverageMarks(marks);
		
		// displaying average marks for each student
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			System.out.print("\nStudent " + (studentCounter + 1) + " Average Marks " + averageMarks[studentCounter]);
		}
		
		int maxMarks[] = getMaximumMarks(marks);
		
		System.out.println();
		
		// displaying maximum marks for each student
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			System.out.print("\nStudent " + (studentCounter + 1) + " Max Marks " + maxMarks[studentCounter]);
		}
		
		
		int minMarks[] = getMinimumMarks(marks);
		
		System.out.println();
		
		// displaying minimum marks for each student
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			System.out.print("\nStudent " + (studentCounter + 1) + " Min Marks " + minMarks[studentCounter]);
		}
		
		getPercentage(marks);
		input.close();
	}
	
	/**
	 * shows percentage of students passes
	 * we are assuming that a student has to get passed (marks >= 40) in atleast 40% of subjects
	 * @param marks
	 */
	public static void getPercentage(int marks[][]) {
		int minimumNumberOfSubjectsToBePassedIn = (int)((0.4)*(double)(marks[0].length));
		int totalStudentsPassed = 0;
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			int subjectsInPassed = 0;
			for (int subjectCounter = 0; subjectCounter < marks[0].length; subjectCounter++) {
				if (marks[studentCounter][subjectCounter] >= 40 ) {
					subjectsInPassed++;
				}
			}
			if (subjectsInPassed >= minimumNumberOfSubjectsToBePassedIn) {
				totalStudentsPassed++;
			}
		}
		System.out.println("\nPercentage of Student passed : " + Double.parseDouble(String.format("%.2f", ((double)totalStudentsPassed / marks.length) * 100)));
	}
	
	/**
	 * calculates minimum marks for each student
	 * @param marks
	 * @return an array of minimum marks
	 */
	public static int[] getMinimumMarks(int marks[][]) {
		int minMarksOfEachStudent[] = new int[marks.length];
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			int minMarks = marks[studentCounter][0];
			for (int subjectCounter = 0; subjectCounter < marks[0].length; subjectCounter++) {
				if (minMarks > marks[studentCounter][subjectCounter])
					minMarks = marks[studentCounter][subjectCounter];
			}
			minMarksOfEachStudent[studentCounter] = minMarks;
		}
		return minMarksOfEachStudent;
	}
	
	/**
	 * calculates maximum marks for each student
	 * @param marks
	 * @return an array of maximum marks
	 */
	public static int[] getMaximumMarks(int marks[][]) {
		int maxMarksOfEachStudent[] = new int[marks.length];
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			int maxMarks = 0;
			for (int subjectCounter = 0; subjectCounter < marks[0].length; subjectCounter++) {
				if (maxMarks < marks[studentCounter][subjectCounter])
					maxMarks = marks[studentCounter][subjectCounter];
			}
			maxMarksOfEachStudent[studentCounter] = maxMarks;
		}
		return maxMarksOfEachStudent;
	}
	
	/**
	 * calculates average marks for each student
	 * @param marks
	 * @return an array of average marks
	 */
	public static double[] getAverageMarks(int marks[][]) {
		double averageMarks[] = new double[marks.length];
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			double totalMarks = 0.0d;
			for (int subjectCounter = 0; subjectCounter < marks[0].length; subjectCounter++) {
				totalMarks += (double)marks[studentCounter][subjectCounter];
			}
			averageMarks[studentCounter] = Double.parseDouble(String.format("%.2f", (double)(totalMarks / marks[0].length)));
		}
		return averageMarks;
	}
	
	/**
	 * Auto generating some random marks for each student
	 * @param marks
	 */
	public static void getFakeMarks(int marks[][]) {
		for (int studentCounter = 0; studentCounter < marks.length; studentCounter++) {
			for (int subjectCounter = 0; subjectCounter < marks[0].length; subjectCounter++) {
				marks[studentCounter][subjectCounter] = (int)(Math.random() * 100);
			}
		}
	}

}
