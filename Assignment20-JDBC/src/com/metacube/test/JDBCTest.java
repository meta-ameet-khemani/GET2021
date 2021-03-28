package com.metacube.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.metacube.assignment.StoreFront;

/**
 * JDBCTest is used to test the JDBC class functionality
 * @author ameet.khemani_metacu
 */
public class JDBCTest {

	/**
	 * Tests getOrders of JDBC class
	 */
	@Test
	public void getOrders() {
		StoreFront sf = new StoreFront();
		assertEquals(1, sf.getOrders(1));
	}
	
	/**
	 * Tests adding images to products
	 */
	@Test
	public void addImages() {
		StoreFront sf = new StoreFront();
		List<String> imageList = new ArrayList<String>();
		imageList.add("shirt1.jpg");
		imageList.add("shirt2.jpg");
		imageList.add("shirt3.jpg");
		imageList.add("shirt4.jpg");
		assertEquals(4, sf.addImage(1, imageList));
	}

}
