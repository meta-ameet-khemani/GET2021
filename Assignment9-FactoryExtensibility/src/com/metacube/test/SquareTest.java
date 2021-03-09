package com.metacube.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.factory.ShapeFactory;
import com.metacube.model.Point;
import com.metacube.model.Square;
import com.metacube.utility.Shape;
import com.metacube.utility.ShapeType;

/**
 * Test class for Square shape
 * @author ameet.khemani_metacu
 */
public class SquareTest {

	/**
	 * Testing square area
	 */
	@Test
	public void getAreaTest() {
		
		// create a square shape with specific point
		Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
		((Square) square).setOrigin(new Point(1, 1));
		((Square) square).setSide(4);
		((Square) square).setOriginDistance();
		
		assertEquals(16.0, square.getArea(), 0.01);
	}
	
	/*
	 * Testing the perimeter of square
	 */
	@Test
	public void getPerimeterTest() {
		
		// create a square shape with specific point
		Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
		((Square) square).setOrigin(new Point(1, 1));
		((Square) square).setSide(4);
		((Square) square).setOriginDistance();

		assertEquals(16.0, square.getPerimeter(), 0.01);
	}
	
	/**
	 * checking whether point is inside or not (true case)
	 */
	@Test
	public void isPointEnclosedTrueTest() {
		
		// create a square shape with specific point
		Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
		((Square) square).setOrigin(new Point(1, 1));
		((Square) square).setSide(4);
		((Square) square).setOriginDistance();
		
		assertTrue(square.isPointEnclosed(new Point(2, 1)));
	}
	
	/**
	 * checking whether point is inside or not (false case)
	 */
	@Test
	public void isPointEnclosedFalseTest() {
		
		// create a square shape with specific point
		Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
		((Square) square).setOrigin(new Point(1, 1));
		((Square) square).setSide(4);
		((Square) square).setOriginDistance();
		
		assertFalse(square.isPointEnclosed(new Point(-2, 1)));
	}

}
