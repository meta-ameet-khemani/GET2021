package com.metacube.assignment.model;

/**
 * Order class represents a Order in store front
 * @author ameet.khemani_metacu
 */
public class Order {

	// id of order
	int id;
	
	// total amount of order
	int amount;
	
	// date on whihc order is placed
	String date;
	
	public Order(int id, int amount, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", date=" + date
				+ "]";
	}
}
