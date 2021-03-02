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
			{new int[]{1, 2, 2, 3, 4, 4}, 2},
			{new int[]{1, 1, 2, 1, 1}, 2},
			{new int[]{1, 1, 1, 1}, 1}
		});
	}
	
	@Test
	public void multipleParametersTest() {
		assertEquals(clumpCount, CountClump.countClumps(this.array));
	}

	@Test
	public void singleFirstTest() {
		assertEquals(1, CountClump.countClumps(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
	}
	
	@Test
	public void singleSecondTest() {
		assertEquals(3, CountClump.countClumps(new int[]{}));
	}

}
