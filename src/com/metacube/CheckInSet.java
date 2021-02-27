package com.metacube;

public class CheckInSet {

	public static void main(String[] args) {
		
		InSet insetFirstObject = new InSet(new Integer[]{3, 4, 5});
		InSet insetSecondObject = new InSet(new Integer[]{5, 6, 7});
		
		System.out.println("Is member : " + insetFirstObject.isMember(4));
		System.out.println("Size : " + insetFirstObject.size());
		System.out.println("Size : " + insetFirstObject.isSubSet(insetSecondObject));
		System.out.println("Compliment : " + insetFirstObject.getCompliment());
		System.out.println("Union : " + insetFirstObject.union(insetFirstObject, insetSecondObject));

	}

}
