package com.metacube.assignment.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * LinkedList class represents custom linked list
 * @author ameet.khemani_metacu
 *
 */
public class LinkedList {

	// starting node treated as HEAD
	public Node head = null;
	
	/**
	 * Constructor accepting Integer array
	 * @param dataList
	 */
	public LinkedList(Integer[] dataList) {
		// iterating through complete list
		for (int loopCounter = 0; loopCounter < dataList.length; loopCounter++) {
			
			// if addition of node to list fails, throw exception
			if (!addElement (dataList[loopCounter])) {
				throw new AssertionError("Node addition fails ...");
			}
		}
	}
	
	/**
	 * Used to add node to LinkedList
	 * @param data of type Integer
	 * @return true on successful addition, else false
	 */
	public boolean addElement (Integer data) {
		
		// data is null, return false
		if (data == null) {
			return false;
		}
		
		// create a new node
		Node node = new Node(data);
		
		// if HEAD is empty, add node to it and return true
		if (this.head == null) {
			head = node;
			return true;
		}
		// if there are already some nodes present
		else {
			Node lastNode = head;
			
			// iterate to the last node
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			
			// add newnode to the end of the list
			lastNode.next = node;
		}
		return true;
	}
	
	/**
	 * Prints complete linked list
	 */
	public void showList () {
		// reference to the head of list
		Node currentNode = head;
		
		System.out.print("list : ");
		
		// iterate through list and print its data
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	/**
	 * Used to count the number of nodes in list
	 * @param start as head of List
	 * @return count of nodes as Integer
	 */
	public Integer countNodes (Node start) {
		// reference to the head of list
		Node currentNode = start;
		
		Integer count = 0;
		
		// iterate through list and increase counter
		while (currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}
		return count;
	}
	
	/**
	 * Used to rotate the sub list inside Linked list
	 * @param left index from where sublist should be started
	 * @param right index to the end of sublist
	 * @param n as how many places a node to be shifted
	 */
	public void rotateSublist (Integer left, Integer right, Integer n) {
		// get count of total nodes in list
		Integer totalElements = countNodes(this.head);
		
		// check for invalid parameters
		if (left < 1 || right > totalElements) {
			throw new AssertionError("invalid options");
		}
		
		Integer count = 1;
		Node traverse = this.head;
		Node leftNode = null;
		Node rightNode = null;
		
		// traverse to the end of list
		while (traverse != null) {
			
			// if counter reaches to the starting index of sublist
			if (count == left) {
				
				// left node address
				leftNode = traverse;
			}
			
			// if counter reaches to the end of sublist
			if (count == right) {
				
				// right node address
				rightNode = traverse;
			}
			
			count++;
			traverse = traverse.next;
		}
		
		// shifts nodes upto n numbers
		rotate(leftNode, rightNode, n);
	}
	
	/**
	 * Rotates the linked list upto numbers
	 * @param left from where sublist is starting
	 * @param right end index of sublist
	 * @param n number of shifts each node has to make
	 */
	public void rotate (Node left, Node right, Integer n) {
		
		// iterate upto n times
		while (n > 0) {
			
			// starting point of list
			Node traverse = left;
			
			Integer currentNodeData = traverse.data;
			
			Node nextNode = null;
			
			// traverse to the end index of sublist
			while (traverse != right) {
				
				// move to next node
				nextNode = traverse.next;
				
				// get the next node data
				Integer nextNodeData = nextNode.data;
				
				// save previous node data to next one
				nextNode.data = currentNodeData;
				
				// next node to current one
				currentNodeData = nextNodeData;
				
				// move to next node
				traverse = traverse.next;
			}
			
			left.data = currentNodeData;
			n--;
		}
	}
	
	/**
	 * Used to check, if there is any loop inside linked list
	 * @return true if loop present else false
	 */
	public boolean detectLoop () {
		
		// create a temporary list to contain nodes of list
		List<Node> list = new ArrayList<>();
		
		// start from head of list
		Node traverse = this.head;
		
		// traverse to the end of list
		while (traverse != null) {
			
			// check if list contains nodes
			if (list.contains(traverse))
				return true;
			
			list.add (traverse);
			traverse = traverse.next;
		}
		return false;
	}

	public static void main (String args[]) {
		
		LinkedList list = new LinkedList(new Integer[]{2, 3, 4, 5, 6, 7});
		list.showList();
		list.rotateSublist(1, 6, 2);
		list.showList();
		
		System.out.println("Loop inside list : " + list.detectLoop());
		
		// pointing last node to first
		Node traverse = list.head;
		while (traverse.next != null) {
			traverse = traverse.next;
		}
		traverse.next = list.head;
		
		System.out.println("Loop inside list : " + list.detectLoop());
	}
	
}
