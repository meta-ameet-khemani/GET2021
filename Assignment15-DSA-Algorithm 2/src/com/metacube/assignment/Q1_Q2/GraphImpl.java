package com.metacube.assignment.Q1_Q2;

import java.util.ArrayList;

/**
 * Implementation of Graph
 * @author ameet.khemani_metacu
 */
public class GraphImpl implements Graph {

	// total number of vertices
	private final int numberOfVertices;
	
	// total edges
	private final Edge[] edges;
	
	// list of adjacent nodes
	private AdjacencyList[] adjacencyList;
	
	public GraphImpl(int numberOfVertices, Edge[] edges) {
		this.numberOfVertices = numberOfVertices;
		this.edges = edges;
		this.adjacencyList = new AdjacencyList[this.numberOfVertices];
		for (int index = 0; index < this.numberOfVertices; index++) {
			adjacencyList[index] = new AdjacencyList();
		}
		
		// setting adjacent nodes
		for (Edge edge : this.edges) {
			adjacencyList[edge.vertex1].add(edge.vertex2);
			adjacencyList[edge.vertex2].add(edge.vertex1);
		}
	}

	/**
	 * Checks whether graph is connected or not
	 * @return true if it is connected else false
	 */
	@Override
	public boolean isConnected() {
		
		boolean isConnected = true;
		boolean verticesVisited[] = new boolean[this.numberOfVertices];
		
		for (int index = 0; index < verticesVisited.length; index++) {
			verticesVisited[index] = false;
		}
		
		DFS (0, verticesVisited);
		
		for (int index = 0; index < verticesVisited.length; index++) {
			if (verticesVisited[index] == false) {
				isConnected = false;
				break;
			}
		}
		
		return isConnected;
	}
	
	/**
	 * Used to traverse the graph using depth first search 
	 * @param source
	 * @param verticesVisited
	 */
	private void DFS (int source, boolean verticesVisited[]) {
		
		if (verticesVisited[source] == true) {
			return;
		}
		
		verticesVisited[source] = true;
		
		AdjacencyNode nextNode = this.adjacencyList[source].headVertex;
		
		while (nextNode != null) {
			DFS (nextNode.vertex, verticesVisited);
			nextNode = nextNode.nextVertex;
		}
	}

	/**
	 * Used to find if given vertex is reachable or not
	 * @return array of reachable vertices
	 */
	@Override
	public Integer[] reachable(int source) {
		
		if (source < 0 || source >= this.numberOfVertices) {
			throw new AssertionError("Invalid source vertex");
		}
		
		ArrayList<Integer> reachableVertices = new ArrayList<Integer>();
		AdjacencyNode nextNode = this.adjacencyList[source].headVertex;
		
		while (nextNode != null) {
			reachableVertices.add(nextNode.vertex);
			nextNode = nextNode.nextVertex;
		}
		
		return reachableVertices.toArray(new Integer[reachableVertices.size()]);
		
	}

	/**
	 * Used to find minimum spanning tree
	 * @return an array of Edge
	 */
	@Override
	public Edge[] mst() {
		
		if (!this.isConnected()) {
			return new Edge[0];
		}
		
		int minSpanTree[] = new int[this.numberOfVertices];
		int key[] = new int[this.numberOfVertices];
		Boolean verticesUsed[] = new Boolean[this.numberOfVertices];
		
		for (int index = 0; index < this.numberOfVertices; index++) {
			key[index] = Integer.MAX_VALUE;
			verticesUsed[index] = false;
		}
		
		key[0] = 0;
		
		for (int count = 0; count < this.numberOfVertices - 1; count++) {
			int minVertex = minKey (key, verticesUsed);
			verticesUsed[minVertex] = true;
			
			for (int vertex = 0; vertex < this.numberOfVertices; vertex++) {
				Edge graphUV = null;
				for (Edge edge : this.edges) {
					if ((edge.vertex1 == minVertex && edge.vertex2 == vertex) || edge.vertex1 == vertex && edge.vertex2 == minVertex) {
						graphUV = edge;
						break;
					}
				}
				
				if (graphUV != null && verticesUsed[vertex] == false && graphUV.weight < key[vertex]) {
					minSpanTree[vertex] = minVertex;
					key[vertex] = graphUV.weight;
				}
			}
		}
		
		return getEdgesOfMST (minSpanTree);
	}
	
	/**
	 * Used to find the index of minimum key 
	 * @param key[] array of keys
	 * @param mstSet array of visited set
	 * @return index
	 */
	private int minKey (int key[], Boolean mstSet[]) {
		
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int index = 0; index < this.numberOfVertices; index++) {
			if (mstSet[index] == false && key[index] < min) {
				min = key[index];
				minIndex = index;
			}
		}
		
		return minIndex;
	}
	
	private Edge[] getEdgesOfMST (int minimumSpanningTree[]) {
		
		Edge edgesOfMST[] = new Edge[this.numberOfVertices - 1];
		for (int i = 1; i < this.numberOfVertices; i++) {
			
			Edge graphUV = null;
			for (Edge edge : this.edges) {
				if ((edge.vertex1 == minimumSpanningTree[i] && edge.vertex2 == i) ||
						(edge.vertex2 == minimumSpanningTree[i] && edge.vertex1 == i)) {
					
					graphUV = edge;
					break;
				}
			}
			
			edgesOfMST[i - 1] = new Edge(minimumSpanningTree[i], i, graphUV.weight);
		}
		return edgesOfMST;
	}

	@Override
	public int shortestPath(int source, int destination) {
		
		int distance[] = new int[this.numberOfVertices];
		Boolean processed[] = new Boolean[this.numberOfVertices];
		for (int i = 0; i < this.numberOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
			processed[i] = false;
		}
		
		distance[source] = 0;
		
		for (int count = 0; count < this.numberOfVertices - 1; count++) {
			
			int shortestDistanceNode = minKey(distance, processed);
			processed[shortestDistanceNode] = true;
			AdjacencyNode adjacentEdges = this.adjacencyList[shortestDistanceNode].headVertex;
			
			while (adjacentEdges != null) {
				
				int vertex = adjacentEdges.vertex;
				Edge listEdge = null;
				for (Edge edge : this.edges) {
					if ((edge.vertex1 == shortestDistanceNode && edge.vertex2 == vertex) || edge.vertex1 == vertex && edge.vertex2 == shortestDistanceNode) {
						listEdge = edge;
						break;
					}
				}
				
				if (!processed[vertex] && distance[shortestDistanceNode] + listEdge.weight < distance[vertex]) {
					distance[vertex] = distance[shortestDistanceNode] + listEdge.weight;
				}
				
				adjacentEdges = adjacentEdges.nextVertex;
				
			}
			
		}
		
		return distance[destination];
		
	}

}
