package com.metacube.Q1Stack;

/**
 * Node class represents a single node in stack
 * @author ameet.khemani_metacu
 *
 * @param <T>
 */
public class Node<T> {
	
	T data;
	Node<T> next;
	
	public Node (T data) {
		this.data = data;
		this.next = null;
	}
	
}
