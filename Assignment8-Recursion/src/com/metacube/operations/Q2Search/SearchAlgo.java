package com.metacube.operations.Q2Search;

import java.util.Arrays;

/**
 * SearchAlgo class contains different algorithms for searching using recursion
 * @author ameet.khemani_metacu
 *
 */
public class SearchAlgo {

	/***
	 * Searchs value in given array linearly using recursion
	 * @param array
	 * @param value
	 * @return index of item if present else -1
	 */
	public static Integer linearSearch (Integer[] array, Integer value) {
		Integer length = array.length;
		if (array.length == 0) {
			return -1;
		} else if (array[length - 1] == value) {
			return length - 1;
		}
		Integer[] newArray = Arrays.copyOfRange(array, 0, length - 1);
		return linearSearch(newArray, value);
	}
	
	/**
	 * Searchs value in given array through binary search using recursion
	 * @param array
	 * @param value
	 * @return index of item if present else -1
	 * Note:- assuming that given array is sorted
	 */
	public static Integer binarySearch (Integer[] array, Integer value, Integer firstIndex, Integer lastIndex) {
		
		// getting middle index
		Integer mid = firstIndex + (lastIndex - firstIndex) / 2;
		
		if (lastIndex >= firstIndex) {
			if (array[mid] == value) {
				return mid;
			}
			if (array[mid] > value) {
				return binarySearch(array, value, firstIndex, mid - 1);
			} else {
				return binarySearch(array, value, mid + 1, lastIndex);
			}
		}
		return -1;
	}
	
}
