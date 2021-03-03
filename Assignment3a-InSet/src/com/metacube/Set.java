package com.metacube;

/**
 * @author ameet.khemani_metacu
 * list down all features of Set
 */
public interface Set {
	
	public boolean isMember(int value);
	
	public int size();
	
	public boolean isSubSet(InSet subSet);
	
	public InSet getCompliment();
	
	public InSet union(InSet firstSet, InSet secondSet);
	
}
