package com.metacube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class InSet implements Set {
	
	private final int UPPER_LIMIT = 1000;
	private final int LOWER_LIMIT = 1;
	public final Integer[] set;
	
	public InSet(Integer[] set) {
		this.set = set;
	}
	
	/**
	 * creates a new set from passed array values
	 * @param input as values to be set
	 * @return an array of Inset values
	 */
	private Integer[] createNewSet(int[] input) {
		List<Integer> list = new ArrayList<>();
		Integer set[];
		for (int loopCounter = 0; loopCounter < input.length; loopCounter++) {
			if (input[loopCounter] >= LOWER_LIMIT && input[loopCounter] <= UPPER_LIMIT) {
				if (!list.contains(input[loopCounter])) {
					list.add(input[loopCounter]);
				}
			}
		}
		set = new Integer[list.size()];
		return list.toArray(set);
	}

	/**
	 * check whether the passed value is member of set or not
	 * @param value to be checked in set
	 * @return true if present else false
	 */
	@Override
	public boolean isMember(int value) {
		if (value < LOWER_LIMIT || value > UPPER_LIMIT) {
			return false;
		}
		for (int loopCounter = 0; loopCounter < this.set.length; loopCounter++) {
			if (value == set[loopCounter]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * get the size of set
	 * @return size of set
	 */
	@Override
	public int size() {
		return this.set.length;
	}

	/**
	 * checks whether the passed set in subset or not
	 * @param subSet to be checked in set
	 * @return true if subset else false
	 */
	@Override
	public boolean isSubSet(InSet subSet) {
		List<Integer> original = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> newSubSet = new ArrayList<Integer>(Arrays.asList(subSet.set));
		if (original.containsAll(newSubSet)) {
			return true;
		}
		return false;
	}

	/**
	 * gives the compliment out of 1 - 1000 range
	 * @return gives Inset object as compliment
	 */
	@Override
	public InSet getCompliment() {
		List<Integer> setList = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> complimentList = new ArrayList<>();
		Integer newSet[];
		for (int loopCounter = LOWER_LIMIT; loopCounter <= UPPER_LIMIT; loopCounter++) {
			if (!setList.contains(loopCounter)) {
				complimentList.add(loopCounter);
			}
		}
		Object tempObjectArray[] = complimentList.toArray();
		newSet = Arrays.copyOf(tempObjectArray, tempObjectArray.length, Integer[].class);
		return new InSet(newSet);
	}

	/**
	 * gives union of 2 passed sets
	 * @param firstSet as set 1
	 * @param secondSet as set 2
	 * @return single Inset object as union of passed sets
	 */
	@Override
	public InSet union(InSet firstSet, InSet secondSet) {
		List<Integer> firstSetList = new ArrayList<Integer>(Arrays.asList(firstSet.set));
		List<Integer> secondSetList = new ArrayList<Integer>(Arrays.asList(secondSet.set));
		List<Integer> unionSetList = new ArrayList<>();
		unionSetList.addAll(firstSetList);
		for (int loopCounter = 0; loopCounter < secondSet.size(); loopCounter++) {
			if (!unionSetList.contains(secondSetList.get(loopCounter))) {
				unionSetList.add(secondSetList.get(loopCounter));
			}
		}
		Object tempObjectArray[] = unionSetList.toArray();
		Integer tempIntegerArr[] = Arrays.copyOf(tempObjectArray, tempObjectArray.length, Integer[].class);
		return new InSet(tempIntegerArr);
	}

	@Override
	public String toString() {
		return "InSet : " + Arrays.toString(set);
	}
	
}
