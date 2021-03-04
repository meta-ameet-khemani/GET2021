package com.metacube.assignment.multivariantpolynomial;

import java.util.ArrayList;
import java.util.List;

/**
 * MultivariantPolynomial class represents and polynomial expression with multiple varibles
 * @author ameet.khemani_metacu
 *
 */
public class MultivariantPolynomial {

	// list containing all terms
	public List<Term> polynomial = new ArrayList<>();
	
	/**
	 * Constructor accepting an array of values
	 * @param array of type Integer
	 */
	public MultivariantPolynomial (Integer array[]) {
		
		for (int loop = 0; loop < array.length; loop = loop + 3) {
			
			// creating x variable
			Variable var1 = new Variable('x', array[loop + 1]);
			
			// creating y variable
			Variable var2 = new Variable('y', array[loop + 2]);
			
			List<Variable> variable = new ArrayList<Variable>();
			
			// adding both x and y to variable list
			variable.add(var1);
			variable.add(var2);
			
			// adding variable list to term
			Term term = new Term(array[loop], variable);
			
			// adding term to polynomial expression
			polynomial.add(term);
			
		}
	}
	
	/**
	 * Used to print the polynomial expression
	 */
	public void showPolynomial () {
		
		// iterating through polynomial expression
		for (int loopCounter = 0; loopCounter < this.polynomial.size(); loopCounter++) {
			
			// getting single term in expression
			Term term = this.polynomial.get(loopCounter);
			
			if (loopCounter == 0) {
				if (term.coEfficient > 0) {
					System.out.print(term.coEfficient);		
				} else {
					System.out.print(term.coEfficient);
				}
			} else {
				if (term.coEfficient > 0) {
					System.out.print(" + " + term.coEfficient);		
				} else {
					System.out.print(" - " + (-1 * term.coEfficient));
				}
			}
			
			// getting variables in each term
			for (Variable var : term.variables) {
				if (var.variable == 'x')
					System.out.print("x^" + var.power);
				if (var.variable == 'y')
					System.out.print("y^" + var.power);
			}
		}
	}
	
	/**
	 * Used to get the highest degree of polynomial expression
	 * @return the highest degree of type Integer
	 */
	public Integer findDegree () {
		Integer degree = 0;
		for (Variable var : this.polynomial.get(0).variables)
			degree += var.power;
		for (Term term : this.polynomial) {
			Integer sum = 0;
			for (Variable var : term.variables) {
				sum += var.power;
			}
			if (sum > degree) {
				degree = sum;
			}
		}
		return degree;
	}

}
