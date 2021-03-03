package com.metacube.test.Q1LCMHCF;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.operations.Q1LCMHCF.LCMHCF;

@RunWith(Parameterized.class)
public class LCMTest {
	
	public Integer num1;
	public Integer num2;
	public Integer expectedResult;
	
	public LCMTest(Integer num1, Integer num2, Integer expectedResult) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{15, 20, 60},
				{5, 7, 35},
				{20, 42, 420}
		});
	}
	
	/**
	 * Testing LCM with above numbers
	 */
	@Test
	public void testLCM() {
		assertEquals(this.expectedResult, LCMHCF.calculateLCM(this.num1, this.num2));
	}

}
