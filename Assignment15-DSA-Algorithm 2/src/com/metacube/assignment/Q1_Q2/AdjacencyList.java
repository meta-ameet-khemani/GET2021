package com.metacube.assignment.Q1_Q2;

/**
 * AdjacencyList class represents a list of Adjacent vertices
 * @author ameet.khemani_metacu
 */
public class AdjacencyList {
	
	// head/starting vertex
	public AdjacencyNode headVertex;
	
	// last/ending vertex
	public AdjacencyNode lastVertex;
	
	public AdjacencyList () {
		this.headVertex = null;
	}
	
	public void add (int vertex) {
		AdjacencyNode adjacencyNode = new AdjacencyNode(vertex);
		adjacencyNode.nextVertex = null;
		if (this.headVertex == null) {
			this.headVertex = adjacencyNode;
			this.lastVertex = adjacencyNode;
		} else {
			this.lastVertex.nextVertex = adjacencyNode;
			this.lastVertex = adjacencyNode;
		}
	}
	
}
