package com.metacube.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.metacube.operations.MaxMirror;

@RunWith(Parameterized.class)
public class MaxMirrorTest {
	
	public int[] array;
	public int length;
	
	public MaxMirrorTest(int[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testValues() {
		return Arrays.asList(new Object[][]{
			{new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3},
			{new int[]{7, 1, 4, 9, 7, 4, 1}, 2},
			{new int[]{1, 2, 1, 4}, 3},
			{new int[]{1, 4, 5, 3, 5, 4, 1}, 7},
			{new int[]{1, 2, 3}, 1},
		});
	}
	
	@Test
	public void multipleParametersTest() {
		assertEquals(length, MaxMirror.maxMirror(this.array));
	}

	@Test
	public void singleFirstTest() {
		assertEquals(3, MaxMirror.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
	}
	
//	@Test
//	public void singleSecondTest() {
//		assertEquals(3, MaxMirror.maxMirror(new int[]{}));
//	}

}
