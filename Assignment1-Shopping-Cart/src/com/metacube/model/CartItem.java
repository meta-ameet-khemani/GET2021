package com.metacube.model;
/**
 * 
 * @author ameet.khemani_metacu
 * Cartitem class represent a single item in cart
 */
public class CartItem {

	Item item;
	int quantity;
	
	public CartItem(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
