package com.metacube.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.assignment.cricket.MatchStrategy;

/**
 * test class for strategy testing
 * @author ameet.khemani_metacu
 *
 */
public class MatchStrategyTest {

	// finding order of balls to be bowled by baller
	@Test
	public void findOrderOfBowlersTest () throws Exception {
		assertArrayEquals(new int[] {1, 1, 2, 1, 2}, MatchStrategy.findOrderOfBowlers(5, 2, new int[] {3, 2}));
		assertArrayEquals(new int[] {2, 2, 1, 2, 3}, MatchStrategy.findOrderOfBowlers(5, 3, new int[] {1, 3, 1}));
		assertArrayEquals(new int[] {2, 2, 1, 2, 1, 2, 3}, MatchStrategy.findOrderOfBowlers(7, 3, new int[] {2, 4, 1}));
		assertArrayEquals(new int[] {1, 3, 1, 2, 3, 1, 2, 3, 4}, MatchStrategy.findOrderOfBowlers(9, 4, new int[] {3, 2, 3, 1}));
		assertArrayEquals(new int[] {2, 2, 3, 7, 1, 2, 3, 4, 5, 6, 7}, MatchStrategy.findOrderOfBowlers(11, 7, new int[] {1, 3, 2, 1, 1, 1, 2}));
		assertArrayEquals(new int[] {2, 1, 2, 1, 2}, MatchStrategy.findOrderOfBowlers(5, 2, new int[] {2, 3}));
		assertArrayEquals(new int[] {1, 1, 3, 1, 3, 1, 2, 3}, MatchStrategy.findOrderOfBowlers(8, 3, new int[] {4, 1, 3}));
	}

}
