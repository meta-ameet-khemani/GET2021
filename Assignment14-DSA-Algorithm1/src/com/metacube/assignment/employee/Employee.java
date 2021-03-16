package com.metacube.assignment.employee;

public class Employee {

	public Node sorted = null;
	public Node current = null;
	public Node head = null;
	
	public static void main (String args[]) {
		Employee employee = new Employee();
		
	}
	
	public boolean addEmployee (int id, int salary, int age) {
		Node newNode = new Node (id, salary, age);
		if (this.head == null) {
			this.head = newNode;
			return true;
		}
		Node last = this.head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		return true;
	}
	
	public Node insertionSort (Node head) {
		this.sorted = null;
		this.current = head;
		while (this.current != null) {
			Node next = this.current.next;
			sortedInsert (current);
		}
		this.head = sorted;
		return this.head;
	}
	
	public void sortedInsert (Node newNode) {
		if (this.sorted == null || this.sorted.getSalary() <= newNode.getSalary()) {
			newNode.next = this.sorted;
			this.sorted = newNode;
		} else {
			this.current = this.sorted;
			if (this.current.next.getSalary() > newNode.getSalary()) {
				while (this.current.next != null && this.current.next.getSalary() > newNode.getSalary()) {
					this.current = this.current.next;
				}
			} else if ((this.current.next.getSalary() == newNode.getSalary()) && (this.current.next.getAge() > this.current.next.getAge())) {
				while (this.current.next != null &&
						(this.current.next.getSalary() == newNode.getSalary()) &&
						(this.current.next.getAge() > this.current.next.getAge())) {
					
					this.current = this.current.next;
				}
			}
			newNode.next = this.current.next;
			this.current.next = newNode;
		}
	}
	
}
