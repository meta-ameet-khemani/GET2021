package com.metacube;

public class CheckInSet {

	public static void main(String[] args) {
		
		InSet insetFirstObject = new InSet(new Integer[]{1, 2, 3, 4, 5});
		InSet.sortSet(insetFirstObject.set);
		InSet insetSecondObject = new InSet(new Integer[]{5, 3, 1});
		insetFirstObject.union(insetFirstObject, insetSecondObject);
		
//		System.out.println("Is member : " + insetFirstObject.isMember(4));
//		System.out.println("Size : " + insetFirstObject.size());
		System.out.println("Subset : " + insetFirstObject.isSubSet(insetSecondObject));
//		System.out.println("Compliment : " + insetFirstObject.getCompliment());
//		System.out.println("Union : " + insetFirstObject.union(insetFirstObject, insetSecondObject));

	}

}
