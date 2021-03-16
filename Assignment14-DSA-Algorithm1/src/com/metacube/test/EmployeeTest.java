package com.metacube.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.assignment.employee.Employee;
import com.metacube.assignment.employee.Node;

public class EmployeeTest {

	@Test
	public void addEmployee () {
		Employee employee = new Employee ();
		employee.addEmployee(1, 101, 21);
		assertTrue(employee.addEmployee(2, 301, 23));
	}
	
	@Test
	public void forSortListTestPositive (){
		Employee employee = new Employee ();
		employee.addEmployee(1, 101, 21);
		employee.addEmployee(2, 301, 24);
		employee.addEmployee(3, 301, 22);
		
		int id[] = {3, 2, 1};
		int salary[] = {301, 301, 101};
		int age[] = {22, 24, 21};
		
		Node ptr = employee.insertionSort(employee.head);
		int i = 0;
		while (ptr != null) {
			assertEquals(ptr.getSalary(), salary[i]);
			assertEquals(ptr.getId(), id[i]);
			assertEquals(ptr.getAge(), age[i]);
			ptr = ptr.next;
			i++;
		}
		
	}

}
