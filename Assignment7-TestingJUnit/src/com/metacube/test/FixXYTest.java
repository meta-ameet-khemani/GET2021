package com.metacube.test;

import static org.junit.Assert.*; 
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.metacube.operations.FixXY;

@RunWith(Parameterized.class)
public class FixXYTest {

	public int[] array;
	public int x;
	public int y;
	public int[] result;
	
	public FixXYTest(int[] array, int x, int y, int[] result) {
		this.array = array;
		this.x = x;
		this.y = y;
		this.result = result;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testValues() {
		return Arrays.asList(new Object[][]{
			{new int[]{5, 4, 9, 4, 9, 5}, 4, 5, new int[]{9, 4, 5, 4, 5, 9}},
			{new int[]{1, 4, 1, 5}, 4, 5, new int[]{1, 4, 5, 1}},
			{new int[]{1, 4, 1, 5, 5, 4, 1}, 4, 5, new int[]{1, 4, 5, 1, 1, 4, 5}}
		});
	}
	
	@Test
	public void multipleParametersTest() {
		assertArrayEquals(this.result, FixXY.fixXY(this.array, this.x, this.y));
	}

//	@Test
//	public void singleFirstTest() {
//		assertArrayEquals(this.result, FixXY.fixXY(new int[]{4, 4, 4, 5, 5, 5, 5, 5}, this.x, this.y));
//	}
	
//	@Test
//	public void singleSecondTest() {
//		assertArrayEquals(this.result, FixXY.fixXY(new int[]{}, this.x, this.y));
//	}
	
//	@Test
//	public void singleSecondTest() {
//		assertEquals(new int[]{1, 4, 5, 1, 1, 4, 5}, FixXY.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1}, 4, 5));
//	}

}
