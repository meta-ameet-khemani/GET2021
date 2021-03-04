package com.metacube.test;

import org.junit.Assert;
import org.junit.Test;

import com.metacube.assignment.linkedList.LinkedList;
import com.metacube.assignment.linkedList.Node;

public class LinkedListTest {

	// used to test the rotating of sublist in linked list
	@Test
	public void testRotateSublist() {
		
		// create a simple linked list
		LinkedList list = new LinkedList(new Integer[] {2, 3, 4, 5, 6, 7});
		
		// rotate it
		list.rotateSublist(2, 5, 2);
		
		// create a new linked list with expected values after shifting of above list
		LinkedList expectedList = new LinkedList(new Integer[] {2, 5, 6, 3, 4, 7});
		
		Node listTraverse = list.head;
		Node expectedListTraverse = expectedList.head;
		
		// traverse through both lists and compare each node
		while (listTraverse != null && expectedListTraverse != null) {
			Assert.assertEquals(listTraverse.data, expectedListTraverse.data);
			listTraverse = listTraverse.next;
			expectedListTraverse = expectedListTraverse.next;
		}
		
		
	}
	
	// used to test if there is any loop inside linked list
	// negative case
	@Test
	public void testLoopInListNegative() {
		LinkedList list = new LinkedList(new Integer[]{2, 3, 4, 5, 6, 7});
		Assert.assertNotEquals(true, list.detectLoop());
	}
	
	// used to test if there is any loop inside linked list
	// positive case
	@Test
	public void testLoopInListPositive() {
		LinkedList list = new LinkedList(new Integer[]{2, 3, 4, 5, 6, 7});
		// pointing last node to first
		Node traverse = list.head;
		while (traverse.next != null) {
			traverse = traverse.next;
		}
		traverse.next = list.head;
		Assert.assertEquals(true, list.detectLoop());
	}
	
}
