package com.metacube.test.Q1LCMHCF;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.metacube.operations.Q1LCMHCF.LCMHCF;

@RunWith(Parameterized.class)
public class HCFTest {
	
	public Integer num1;
	public Integer num2;
	public Integer expectedResult;
	
	public HCFTest (Integer num1, Integer num2, Integer expectedResult) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{10, 15, 5},
				{35, 10, 5},
				{31, 2, 1}
		});
	}

	/**
	 * Testing LCM with above numbers
	 */
	@Test
	public void testHCF() {
		assertEquals(this.expectedResult, LCMHCF.calculateHCF(this.num1, this.num2));
	}
}
