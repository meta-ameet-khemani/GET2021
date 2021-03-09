package com.metacube.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.factory.ShapeFactory;
import com.metacube.model.Point;
import com.metacube.model.Circle;
import com.metacube.utility.Shape;
import com.metacube.utility.ShapeType;

/**
 * Test class for Circle shape
 * @author ameet.khemani_metacu
 */
public class CircleTest {

	/**
	 * Testing triangle area
	 */
	@Test
	public void getAreaTest() {
		
		// create a circle shape with specific point
		Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
		((Circle) circle).setPoint(new Point(1, 1));
		((Circle) circle).setRadius(4);
		((Circle) circle).setOriginDistance();
		
		assertEquals(50.265, circle.getArea(), 0.01);
	}
	
	/*
	 * Testing the perimeter of circle
	 */
	@Test
	public void getPerimeterTest() {
		
		// create a circle shape with specific point
		Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
		((Circle) circle).setPoint(new Point(1, 1));
		((Circle) circle).setRadius(4);
		((Circle) circle).setOriginDistance();

		assertEquals(100.53, circle.getPerimeter(), 0.01);
	}
	
	/**
	 * checking whether point is inside or not (true case)
	 */
	@Test
	public void isPointEnclosedTrueTest() {
		
		// create a circle shape with specific point
		Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
		((Circle) circle).setPoint(new Point(1, 1));
		((Circle) circle).setRadius(4);
		((Circle) circle).setOriginDistance();
		
		assertTrue(circle.isPointEnclosed(new Point(2, 1)));
	}
	
	/**
	 * checking whether point is inside or not (false case)
	 */
	@Test
	public void isPointEnclosedFalseTest() {
		
		// create a circle shape with specific point
		Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
		((Circle) circle).setPoint(new Point(1, 1));
		((Circle) circle).setRadius(4);
		((Circle) circle).setOriginDistance();
		
		assertFalse(circle.isPointEnclosed(new Point(-100, 10)));
	}

}
