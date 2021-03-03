package com.metacube;

public class UsePoly {

	public static void main(String[] args) {
		
		Polynomial poly1 = new Polynomial(new int[]{2, 1, 4});
		Polynomial poly2 = new Polynomial(new int[]{1, 3});
		System.out.println(poly1.getPolynomialString(poly1));
		System.out.println(poly2.getPolynomialString(poly2));
		System.out.println("Evaluate : " + poly1.evaluate(2));
		System.out.println("Degree : " + poly1.degreeOfPolynomial());
		System.out.println("Addition : " + poly1.add(poly2));
		System.out.println(poly1.multiply(poly2));

	}

}
