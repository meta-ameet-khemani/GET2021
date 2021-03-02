package com.metacube.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.metacube.operations.SplitArray;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	
	public int[] array;
	public int index;
	
	public SplitArrayTest(int[] array, int index) {
		this.array = array;
		this.index = index;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testValues() {
		return Arrays.asList(new Object[][]{
			{new int[]{1, 1, 1, 2, 1}, 3},
			{new int[]{2, 1, 1, 2, 1}, -1},
			{new int[]{10, 10}, 1}
		});
	}
	
	@Test
	public void multipleParametersTest() {
		assertEquals(index, SplitArray.splitArrays(this.array));
	}

//	@Test
//	public void singleFirstTest() {
//		assertEquals(3, SplitArray.splitArrays(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
//	}
	
//	@Test
//	public void singleSecondTest() {
//		assertEquals(3, SplitArray.splitArrays(new int[]{}));
//	}

}
