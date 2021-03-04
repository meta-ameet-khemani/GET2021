package com.metacube.assignment.multivariantpolynomial;

public class Polynomial {
	
	public static void main (String args[]) {
		
		MultivariantPolynomial poly = new MultivariantPolynomial(new Integer[]{
				-1, 2, 1, -6, 23, 12, 3, 12, 12
		});
		
		System.out.print("Multivariant polynomial expression : ");
		poly.showPolynomial();
		System.out.print("\n\nDegree : ");
		System.out.println(poly.findDegree());
		
	}
	
}
