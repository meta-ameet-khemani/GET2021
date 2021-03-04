package com.metacube.assignment.multivariantpolynomial;

import java.util.List;

/**
 * Term class represents each term in polynomial expression
 * @author ameet.khemani_metacu
 *
 */
public class Term {
	
	// coefficient of each term
	Integer coEfficient;
	
	// list of multiple variables in each term
	List<Variable> variables;
	
	public Term (Integer coEfficient, List<Variable> variables) {
		this.coEfficient = coEfficient;
		this.variables = variables;
	}
	
}
