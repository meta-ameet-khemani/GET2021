package com.metacube.operations;

public class FixXY {

	/**
	 * fixXY solves the problem where each Y is preceded by X
	 * @param array must not be an empty
	 * @param x
	 * @param y
	 * @return an array of fixXY pattern
	 * @exception if array is empty,
	 * 			  if there is unequal number of X and Y
	 * 			  if there is X on last index
	 * 			  if there are 2 adjacent X
	 */
	public static int[] fixXY (int array[], int x, int y) {
		
		int countX = 0;
		int countY = 0;
		int indexOfY = -1;
		boolean isXAfterX = false;
		
		if (array.length < 1) {
			throw new AssertionError("Array is empty");
		}
		
		if (array[array.length - 1] == x) {
			throw new AssertionError("X can not be at last index");
		}
		
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			if (array[arrayIndex] == x)
				countX++;
			if (array[arrayIndex] == y)
				countY++;
			if (arrayIndex < array.length - 1) {
				if (array[arrayIndex] == x && array[arrayIndex + 1] == x)
					isXAfterX = true;
			}
		}
	
		if (countX != countY) {
			throw new AssertionError("X and Y are unequal");
		}
		
		if (isXAfterX) {
			throw new AssertionError("X can not be at adjacent places");
		}
		
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			if (array[arrayIndex] == x && array[arrayIndex] != y) {
				indexOfY = getYIndex(array, x, y);
				int tempVar = array[indexOfY];
				array[indexOfY] = array[arrayIndex + 1];
				array[arrayIndex + 1] = tempVar;
			}
		}
		return array;
		
	}
	
	/**
	 * get the index of Y in array
	 * @param array
	 * @param x
	 * @param y
	 * @return index of Y if present else 0
	 */
	public static int getYIndex (int array[], int x, int y) {
		if (array[0] == y) {
			return 0;
		}
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			if (array[arrayIndex] == y && array[arrayIndex - 1] != x) {
				return arrayIndex;
			}
		}
		return 0;
	}
	
}
