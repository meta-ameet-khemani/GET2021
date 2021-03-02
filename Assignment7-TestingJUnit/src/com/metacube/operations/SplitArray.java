package com.metacube.operations;

public class SplitArray {

	/**
	 * splits array in such way that both sides have same sum of all elements
	 * @param array must be non empty
	 * @return index from where array should be splitted else -1
	 */
	public static int splitArrays(int array[]) {
		
		// throw exception if array is empty
		if (array.length < 1) {
			throw new AssertionError("Array is empty");
		}
		
		int totalSum = 0, sum = 0;
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			totalSum += array[arrayIndex];
		}
		
		// if total sum is not even
		if (totalSum % 2 != 0) {
			return -1;
		}
		
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			sum = 0;
			for (int nestedLoopIndex = 0; nestedLoopIndex <= arrayIndex; nestedLoopIndex++) {
				sum += array[nestedLoopIndex];
			}
			if (sum == (totalSum - sum)) {
				return arrayIndex + 1;
			}
		}
		
		return -1;
	}
	
}
