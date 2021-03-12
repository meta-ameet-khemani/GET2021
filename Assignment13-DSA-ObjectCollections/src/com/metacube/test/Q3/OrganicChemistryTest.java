package com.metacube.test.Q3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.questions.Q3.OrganicChemistry;

/**
 * Test class for testing organic chemistry
 * @author ameet.khemani_metacu
 */
public class OrganicChemistryTest {

	/**
	 * Positive test case of calculating mass
	 */
	@Test
	public void calculateMassPositiveTest () {
		assertEquals((Integer)29, OrganicChemistry.calculateMass("C(OH)"));
	}
	
	/**
	 * Negative test case of calculating mass
	 */
	@Test
	public void calculateMassNegativeTest () {
		assertNotEquals((Integer)2, OrganicChemistry.calculateMass("C(OH)"));
	}

}
