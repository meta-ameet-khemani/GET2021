package com.metacube.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<CartItem> cartItems = new ArrayList<>();
	Double totalPrice = 0d;
	
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
