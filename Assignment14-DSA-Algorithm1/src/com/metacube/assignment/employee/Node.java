package com.metacube.assignment.employee;

/**
 * Node class represents single node of dictionary
 * @author ameet.khemani_metacu
 *
 */
public class Node {

	// id of employee
	private int id;
	
	// age of employee
	private int age;
	
	// salary of employee
	private int salary;
	
	// next linked node of current node
	public Node next;
	
	public Node (int id, int salary, int age) {
		try {
			this.id = id;
			this.salary = salary;
			this.age = age;
			this.next = null;
		} catch (Exception exception) {
			throw new AssertionError("Wrong input");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
