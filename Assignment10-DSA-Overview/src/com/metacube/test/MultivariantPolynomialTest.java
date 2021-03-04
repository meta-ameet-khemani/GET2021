package com.metacube.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.assignment.multivariantpolynomial.MultivariantPolynomial;

public class MultivariantPolynomialTest {

	// test the degree of MultivariantPolynomial expression
	@Test
	public void testDegreeOfMultivariantPolynomial() {
		MultivariantPolynomial poly = new MultivariantPolynomial(new Integer[]{1, 2, 1, -6, 3, 12, 3, 12, 12});
		assertEquals((Integer)24, poly.findDegree());
	}

}
