package com.metacube;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
		try {
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
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Invalid input");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		input.close();
	}

	/**
	 * used to delete or change the quantity of item
	 */
	private static void editItem() {
		Scanner input = new Scanner(System.in);
		// showCart();
		System.out.println("1 to delete the item, 2 to edit the item, 0 to exit");
		try {
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
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Invalid input");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
	
//	private static Item getItemById(int itemId) {
//		Item item = null;
//		for (int index = 0; index < itemList.size(); index++) {
//			if (itemList.get(index).getId() == itemId)
//				item = itemList.get(index);
//		}
//		return item;
//	}
	
	/**
	 * used to update the item in cart
	 * @param itemId as id of item in cart
	 * @param quantity as quantity of item to be set in cart
	 */
	private static void updateItemInCart(int itemId, int quantity) {
		int cartItemIndexToUpdate = getIndexOfCartItemByItemId(itemId);
		if (cartItemIndexToUpdate == -1) {
			System.out.println("Invalid item id ...");	
		} else {
			cart.cartItems.get(cartItemIndexToUpdate).setQuantity(quantity);
		}
		showCart();
	}

	/**
	 * used to get the id of item
	 * @param itemId
	 * @return id of item as int if present else -1
	 */
	private static int getIndexOfItemById(int itemId) {
		int indexOfItem = -1;
		for (int index = 0; index < itemList.size(); index++) {
			if (itemList.get(index).getId() == itemId)
				indexOfItem = index;
		}
		return indexOfItem;
	}
	
	/**
	 * used to get the index value of item in cart 
	 * @param itemId as id of item
	 * @returns index of item if present else -1
	 */
	private static int getIndexOfCartItemByItemId(int itemId) {
		int indexOfCartItemToDelete = -1;
		for (int index = 0; index < cart.cartItems.size(); index++) {
			if (cart.cartItems.get(index).getItem().getId() == itemId)
				indexOfCartItemToDelete = index;
		}
		return indexOfCartItemToDelete;
	}
	
	/**
	 * used to delete the item
	 * @param itemId
	 */
	private static void deleteItem(int itemId) {
		int itemIndexToDelete = getIndexOfCartItemByItemId(itemId);
		if (itemIndexToDelete == -1) {
			System.out.println("Invalid item id ...");
		} else {
			cart.cartItems.remove(itemIndexToDelete);	
		}
		showCart();
	}
	
	/**
	 * shows all current present options in this program
	 */
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

	/**
	 * show the list of all available items
	 * @param itemList
	 */
	private static void showItemsList(List<Item> itemList) {
		if (itemList.size() == 0) {
			System.out.println("No Items");
		} else {
			System.out.println("Items");
			System.out.println("Id : Item : Price\n------------------------");
			for(Item item : itemList) {
				System.out.println(item.getId() + " : " + item.getName() + " : " + item.getCost());
			}	
		}
	}
	
	/**
	 * used to check if item is present or not in cart
	 * @param itemId as id of item
	 * @return index of item if present else -1
	 */
	private static int isItemPresentInCart(int itemId) {
		int itemIndex = -1;
		for(int index = 0; index < cart.cartItems.size(); index++)
			if (cart.cartItems.get(index).getItem().getId() == itemId)
				itemIndex = index;
		return itemIndex;
	}
	
	/**
	 * used to add item to the cart
	 * @param itemId 
	 * @param quantity
	 */
	private static void addItemToCart(int itemId, int quantity) {
		
		int itemIndex = getIndexOfItemById(itemId);
		if (itemIndex == -1) {
			System.out.println("Invalid item id ...");
		} else if (quantity <= 0) {
			System.out.println("Invalid quantity ...");
		} else {
			int alreadyPresentCartItemIndex = isItemPresentInCart(itemId);
			if (alreadyPresentCartItemIndex == -1) {
				Item newItem = itemList.stream().filter(item -> item.getId() == itemId).findFirst().orElse(new Item(itemIndex, null, itemIndex));
				cart.cartItems.add(new CartItem(newItem, quantity));
			} else {
				int previousQuantity = cart.cartItems.get(alreadyPresentCartItemIndex).getQuantity();
				cart.cartItems.get(alreadyPresentCartItemIndex).setQuantity(previousQuantity + quantity);
			}
		}	
	}
	
	/**
	 * shows all items in cart
	 */
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
