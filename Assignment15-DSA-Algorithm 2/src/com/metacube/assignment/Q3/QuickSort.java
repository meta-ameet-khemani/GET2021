package com.metacube.assignment.Q3;

import java.util.LinkedList;

/**
 * QuickSort class implements Quick Sort algorithm for sorting
 * @author ameet.khemani_metacu
 */
public class QuickSort {

	static LinkedList<Employee> employeeList = new LinkedList<Employee>();
	
	public static void main (String args[]) {
		Employee e1 = new Employee("A", 30, 30000);
		Employee e2 = new Employee("B", 35, 30000);
		Employee e3 = new Employee("C", 40, 135000);
		Employee e4 = new Employee("D", 36, 25000);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		
		sort(employeeList, 0, 3);
		
		for (int i = 0; i < employeeList.size(); i++) {
			System.out.println(employeeList.get(i).getName());
		}
	}
	
	public static void sort (LinkedList<Employee> list, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(list, low, high);
			sort(list, low, partitionIndex - 1);
			sort(list, partitionIndex + 1, high);
		}
	}
	
	public static int partition (LinkedList<Employee> list, int low, int high) {
		int i = low - 1;
		try {
			Employee highNode = list.get(high);
			for (int j = low; j < high; j++) {
				Employee node = list.get(j);
				if ((node.getSalary() > highNode.getSalary()) || ((node.getSalary() == highNode.getSalary()) && (node.getAge() < highNode.getAge()) )) {
					i++;
					Employee nodeTemp = list.get(i);
					swapList(nodeTemp, node);
				}
			}
			Employee nodePar = list.get(i + 1);
			swapList(nodePar, highNode);
		} catch (NullPointerException exception) {
			exception.printStackTrace();
		}
		return i + 1;
	}
	
	public static void swapList (Employee e1, Employee e2) {
		Employee tempEmployee = new Employee("ABC", 35, 28900);
		tempEmployee.name = e1.getName();
		tempEmployee.age = e1.getAge();
		tempEmployee.salary = e1.getSalary();
		
		e1.name = e2.getName();
		e1.age = e2.getAge();
		e1.salary = e2.getSalary();
		
		e2.name = tempEmployee.getName();
		e2.age = tempEmployee.getAge();
		e2.salary = tempEmployee.getSalary();
	}
	
}
