package com.metacube.test;

import org.junit.Test;
import com.metacube.factory.ShapeFactory;
import com.metacube.model.Point;
import com.metacube.model.Rectangle;
import com.metacube.utility.Shape;
import com.metacube.utility.ShapeType;
import static org.junit.Assert.*;

/**
 * Test class for rectangle shape
 * @author ameet.khemani_metacu
 */
public class RectangleTest {

	/**
	 * Testing rectangle area
	 */
	@Test
	public void getAreaTest() {
		
		// create a rectangle shape with specific point
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		assertEquals(8.0, rectangle.getArea(), 0.01);
	}
	
	/*
	 * Testing the perimeter of rectangle
	 */
	@Test
	public void getPerimeterTest() {
		
		// create a rectangle shape with specific point
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();

		assertEquals(12.0, rectangle.getPerimeter(), 0.01);
	}
	
	/**
	 * checking whether point is inside or not (true case)
	 */
	@Test
	public void isPointEnclosedTrueTest() {
		
		// create a rectangle shape with specific point
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		assertTrue(rectangle.isPointEnclosed(new Point(2, 1)));
	}
	
	/**
	 * checking whether point is inside or not (false case)
	 */
	@Test
	public void isPointEnclosedFalseTest() {
		
		// create a rectangle shape with specific point
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		assertFalse(rectangle.isPointEnclosed(new Point(-2, 1)));
	}

}
