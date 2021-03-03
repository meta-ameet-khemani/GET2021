package com.metacube.operations;

public class CountClump {

	/**
	 * Count the total number of clumps in an array
	 * @param array must not be an empty array
	 * @return number of clumps
	 */
	public static int countClumps(int array[]) {
		
		if (array.length < 1) {
			throw new AssertionError("Array is empty");
		}
		
		int length = array.length;
		int clumpsCount = 0;
		
		for (int arrayIndex = 0; arrayIndex < length - 1; arrayIndex++) {
			
			boolean isClumpFound = false;
			
			while (arrayIndex < length - 1 && array[arrayIndex] == array[arrayIndex + 1]) {
				
				isClumpFound = true;
				arrayIndex++;
			}
			
			if (isClumpFound)
				clumpsCount++;
			
		}
		return clumpsCount;
	}
	
}
