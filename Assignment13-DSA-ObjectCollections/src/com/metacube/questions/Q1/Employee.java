package com.metacube.questions.Q1;

/**
 * Employee class
 * @author ameet.khemani_metacu
 */
public class Employee {

	// unique ID
	int empID;
	
	// name of employee
	String name;
	
	// address of employee
	String address;
	
	public Employee(int empID, String name, String address) {
		super();
		this.empID = empID;
		this.name = name;
		this.address = address;
	}

	public int getEmpID() {
		return empID;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
}
