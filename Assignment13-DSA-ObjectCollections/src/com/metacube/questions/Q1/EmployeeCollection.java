package com.metacube.questions.Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * EmployeeCollection represents a collection of Employee
 * @author ameet.khemani_metacu
 */
public class EmployeeCollection {

	// list to contain employees
	public List<Employee> employeeList = new ArrayList<>();
	
	/**
	 * Used to add employee
	 * @param employee to be added
	 * NOTE:- employee must have unique id
	 */
	public boolean addEmployee (Employee employee) {
		
		boolean isPresent = false;
		
		if (employee == null) {
			throw new AssertionError("Cannot add null");
		}

		for (Employee emp : employeeList) {
			if (emp.getEmpID() == employee.getEmpID())
				isPresent = true;
		}
		if (isPresent) {
			throw new AssertionError("Unique employee is needed");
		} else {
			employeeList.add(employee);
			return true;
		}
	}
	
	/**
	 * Sorting employees by their name wise
	 */
	public void sortEmployeesByName () {
		Collections.sort(employeeList, new Comparator<Employee>() {
			public int compare (Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
	}
	
	/**
	 * Sorting employees by their id wise
	 */
	public void sortEmployeesById () {
		Collections.sort(employeeList, new Comparator<Employee>() {
			public int compare (Employee e1, Employee e2) {
				return Integer.valueOf(e1.getEmpID()).compareTo(e2.getEmpID());
			}
		});
	}

	@Override
	public String toString() {
		String result = "";
		for (Employee emp : employeeList)
			result += "\n" + emp.getName() + " " + emp.empID;
		return result;
	}
	
}
