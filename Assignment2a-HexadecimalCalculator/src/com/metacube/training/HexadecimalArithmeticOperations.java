package com.metacube.training;

/**
 * 
 * @author ameet.khemani_metacu
 * HexadecimalArithmeticOperations class has hexadecimal arithmetic operations
 */
public class HexadecimalArithmeticOperations {

	/*
	 * all hexadecimal numbers possible
	 */
	private final static String ALL_HEXADECIMAL_DIGITS = "0123456789ABCDEF";
	
	/**
	 * checks whether entered string is valid hexadecimal number or not
	 * @param hexadecimalNumber
	 * @return true if it is valid string else false
	 */
	public static boolean isValidHexadecimalNumber(String hexadecimalNumber) {
		hexadecimalNumber = hexadecimalNumber.toUpperCase();
		boolean isValid = true;
		int hexadecimalNumberIndex = 0;
		while(hexadecimalNumberIndex < hexadecimalNumber.length()) {
			if (ALL_HEXADECIMAL_DIGITS.indexOf((hexadecimalNumber.charAt(hexadecimalNumberIndex))) < 0) {
				isValid = false;
				break;
			}
			hexadecimalNumberIndex++;
		}
		return isValid;
	}
	
	/**
	 * calculates power of a number upto given exponent
	 * @param number of which power is to be calculated
	 * @param power 
	 * @return calculated power of number
	 */
	private static int getPower(int number, int power) {
		if (number == 0)
			return 1;
		else {
			int poweredNumber = 1;
			while (power != 0) {
				poweredNumber *= number;
				power--;
			}
			return poweredNumber;
		}
	}
	
	/**
	 * converts a hexadecimal string to decimal
	 * @param hexadecimalNumber as string
	 * @return decimal value of hexadecimal string
	 */
	public static int hexadecimalToDecimal(String hexadecimalNumber) {
		hexadecimalNumber = hexadecimalNumber.toUpperCase();
		int decimalNumber = 0, power = 0;
		for (int hexadecimalNumberIndex = hexadecimalNumber.length() - 1; hexadecimalNumberIndex > -1; hexadecimalNumberIndex--) {
			char hexadecimalChar = hexadecimalNumber.charAt(hexadecimalNumberIndex);
			decimalNumber += ALL_HEXADECIMAL_DIGITS.indexOf(hexadecimalChar) * getPower(16, power);
			power++;
		}
		return decimalNumber;
	}
	
	/**
	 * converts decimal to hexadecimal string
	 * @param decimalNumber
	 * @return hexadecimal as string
	 */
	public static String decimalToHexadecimal(int decimalNumber) {
		String hexadecimalNumber = "";
		while (decimalNumber != 0) {
			int remainder = decimalNumber % 16;
			hexadecimalNumber = ALL_HEXADECIMAL_DIGITS.charAt(remainder) + hexadecimalNumber;
			decimalNumber /= 16;
		}
		return hexadecimalNumber;
	}
	
	/**
	 * used to add 2 hexadecimal strings
	 * @param firstNumber as first hexadecimal string
	 * @param secondNumber as second hexadecimal string
	 * @return added string of 2 inputs
	 */
	public static String add(String firstNumber, String secondNumber) {
		return decimalToHexadecimal(hexadecimalToDecimal(firstNumber) + hexadecimalToDecimal(secondNumber));
	}
	
	/**
	 * used to subtract 2 hexadecimal strings
	 * @param firstNumber as first hexadecimal string
	 * @param secondNumber as second hexadecimal string
	 * @return subtracted string of 2 inputs
	 */
	public static String subtract(String firstNumber, String secondNumber) {
		return decimalToHexadecimal(hexadecimalToDecimal(firstNumber) - hexadecimalToDecimal(secondNumber));
	}
	
	/**
	 * used to multiply 2 hexadecimal strings
	 * @param firstNumber as first hexadecimal string
	 * @param secondNumber as second hexadecimal string
	 * @return multiplied string of 2 inputs
	 */
	public static String multiply(String firstNumber, String secondNumber) {
		return decimalToHexadecimal(hexadecimalToDecimal(firstNumber) * hexadecimalToDecimal(secondNumber));
	}
	
	/**
	 * used to divide 2 hexadecimal strings
	 * @param firstNumber as first hexadecimal string
	 * @param secondNumber as second hexadecimal string
	 * @return divided string of 2 inputs
	 */
	public static String divide(String firstNumber, String secondNumber) {
		return decimalToHexadecimal(hexadecimalToDecimal(firstNumber) / hexadecimalToDecimal(secondNumber));
	}
	
}
