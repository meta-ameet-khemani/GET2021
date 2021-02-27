package com.metacube;

/**
 * Polynomial class
 * @author ameet.khemani_metacu
 */
public final class Polynomial {
	
	private int[] terms;
	private int degree;
	
	public Polynomial(int[] terms) {
		this.terms = terms;
		this.degree = terms.length - 1;
	}
	
	/**
	 * evaluated polynomial expression on particular value
	 * @param value
	 * @return evaluated value
	 */
	public float evaluate(float value) {
		float evaluatedValue = (float)0.0;
		for (int loopCounter = this.degree; loopCounter >= 0; loopCounter--) {
			evaluatedValue += (float)(this.terms[loopCounter] * Math.pow(value, loopCounter));
		}
		return evaluatedValue;
	}
	
	/**
	 * gives the degree of polynomial expression
	 * @return
	 */
	public int degreeOfPolynomial() {
		return this.degree;
	}
	
	/**
	 * adds polynomial string
	 * @param input to be added
	 * @return added polynomial as string
	 */
	public String add(Polynomial input) {
		int maxLen = Math.max(this.degree + 1, input.degree + 1);
		int minLen = Math.min(this.degree + 1, input.degree + 1);
		Polynomial sum = new Polynomial(new int[maxLen]);
		for (int loopCounter = 0; loopCounter < minLen; loopCounter++) {
			sum.terms[loopCounter] = this.terms[loopCounter] + input.terms[loopCounter];
		}
		if (maxLen == input.terms.length) {
			for (int loopCounter = minLen; loopCounter < maxLen; loopCounter++) {
				sum.terms[loopCounter] = input.terms[loopCounter];
			}
		} else {
			for (int loopCounter = minLen; loopCounter < maxLen; loopCounter++) {
				sum.terms[loopCounter] = this.terms[loopCounter];
			}
		}
		return getPolynomialString(sum);
	}
	
	/**
	 * multiplies polynomial expression
	 * @param input to be multiplied
	 * @return multiplied polynomial as string
	 */
	public String multiply(Polynomial input) {
		Polynomial multiplied = new Polynomial(new int[this.degree + input.degree + 1]);
		for (int loopCounter = 0; loopCounter <= this.degree; loopCounter++) {
			for (int nestedLoopCounter = 0; nestedLoopCounter <= input.degree; nestedLoopCounter++) {
				multiplied.terms[loopCounter + nestedLoopCounter] += this.terms[loopCounter] * input.terms[nestedLoopCounter];
			}
		}
		return getPolynomialString(multiplied);
	}
	
	/**
	 * converts polynomial to string
	 * @param polynomial to be converted
	 * @return polynomial expression as string
	 */
	public String getPolynomialString(Polynomial polynomial) {
		StringBuilder polynomialString = new StringBuilder();
		for (int loopCounter = polynomial.terms.length - 1; loopCounter > 0; loopCounter--) {
			if (polynomial.terms[loopCounter] == 0) {
				polynomialString.append("0 + ");
			} else {
				polynomialString.append(polynomial.terms[loopCounter] + "x^" + loopCounter + " + ");
			}
		}
		polynomialString.append(polynomial.terms[0]);
		return polynomialString.toString();
	}

}
