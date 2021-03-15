package com.metacube.assignment.cricket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Strategy class for match
 * @author ameet.khemani_metacu
 *
 */
public class MatchStrategy {
	
	/**
	 * Used to get the order of balls bowled by which bowler
	 * @param numberOfBalls total number of balls left in match
	 * @param numberOfBowlers total number of bowlers left
	 * @param ballsForEachBowler balls per each bowler
	 * @return array of order of bowlers should be bowled
	 */
	public static int[] findOrderOfBowlers (int numberOfBalls, int numberOfBowlers, int ballsForEachBowler[]) {
		int arrangedOrderOfBowlers[] = new int[numberOfBalls];
		
		// check for balls to bowler data
		if (numberOfBowlers != ballsForEachBowler.length) {
			throw new AssertionError ("bowls allocation per bowler is incorrect");
		}
		
		int sum = 0;
		for (int ball : ballsForEachBowler) {
			sum += ball;
		}
		
		// checking for total number of balls
		if (sum != numberOfBalls) {
			throw new AssertionError ("Number of balls and its sum is not equal");
		}
		
		// creating a map which for bowler and its number of balls ratio
		Map<Integer, Integer> ballsPerBowler = new HashMap<Integer, Integer>();
		int key = 0;
		for (int i = 0; i < numberOfBowlers; i++) {
			ballsPerBowler.put(++key, ballsForEachBowler[i]);
		}
		
		int i = 0;
		
		// iterate through all balls
		while (numberOfBalls != 0) {
			
			// get maximum number of balls per bowler remaining
			int maxBalls = Collections.max(ballsPerBowler.values());
			for (Map.Entry<Integer, Integer> entry : ballsPerBowler.entrySet()) {
				
				// if a bowler has left max balls
				if (entry.getValue() == maxBalls) {
					int bowlerIndex = entry.getKey();
					
					// set the order
					arrangedOrderOfBowlers[i++] = bowlerIndex;
					
					// decrease remaining balls
					ballsPerBowler.put(bowlerIndex, --maxBalls);
					numberOfBalls--;
					break;
				}
			}
		}
		return arrangedOrderOfBowlers;
	}
	
}
