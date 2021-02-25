package com.metacube.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author ameet.khemani_metacu
 * Cart class represents complete cart information
 */
public class Cart {

	public List<CartItem> cartItems = new ArrayList<>();
	public Double totalPrice = 0d;
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
