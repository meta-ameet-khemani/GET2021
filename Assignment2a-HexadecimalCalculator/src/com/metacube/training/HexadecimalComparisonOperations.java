package com.metacube.training;

/**
 * 
 * @author ameet.khemani_metacu
 * HexadecimalComparisonOperations class has hexadecimal comparison methods
 */
public class HexadecimalComparisonOperations {
	
	/**
	 * used to check whether two hexadecimal string are equal or not
	 * @param firstHexadecimalNumber as first hexadecimal string
	 * @param secondHexadecimalNumber as second hexadecimal string
	 * @return true if are equal else false
	 */
	public static boolean areEqual(String firstHexadecimalNumber, String secondHexadecimalNumber) {
		firstHexadecimalNumber = firstHexadecimalNumber.toUpperCase();
		secondHexadecimalNumber = secondHexadecimalNumber.toUpperCase();
		if (HexadecimalArithmeticOperations.isValidHexadecimalNumber(firstHexadecimalNumber) &&
			HexadecimalArithmeticOperations.isValidHexadecimalNumber(secondHexadecimalNumber) &&
			firstHexadecimalNumber.length() == secondHexadecimalNumber.length()) {
				boolean areEqual = true;
				int hexadecimalNumberIndex = 0;
				while (hexadecimalNumberIndex < firstHexadecimalNumber.length()) {
					if (firstHexadecimalNumber.charAt(hexadecimalNumberIndex) != secondHexadecimalNumber.charAt(hexadecimalNumberIndex)) {
						areEqual = false;
						break;
					}
					hexadecimalNumberIndex++;
				}
				return areEqual;
		} else { 
			return false;
		}
	}
	
	/**
	 * used to check whether first hexadecimal number is greater than or not
	 * @param firstHexadecimalNumber  as first hexadecimal string
	 * @param secondHexadecimalNumber as second hexadecimal string
	 * @return true if first string is greater than else false
	 */
	public static boolean firstGreaterThanSecond(String firstHexadecimalNumber, String secondHexadecimalNumber) {
		
		if (HexadecimalArithmeticOperations.isValidHexadecimalNumber(firstHexadecimalNumber) &&
			HexadecimalArithmeticOperations.isValidHexadecimalNumber(secondHexadecimalNumber) &&
			firstHexadecimalNumber.length() > secondHexadecimalNumber.length()) {
				boolean isFirstNumberGreaterThanSecond = true;
				int hexadecimalNumberIndex = 0;
				while (hexadecimalNumberIndex < firstHexadecimalNumber.length() &&
					   hexadecimalNumberIndex < secondHexadecimalNumber.length()) {
					if (firstHexadecimalNumber.charAt(hexadecimalNumberIndex) - secondHexadecimalNumber.charAt(hexadecimalNumberIndex) < 0) {
						isFirstNumberGreaterThanSecond = false;
						break;
					}
					hexadecimalNumberIndex++;
				}
				return isFirstNumberGreaterThanSecond;
		} else { 
			return false;
		}
	}
	
	/**
	 * used to check whether first hexadecimal number is less than or not
	 * @param firstHexadecimalNumber  as first hexadecimal string
	 * @param secondHexadecimalNumber as second hexadecimal string
	 * @return true if first string is less than else false
	 */
	public static boolean firstLessThanSecond(String firstHexadecimalNumber, String secondHexadecimalNumber) {
		if (HexadecimalArithmeticOperations.isValidHexadecimalNumber(firstHexadecimalNumber) &&
			HexadecimalArithmeticOperations.isValidHexadecimalNumber(secondHexadecimalNumber) &&
			firstHexadecimalNumber.length() < secondHexadecimalNumber.length()) {
				boolean isFirstNumberLessThanSecond = true;
				int hexadecimalNumberIndex = 0;
				while (hexadecimalNumberIndex < firstHexadecimalNumber.length() &&
					   hexadecimalNumberIndex < secondHexadecimalNumber.length()) {
					if (secondHexadecimalNumber.charAt(hexadecimalNumberIndex) - firstHexadecimalNumber.charAt(hexadecimalNumberIndex) < 0) {
						isFirstNumberLessThanSecond = false;
						break;
					}
					hexadecimalNumberIndex++;
				}
				return isFirstNumberLessThanSecond;
		} else { 
			return false;
		}
	}
	
	/**
	 * compares two given hexadecimal string
	 * @param firstHexadecimalNumber
	 * @param secondHexadecimalNumber
	 * @return 0 if equal, 1 if firstHexadecimal is greater, -1 if secondHexadecimal is greater, -2 if given string is invalid
	 */
	public static int compareHexadecimals(String firstHexadecimalNumber, String secondHexadecimalNumber) {
		int result = -1;
		int hexadecimalNumberIndex = 0;
		
		// checking whether the given string is valid hexadecimal string 
		if (HexadecimalArithmeticOperations.isValidHexadecimalNumber(firstHexadecimalNumber) &&
			HexadecimalArithmeticOperations.isValidHexadecimalNumber(secondHexadecimalNumber)) {
		
			// checking if both given strings have equal lengths
			if (firstHexadecimalNumber.length() == secondHexadecimalNumber.length()) {
				
				boolean areBothEqual = true;
				// they both are of same length, now check their content
				while (hexadecimalNumberIndex < firstHexadecimalNumber.length()) {
					if (firstHexadecimalNumber.charAt(hexadecimalNumberIndex) != secondHexadecimalNumber.charAt(hexadecimalNumberIndex)) {
						result = -1;
						areBothEqual = false;
						break;
					}
					hexadecimalNumberIndex++;
				}
				if (areBothEqual) {
					result = 0;
				} else {
					// assuming first is greater
					result = 1;
					boolean isFirstGreater = true;
					hexadecimalNumberIndex = 0;
					while (hexadecimalNumberIndex < firstHexadecimalNumber.length() && hexadecimalNumberIndex < secondHexadecimalNumber.length()) {
						if (firstHexadecimalNumber.charAt(hexadecimalNumberIndex) - secondHexadecimalNumber.charAt(hexadecimalNumberIndex) < 0) {
							isFirstGreater = false;
							result = -1;
							break;
						}
						hexadecimalNumberIndex++;
					}
					if (isFirstGreater) {
						result = 1;
					}
				}
			} else if (firstHexadecimalNumber.length() > secondHexadecimalNumber.length()) {
				result = 1;
			} else if (firstHexadecimalNumber.length() < secondHexadecimalNumber.length()) {
				result = -1;
			}
			return result;
		} else { 
			return -2;
		}
	}
	
}
