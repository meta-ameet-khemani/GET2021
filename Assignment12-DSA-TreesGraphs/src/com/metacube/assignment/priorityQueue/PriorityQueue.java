package com.metacube.assignment.priorityQueue;

/**
 * Queue interface for listing all features of queue
 * @author ameet.khemani_metacu
 *
 */
public interface PriorityQueue {
	
	public void enqueue (Integer data, Integer priority);
	
	public Integer dequeue ();
	
	public Integer peek ();
	
	public boolean isEmpty ();
	
	public boolean isFull ();
}
