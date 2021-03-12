package com.metacube.test.Q1;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.questions.Q1.Employee;
import com.metacube.questions.Q1.EmployeeCollection;

/**
 * Employee test class checks all operations on Employee collection
 * @author ameet.khemani_metacu
 *
 */
public class EmployeeTest {

	/**
	 * Test case for successfully adding employee to collection
	*/
	@Test
	public void addEmployeeTest () {
		EmployeeCollection empColl = new EmployeeCollection();
		assertEquals(true, empColl.addEmployee(new Employee(1, "First name", "First address")));
	}
	
	/**
	 * Test case for adding duplicate employee
	*/
	@Test(expected = AssertionError.class)
	public void addDuplicateEmployeeTest () {
		EmployeeCollection empColl = new EmployeeCollection();
		empColl.addEmployee(new Employee(1, "First name", "First address"));
		empColl.addEmployee(new Employee(1, "First name", "First address"));
	}
	
	/**
	 * Test case for adding null
	*/
	@Test(expected = AssertionError.class)
	public void addNullTest () {
		EmployeeCollection empColl = new EmployeeCollection();
		empColl.addEmployee(null);
	}

}
