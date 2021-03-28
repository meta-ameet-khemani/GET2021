package com.metacube.assignment.model;

/**
 * Category class represents a category in store front
 * @author ameet.khemani_metacu
 */
public class Category {
	
	// name of category
	String name;
	
	// number of children of category
	int numOfChildren;
	
	public Category (String name, int numOfChildren) {
		this.name = name;
		this.numOfChildren = numOfChildren;
	}
	
	public String getName () {
		return this.name;
	}
	
	public int getNumOfChildren () {
		return this.numOfChildren;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setNumOfChildren (int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
}
