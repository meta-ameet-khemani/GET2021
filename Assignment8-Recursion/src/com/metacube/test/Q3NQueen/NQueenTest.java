package com.metacube.test.Q3NQueen;

import static org.junit.Assert.*; 
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.metacube.operations.Q3NQueen.NQueen;

@RunWith(Parameterized.class)
public class NQueenTest {

	public int size;
	public int[][] expected;
	
	public NQueenTest (int size, int[][] expected) {
		this.size = size;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testValues() {
		return Arrays.asList(new Object[][]{
			{3, new int[][]{						// checking for 3*3 matrix
					{0, 0, 0}, 
					{0, 0, 0}, 
					{0, 0, 0}}
			},
			{4, new int[][]{						// checking for 4*4 matrix
					{0, 0, 1, 0}, 
					{1, 0, 0, 0},
					{0, 0, 0, 1},
					{0, 1, 0, 0}}
			},
			{5, new int[][]{						// checking for 5*5 matrix
					{1, 0, 0, 0, 0}, 
					{0, 0, 0, 1, 0}, 
					{0, 1, 0, 0, 0},
					{0, 0, 0, 0, 1},
					{0, 0, 1, 0, 0}}
			}
		});
	}
	
	/**
	 * Testing with multiple sizes
	 */
	@Test
	public void multipleParametersTest() {
		assertArrayEquals(this.expected, NQueen.getNQueenSolution(this.size));
	}

}
