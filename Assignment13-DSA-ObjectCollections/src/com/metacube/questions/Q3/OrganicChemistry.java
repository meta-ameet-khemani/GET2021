package com.metacube.questions.Q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Organic chemistry class is used to calculate the mass of formula 
 * @author ameet.khemani_metacu
 */
public class OrganicChemistry {

	// Map to store elements in formula
	public static Map<Character, Integer> elements = new HashMap<>();
	
	/**
	 * used to calculate the mass of formula
	 * @param formula whose mass will be calculated
	 * @return mass in Integer
	 */
	public static Integer calculateMass (String formula) {
		
		// checking if formula is null
		if (formula == null) {
			throw new AssertionError("Formula can't be null");
		}
		
		// checking if formula is empty
		if (formula.length() == 0) {
			throw new AssertionError("Formula can't be empty");
		}
		
		// adding weight to elements
		elements.put('C', 12);
		elements.put('O', 16);
		elements.put('H', 1);
		
		// creating stack for brackets
		Stack<Character> bracket = new Stack<Character>();
		
		// creating stack for operands
		Stack<Integer> operands = new Stack<Integer>();
		
		// converting to array
		char charArr[] = formula.toCharArray();
		int sum = 0;
		int operand1, operand2;
		
		// iterate through all elements
		for (char ch : charArr) {
			
			// if there is already an operand
			if (elements.containsKey(ch)) {
				operands.add(elements.get(ch));
			} else if (ch == '(') {
				
				// if that's an opening bracket
				bracket.add(ch);
			} else if (ch == ')') {
				
				// getting first operand
				operand1 = operands.pop();
				
				// getting second operand
				operand2 = operands.pop();
				sum = operand1 + operand2;
				operands.add(sum);
				bracket.pop();
			} else {
				
				// getting the index of character
				Integer index = Integer.parseInt(String.valueOf(ch));
				operand1 = operands.pop();
				operands.add(operand1 * index);
			}
		}
		
		// iterate through all remaining operands
		while (operands.size() > 1) {
			Integer op1 = operands.pop();
			Integer op2 = operands.pop();
			operands.add(op1 + op2);
		}
		return operands.pop();
		
	}
	
}
