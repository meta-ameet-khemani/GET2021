package com.metacube.training;

public class HexadecimalCalculator {

	public static void main(String[] args) {

		System.out.println(HexadecimalArithmeticOperations.hexadecimalToDecimal("AB"));
		System.out.println(HexadecimalArithmeticOperations.decimalToHexadecimal(HexadecimalArithmeticOperations.hexadecimalToDecimal("AB")));
		System.out.println(HexadecimalArithmeticOperations.hexadecimalToDecimal(HexadecimalArithmeticOperations.add("AB", "10")));
		System.out.println(HexadecimalComparisonOperations.areEqual("-1", "tr"));
		System.out.println(HexadecimalComparisonOperations.firstLessThanSecond("av", "a"));
		
		System.out.println(HexadecimalArithmeticOperations.isValidHexadecimalNumber("12"));
		System.out.println(HexadecimalComparisonOperations.compareHexadecimals("a", "a"));
	}

}
