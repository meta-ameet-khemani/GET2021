package com.metacube.assignment.multivariantpolynomial;

/**
 * Variable class represent a single variable in each term of polynomial expression
 * @author ameet.khemani_metacu
 *
 */
public class Variable {
	
	// character of varible e.g x, y, z
	Character variable;
	
	// power of variable
	Integer power;
	
	public Variable (Character variable, Integer power) {
		this.variable = variable;
		this.power = power;
	}	
	
}
