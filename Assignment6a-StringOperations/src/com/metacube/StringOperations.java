package com.metacube;

/**
 * Some string operations
 * @author ameet.khemani_metacu
 *
 */
public class StringOperations {

	public static void main(String[] args) {

		System.out.println("Equal : " + areEquals("zxcv" , "asdf"));
		System.out.println("Length : " + getLength("we"));
		System.out.println("Reverse : " + getReverse("string"));
		System.out.println("Flipped characters case : " + flipCharsCase("AbCdr"));
		System.out.println("Largest word : " + largestWord("this is ameet khemani hello and welcome"));
		
	}
	
	/**
	 * checks whether given character is alphabet or not
	 * @param ch
	 * @return true if it is alphabet else false
	 */
	public static boolean isValidAlphabet(char ch) {
		if (ch >= 65 && ch <= 90 || ch >=97 && ch <= 122) {
			return true;
		}
		return false;
	}
	
	/**
	 * gives the largest word from the sentence
	 * @param sentence
	 * @return the largest word
	 */
	public static String largestWord(String sentence) {
		int largestWordLength = 0;
		int sentenceLength = getLength(sentence);
		int sentenceIndex = 0;
		String largestWord = "";
		while (sentenceIndex < sentenceLength) {
			char charAtIndex = sentence.charAt(sentenceIndex);
			boolean isInside = false;
			int tempLargestWordLength = 0;
			String tempLargestWord = "";
			while (sentenceIndex < sentenceLength && isValidAlphabet(charAtIndex)) {
				charAtIndex = sentence.charAt(sentenceIndex);
				if (isValidAlphabet(charAtIndex)) {
					tempLargestWord += (char)charAtIndex;
					tempLargestWordLength++;
				}
				sentenceIndex++;
				isInside = true;
			}
			if (!isInside)
				sentenceIndex++;
			if (tempLargestWordLength >= largestWordLength) {
				largestWordLength = tempLargestWordLength;
				largestWord = tempLargestWord;
			}
		}
		return largestWord;
	}
	
	/**
	 * used to flip the characters from upper to lower case and vice versa
	 * @param string
	 * @return fliped string
	 */
	public static String flipCharsCase(String string) {
		int length = getLength(string);
		int stringIndex = 0;
		String flippedString = "";
		while (stringIndex < length) {
			boolean lowerCase = string.charAt(stringIndex) > 97 && string.charAt(stringIndex) < 123;
			boolean upperCase = string.charAt(stringIndex) > 64 && string.charAt(stringIndex) < 91;
			if (lowerCase) {
				flippedString += (char)(string.charAt(stringIndex) - 32);
			} else if (upperCase) {
				flippedString += (char)(string.charAt(stringIndex) + 32);
			}
			stringIndex++;
		}
		return flippedString;
	}
	
	/**
	 * used to get the reversed string
	 * @param string 
	 * @return reversed string of given string
	 */
	public static String getReverse(String string) {
		String reversedString = "";
		int length = getLength(string);
		length--;
		while (length > -1) {
			reversedString += string.charAt(length);
			length--;
		}
		return reversedString;
	}
	
	/**
	 * used to get the length of string
	 * @param string
	 * @return length of given inputed string
	 */
	public static int getLength(String string) {
		int length = 0;
		if (string == null) {
			return 0;
		} else {
			try {
				do {
					string.charAt(length);
					length++;
				} while (length > 0);
			} catch (StringIndexOutOfBoundsException exception) {
			}
		}
		return length;
	}
	
	/**
	 * checks whether 2 strings are equal or not
	 * @param firstString
	 * @param secondString
	 * @return 1 if equal else 0
	 */
	public static int areEquals(String firstString, String secondString) {
		if (getLength(firstString) != getLength(secondString)) {
			return 0;
		} else {
			int length = getLength(firstString);
			int startingIndex = 0;
			while (startingIndex < length) {
				if (firstString.charAt(startingIndex) != secondString.charAt(startingIndex))
					return 0;
				startingIndex++;
			}
			return 1;
		}
	}

}
