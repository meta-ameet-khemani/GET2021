package com.metacube.Q3Counselling;

/**
 * StudentStream model represents the content of file which contains
 * @author ameet.khemani_metacu
 */
public class StudentStream {
	
	// representing the name of student
	String studentName;
	
	// Representing the stream alloted to student
	String allotedStream;
	
	public StudentStream(String studentName, String allotedStream) {
		this.studentName = studentName;
		this.allotedStream = allotedStream;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getAllotedStream() {
		return allotedStream;
	}
}
