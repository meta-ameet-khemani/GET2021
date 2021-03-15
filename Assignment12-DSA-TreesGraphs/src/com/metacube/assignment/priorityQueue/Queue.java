package com.metacube.assignment.priorityQueue;

/**
 * Implementation of queue
 * @author ameet.khemani_metacu
 *
 */
public class Queue implements PriorityQueue {

	public Task tasks[];
	public Integer capacity;
	public Integer size;
	
	public Queue (Integer capacity) {
		this.capacity = capacity;
		tasks = new Task[this.capacity];
		this.size = 0;
	}
	
	public Task[] getTasks () {
		return this.tasks;
	}
	
	@Override
	public boolean isEmpty () {
		return this.size == 0;
	}
	
	/**
	 * Adding an element to queue
	 * @param data to be added to queue
	 * @param priority of task
	 */
	@Override
	public void enqueue(Integer data, Integer priority) {
		// if queue is already full
		if (isFull()) {
			throw new AssertionError("Queue is full");
		}
		
		// creating a new task
		Task newJob = new Task(data, priority);
		
		boolean flag = false;
		
		// iterating through all items
		for (Integer loop = 0; loop < this.size; loop++) {
			
			// if passed task has higher priority than previous ones
			if (this.tasks[loop].priority < priority) {
				int move = size;
				
				// shift the task
				while (loop <= move) {
					this.tasks[move + 1] = this.tasks[move];
					move--;
				}
				tasks[loop] = newJob;
				size++;
				flag = true;
				break;
			}
		}
		
		// adding a new job to job array
		if (!flag) {
			tasks[size++] = newJob;
		}
	}

	/**
	 * Removing an element from queue
	 */
	@Override
	public Integer dequeue() {
		
		// checking if queue is empty or not
		if (isEmpty()) {
			throw new AssertionError("Queue is empty");
		}
		
		// removing element
		Integer data = tasks[0].job;
		
		// rearranging order of tasks
		for (Integer loop = 1; loop < size; loop++) {
			tasks[loop - 1] = tasks[loop];
			size--;
		}
		return data;
	}

	/**
	 * Get peek (topmost) element of tasks array
	 */
	@Override
	public Integer peek() {
		
		// checking if queue is already empty
		if (isEmpty()) {
			throw new AssertionError("Queue is empty");
		}
		
		// get that element
		Integer data = tasks[0].job;
		return data;
	}

	/**
	 * Checking if queue is empty or not
	 */
	@Override
	public boolean isFull() {
		return this.size == this.capacity;
	}

}
