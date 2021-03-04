package com.metacube.assignment.linkedList;

/**
 * Node class represents a single Node in linked list
 * @author ameet.khemani_metacu
 *
 */
public class Node {

	// data of node
	public Integer data;
	
	// next address of node
	public Node next;
	
	public Node (Integer data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}
