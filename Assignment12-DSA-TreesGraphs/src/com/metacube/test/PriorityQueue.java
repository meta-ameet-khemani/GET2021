package com.metacube.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.assignment.priorityQueue.Queue;
import com.metacube.assignment.priorityQueue.Task;

/**
 * Test class for testing functionality of queue
 * @author ameet.khemani_metacu
 *
 */
public class PriorityQueue {

	// test case for adding an element to queue
	@Test
	public void testEnqueue() {
		Queue queue = new Queue(5);
		queue.enqueue(1, 2);
		queue.enqueue(1, 3);
		queue.enqueue(1, 4);
		queue.enqueue(1, 6);
		Task tasks[] = queue.getTasks();
		Integer array[] = new Integer[]{6, 4, 3, 2};
		for (int loop = 0; loop < 4; loop++) {
			assertEquals(array[loop], tasks[loop].priority);
		}
	}
	
	// test case for removing an element from queue
	@Test
	public void testDequeue() {
		Queue queue = new Queue(5);
		queue.enqueue(1, 2);
		queue.enqueue(2, 3);
		queue.enqueue(3, 4);
		assertEquals((Integer)3, queue.dequeue());
	}

}
