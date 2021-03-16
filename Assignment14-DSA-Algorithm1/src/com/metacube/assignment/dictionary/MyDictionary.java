package com.metacube.assignment.dictionary;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/**
 * MyDictionary class is the implementation of Dictionary interface
 * @author ameet.khemani_metacu
 *
 */
public class MyDictionary implements Dictionary {

	// root node of tree
	Node head;
	
	public MyDictionary() {
	}
	
	/**
	 * Initialize the root node with json values
	 * @param jsonObject a set of json values from file
	 */
	public MyDictionary(JSONObject jsonObject) {
		this.head = null;
		input (jsonObject);
	}
	
	/**
	 * Used to read the
	 * @param jsonObject
	 * @return
	 */
	private boolean input (JSONObject jsonObject) {
		for (Object object : jsonObject.keySet()) {
			String key = (String)object;
			String value = (String)jsonObject.get(key);
			this.add(key, value);
		}
		return true;
	}
	
	/**
	 * Used to add node to the tree
	 * @param key of node
	 * @param value of node
	 */
	@Override
	public boolean add(String key, String value) {
		
		// checking null 
		if (key == null || value == null || key.length() == 0 || value.length() == 0) {
			throw new AssertionError("Invalid key and value");
		}
		
		// if it is the root node
		if (this.head == null) {
			this.head = new Node(key, value);
		} else {
			
			// pass key and value to add node
			addRec (key, value, this.head);
		}
		return false;
	}
	
	/**
	 * Used to add node recursively to the tree
	 * @param key of new node
	 * @param value of new node
	 * @param node root node
	 * @return true if added succesfully else false
	 */
	private boolean addRec (String key, String value, Node node) {
		
		// if value is less than parent
		if (key.compareTo(node.getKey()) <= -1) {
			if (node.getLeft() != null) {
				addRec(key, value, node.getLeft());
			} else {
				node.setLeft(new Node(key, value));
				node.getLeft().setParent(node);
			}
		// if value is greater than parent
		} else if (key.compareTo(node.getKey()) >= 1) {
			if (node.getRight() != null) {
				addRec(key, value, node.getRight());
			} else {
				node.setRight(new Node(key, value));
				node.getRight().setParent(node);
			}
		} else {
			node = new Node (key, value);
		}
		return true;
	}

	/**
	 * Used to delete the node from tree
	 * @param key of node to delete
	 * @return true if successfully deleted else false
	 */
	@Override
	public boolean delete(String key) throws Exception {
		
		// check null condition
		if (key.length() == 0 || key == null) {
			throw new AssertionError("Invalid key and value");
		}
		
		// pass key to delete node
		if (this.head != null) {
			return deleteRec (key, this.head);
		}
		return false;
	}
	
	/**
	 * Used to find the node and delete it
	 * @param key of node to delete
	 * @param node root node
	 * @return true is successfully deleted else false
	 */
	private boolean deleteRec (String key, Node node) {
		
		// find node on right side
		if (key.compareTo(node.getKey()) <= -1) {
			if (node.getLeft() != null) {
				return deleteRec(key, node.getLeft());
			}
		// find node on left side
		} else if (key.compareTo(node.getKey()) >= 1) {
			if (node.getRight() != null) {
				return deleteRec(key, node.getRight());
			}
		// if current node is to be deleted
		} else if (key.compareTo(node.getKey()) == 0) {
			if (node.getLeft() == null) {
				if (node.getRight() == null) {
					if (node.getParent().getLeft() == node) {
						node.getParent().setLeft(null);
					} else {
						node.getParent().setRight(null);
					}
				}
			} else if (node.getLeft() == null && node.getRight() != null) {
				if (node.getParent().getLeft() == node) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
			} else if (node.getRight() == null && node.getLeft() != null) {
				if (node.getParent().getRight() == node) {
					node.getParent().setRight(node.getLeft());
				} else {
					node.getParent().setLeft(node.getLeft());
				}
			} else {
				Node newNode = findMin (node.getRight());
				node.setKey(newNode.getKey());
				node.setValue(newNode.getValue());
				return deleteRec(newNode.getKey(), newNode);
			}
		}
		return true;
	}
	
	/**
	 * Used to find minimum valued node of the tree
	 * @param currentNode
	 * @return minimum valued node
	 */
	private Node findMin (Node currentNode) {
		while (currentNode.getLeft() != null) {
			currentNode = currentNode.getLeft();
		}
		return currentNode;
	}
	
	/**
	 * Get value of subtree in inorder
	 * @param root parent node
	 * @param list of child nodes
	 * @return List of nodes
	 */
	private List<Value> inorderRec (Node root, List<Value> list) {
		if (root != null) {
			inorderRec(root.left, list);
			list.add(new Value(root.getKey(), root.getValue()));
			inorderRec(root.right, list);
		}
		return list;
	}

	/**
	 * Used to get value of node
	 * @param key of the node to get value
	 * @return value in string
	 */
	@Override
	public String getValue(String key) {
		if (this.head != null) {
			return getValueRec (key, this.head);
		}
		return null;
	}
	
	/**
	 * Used to get the value of node
	 * @param key
	 * @param node
	 * @return value in String
	 */
	private String getValueRec (String key, Node node) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.getKey()) == 0) {
			return node.getValue();
		} else if (key.compareTo(node.getKey()) <= -1) {
			return getValueRec(key, node.getLeft());
		} else if (key.compareTo(node.getKey()) >= 1) {
			return getValueRec(key, node.getRight());
		} else {
			return null;
		}
	}

	/**
	 * Used to get all nodes
	 * @return List of all nodes
	 */
	@Override
	public List<Value> getAll() {
		List<Value> valueList = new ArrayList<Value>();
		if (this.head != null) {
			valueList = inorderRec(this.head, valueList);
		}
		return valueList;
	}

	/**
	 * Used to get the in between values of nodes
	 * @param key1 as node1
	 * @param key2 as node2
	 * @return List of values between key1 and key2
	 */
	@Override
	public List<Value> getBetween(String key1, String key2) {
		List<Value> list = getAll ();
		List<Value> finalList = new ArrayList<>();
		for (Value v : list) {
			if (v.getKey().compareTo(key1) >= 1 && v.getKey().compareTo(key2) <= -1) {
				finalList.add(v);
			}
		}
		return finalList;
	}
	
}
