package com.metacube.assignment.dictionary;

import java.util.List;

/**
 * Dictionary interface lists down all features of implementing dictionary using BST
 * @author ameet.khemani_metacu
 *
 */
public interface Dictionary {

	public boolean add (String key, String value) throws Exception;
	
	public boolean delete (String key) throws Exception;
	
	public String getValue (String key);
	
	public List<Value> getAll ();
	
	public List<Value> getBetween (String key1, String key2);
	
}
