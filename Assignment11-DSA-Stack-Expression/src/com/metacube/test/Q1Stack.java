package com.metacube.test;

import org.junit.Assert;
import org.junit.Test;
import com.metacube.Q1Stack.InfixExpression;

/**
 * Test class for stack operations
 * @author ameet.khemani_metacu
 */
public class Q1Stack {

	// positive test case for expression
	@Test
	public void testExpressionTrue () {
		Assert.assertEquals((Integer) 22, InfixExpression.evaluateString("3 * 4 + ( 5 * 2 )"));
	}
	
	// negative test case for expression
	@Test
	public void testExpressionFalse () {
		Assert.assertNotEquals((Integer) 2, InfixExpression.evaluateString("3 * 4 + ( 5 * 2 )"));
	}

}
