package com.metacube.test;

import static org.junit.Assert.*; 

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.metacube.operations.CountClump;

@RunWith(Parameterized.class)
public class CountClumpTest {

	public int[] array;
	public int clumpCount;
	
	public CountClumpTest(int[] array, int clumpCount) {
		this.array = array;
		this.clumpCount = clumpCount;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testValues() {
		return Arrays.asList(new Object[][]{
			{new int[]{1, 2, 2, 3, 4, 4}, 2},		// first test input
			{new int[]{1, 1, 2, 1, 1}, 2},			// second test input
			{new int[]{1, 1, 1, 1}, 1}				// third test input
		});
	}
	
	/**
	 * Testing with above inputs
	 */
	@Test
	public void multipleParametersTest() {
		assertEquals(clumpCount, CountClump.countClumps(this.array));
	}

	/**
	 * Testing with same elements in array
	 */
	@Test
	public void sameElementTest() {
		assertEquals(1, CountClump.countClumps(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
	}

	/**
	 * Testing with an empty array
	 */
	@Test(expected = AssertionError.class)
	public void testEmptyArray() {
		CountClump.countClumps(new int[]{});
	}

}
