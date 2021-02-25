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
	
}
