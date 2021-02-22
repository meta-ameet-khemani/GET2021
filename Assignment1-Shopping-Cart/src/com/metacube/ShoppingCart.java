package com.metacube;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.metacube.model.Cart;
import com.metacube.model.CartItem;
import com.metacube.model.Item;

public class ShoppingCart {
	
	static Cart cart = new Cart();
	static List<Item> itemList = new ArrayList<>();

	public static void main(String[] args) {

		itemList.add(new Item(1, "Belt", 100));
		itemList.add(new Item(2, "Purse", 300));
		itemList.add(new Item(3, "Curtain", 180));
		itemList.add(new Item(4, "Shoes", 500));
		itemList.add(new Item(5, "Shirt", 1000));
		
		Scanner input = new Scanner(System.in);
		int option = 0;
		showOptions();
		do {
			option = input.nextInt();
			if (option == 1) {
				showItemsList(itemList);
				showOptions();
			} else if (option == 2) {
				System.out.println("Enter id of item");
				int itemId = input.nextInt();
				System.out.println("Enter quantity of item");
				int quantity = input.nextInt();
				addItemToCart(itemId, quantity);
				showCart();
				showOptions();
			} else if (option == 3) {
				showCart();
				showOptions();
			} else if (option == 4) {
				editItem();
			} else if (option == 0) {
				System.out.println("Thank you. Visit again");
			} else {
				System.out.println("---------- Invalid option ---------");
				showOptions();
			}
		} while (option != 0);
	}
	
	private static void editItem() {
		Scanner input = new Scanner(System.in);
		// showCart();
		System.out.println("1 to delete the item, 2 to edit the item, 0 to exit");
		int option = input.nextInt();
		if (option == 1) {
			System.out.println("Enter the id of item to delete");
			int itemId = input.nextInt();
			deleteItem(itemId);
		} else if (option == 2) {
			System.out.println("Enter the id of item to edit");
			int itemId = input.nextInt();
			System.out.println("Enter quantity of item");
			int quantity = input.nextInt();
			updateItemInCart(itemId, quantity);
		} else if (option == 0) {
			showOptions();
		} else {
			System.out.println("-------- Invalid Option ---------");
		}
		
		showOptions();
	}
	
//	private static Item getItemById(int itemId) {
//		Item item = null;
//		for (int index = 0; index < itemList.size(); index++) {
//			if (itemList.get(index).getId() == itemId)
//				item = itemList.get(index);
//		}
//		return item;
//	}
	
	private static void updateItemInCart(int itemId, int quantity) {
		int cartItemIndexToUpdate = getIndexOfCartItemByItemId(itemId);
		if (cartItemIndexToUpdate != -1)
			cart.cartItems.get(cartItemIndexToUpdate).setQuantity(quantity);
		showCart();
	}

	private static int getIndexOfItemById(int itemId) {
		int indexOfItem = -1;
		for (int index = 0; index < itemList.size(); index++) {
			if (itemList.get(index).getId() == itemId)
				indexOfItem = index;
		}
		return indexOfItem;
	}
	
	private static int getIndexOfCartItemByItemId(int itemId) {
		int indexOfCartItemToDelete = -1;
		for (int index = 0; index < cart.cartItems.size(); index++) {
			if (cart.cartItems.get(index).getItem().getId() == itemId)
				indexOfCartItemToDelete = index;
		}
		return indexOfCartItemToDelete;
	}
	
	private static void deleteItem(int itemId) {
		int itemIndexToDelete = getIndexOfItemById(itemId);
		if (itemIndexToDelete != -1)
			cart.cartItems.remove(itemIndexToDelete);
		showCart();
	}
	
	private static void showOptions() {
		String listItems = "1 for showing items list";
		String addItemToList = "2 for adding an item to cart";
		String showCart = "3 for show cart";
		String editItemInCart = "4 to edit an item in cart";
		String exitOption = "0 for exit";
		String finalOptions = listItems + "," + addItemToList + "," + showCart + ",";
		finalOptions += cart.cartItems.size() != 0 ? editItemInCart + "," : "";
		finalOptions += exitOption;
		System.out.println(finalOptions);
	}

	private static void showItemsList(List<Item> itemList) {
		System.out.println("Items");
		System.out.println("Id : Item : Price\n------------------------");
		for(Item item : itemList) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getCost());
		}
	}
	
	private static int isItemPresentInCart(int itemId) {
		int itemIndex = -1;
		for(int index = 0; index < cart.cartItems.size(); index++)
			if (cart.cartItems.get(index).getItem().getId() == itemId)
				itemIndex = index;
		return itemIndex;
	}
	
	private static void addItemToCart(int itemId, int quantity) {
		
		int itemIndex = isItemPresentInCart(itemId);
		if (itemIndex != -1) {
			cart.cartItems.get(itemIndex).setQuantity(quantity);
		} else {
			Item newItem = itemList.stream().filter(item -> item.getId() == itemId).findFirst().orElse(new Item(itemIndex, null, itemIndex));
			cart.cartItems.add(new CartItem(newItem, quantity));
		}
		
	}
	
	private static void showCart() {
		System.out.println("Cart");
		System.out.println("Id : Item : Price : Quantity\n------------------------");
		cart.totalPrice = 0d;
		for(CartItem cartItem : cart.cartItems) {
			System.out.println(cartItem.getItem().getId() + " : " + cartItem.getItem().getName() + " : " + cartItem.getItem().getCost() + " : " + cartItem.getQuantity());
			cart.totalPrice += (cartItem.getItem().getCost() * cartItem.getQuantity());
		}
		System.out.println("\nTotal Price : " + cart.getTotalPrice());
	}

}
