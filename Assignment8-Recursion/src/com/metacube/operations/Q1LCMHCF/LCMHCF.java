package com.metacube.operations.Q1LCMHCF;

/**
 * LCMHCF class calculates LCM, HCF and GCD
 * @author ameet.khemani_metacu
 *
 */
public class LCMHCF {
	
	/**
	 * calculate GCD of given numbers
	 * @param num1
	 * @param num2
	 * @return GCD of num1 and num2
	 * NOTE:- assuming both numbers are positive
	 */
	public static Integer calculateGCD(Integer num1, Integer num2) {
		if (num1 == 0)
			return num2;
		return calculateGCD(num2 % num1, num1);
	}
	
	/**
	 * calculate LCM of given numbers
	 * @param num1
	 * @param num2
	 * @return LCM of num1 and num2
	 * NOTE:- assuming both numbers are positive
	 */
	public static Integer calculateLCM(Integer num1, Integer num2) {
		return ((num1 / calculateGCD(num1, num2)) * num2);
	}
	
	/**
	 * calculate HCF of given numbers
	 * @param num1
	 * @param num2
	 * @return HCF of num1 and num2
	 * NOTE:- assuming both numbers are positive
	 */
	public static Integer calculateHCF(Integer num1, Integer num2) {
		if (num1 == 0)
			return num2;
		if (num2 == 0)
			return num1;
		if (num1 > num2) {
			return calculateHCF(num1 % num2, num2);
		} else {
			return calculateHCF(num2 % num1, num1);
		}
	}
	
}
