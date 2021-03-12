package com.metacube.questions.Q2;

import java.util.HashMap;
import java.util.Map;

/**
 * UniqueCharacters class used to get the number of unique characters in string
 * @author ameet.khemani_metacu
 *
 */
public class UniqueCharacters {

	// Map to store cache of repeated strings
	private static Map<String, Integer> cache = new HashMap<String, Integer>();
	
	/**
	 * count the number of unique characters
	 * @param str in which characters are to be counted
	 * @return number of unique characters of type Integer
	 */
	public static Integer checkUnique (String str) {
		
		// check if string is empty or null 
		if (str == null || str.length() == 0) {
			throw new AssertionError("String can't be null");
		}

		// checking if string is in cache or not
		if (!cache.containsKey(str)) {
			
			// creating a map for character and its count of presence
			HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
			
			// creating an array of characters
			char strArray[] = str.toCharArray();
			
			// iterate through all characters
			for (char c : strArray) {
				if (!(c == ' ')) {
					if (charCountMap.containsKey(c)) {
						charCountMap.put(c, charCountMap.get(c)+1);
					} else {
						charCountMap.put(c, 1);
					}
				}
			}
			
			Integer uniqueCharacters = 0;
			
			// iterate through array
			for (char c : strArray) {
				if (!(c == ' ')) {
					if (charCountMap.get(c) == 1) {
						uniqueCharacters++;
					}
				}
			}
			cache.put(str, uniqueCharacters);
		}
		return cache.get(str);
	}
	
}
