package com.metacube.assignment.Q1_Q2;

/**
 * Interface for graph
 * @author ameet.khemani_metacu
 *
 */
public interface Graph {

	public boolean isConnected ();
	
	public Integer[] reachable (int source);
	
	public Edge[] mst ();
	
	public int shortestPath (int source, int destination);
	
}
