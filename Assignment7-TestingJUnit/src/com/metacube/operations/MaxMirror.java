package com.metacube.operations;

public class MaxMirror {
	
	/**
	 * used to find the largest number of mirrored elements in an array
	 * @param array must not be an empty
	 * @return length of largest mirror elements
	 */
	public static int maxMirror(int array[]) {
		if (array.length < 1) {
			throw new AssertionError("Array is empty");
		}
		int length = array.length;
		int count = 0, max = 0;
		for (int arrayIndex = 0; arrayIndex < length; arrayIndex++) {
			
			// setting count to 0 for fresh start
			count = 0;
			
			// iterate from the last element to first for comparing
			for (int reverseCounter = length - 1; reverseCounter > -1 && arrayIndex + count < length; reverseCounter--) {
				
				// element from right side is equals to element from left side
				if (array[arrayIndex + count] == array[reverseCounter]) {
					count++;
				} else {
					
					// if there are some same elements from right and left side
					if (count > 0) {
						max = Math.max(count, max);
						count = 0;
					}
				}
			}
			max = Math.max(count, max);
		}
		return max;
	}
	
}
