package com.metacube.test.Q2;

import static org.junit.Assert.*;
import com.metacube.questions.Q2.*;
import org.junit.Test;

/**
 * Test class for checking unique characters
 * @author ameet.khemani_metacu
 *
 */
public class UniqueCharactersTest {

	/**
	 * Test case for counting unique characters
	*/
	@Test
	public void testUniqueChars () {
		assertEquals((Integer)2, UniqueCharacters.checkUnique("asdfas"));
	}
	
	/**
	 * Test case for counting unique characters in empty string
	*/
	@Test(expected = AssertionError.class)
	public void testEmptyString () {
		assertEquals((Integer)2, UniqueCharacters.checkUnique(""));
	}
	
	/**
	 * Test case for counting unique characters on null
	*/
	@Test(expected = AssertionError.class)
	public void testUniqueCharsOnNull () {
		assertEquals((Integer)2, UniqueCharacters.checkUnique(null));
	}

}
