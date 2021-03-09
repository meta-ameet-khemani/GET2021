package com.metacube.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.factory.ShapeFactory;
import com.metacube.model.Point;
import com.metacube.model.Triangle;
import com.metacube.utility.Shape;
import com.metacube.utility.ShapeType;

/**
 * Test class for Triangle shape
 * @author ameet.khemani_metacu
 */
public class TriangleTest {

	/**
	 * Testing triangle area
	 */
	@Test
	public void getAreaTest() {
		
		// create a triangle shape with specific point
		Shape triangle = ShapeFactory.getShape(ShapeType.TRIANGLE);
		((Triangle) triangle).setOrigin(new Point(1, 1));
		((Triangle) triangle).setSide1(4);
		((Triangle) triangle).setSide2(3);
		((Triangle) triangle).setSide3(2);
		((Triangle) triangle).setHeight(1);
		((Triangle) triangle).setOriginDistance();
		
		assertEquals(2.904, triangle.getArea(), 0.01);
	}
	
	/*
	 * Testing the perimeter of triangle
	 */
	@Test
	public void getPerimeterTest() {
		
		// create a triangle shape with specific point
		Shape triangle = ShapeFactory.getShape(ShapeType.TRIANGLE);
		((Triangle) triangle).setOrigin(new Point(1, 1));
		((Triangle) triangle).setSide1(4);
		((Triangle) triangle).setSide2(3);
		((Triangle) triangle).setSide3(2);
		((Triangle) triangle).setHeight(1);
		((Triangle) triangle).setOriginDistance();

		assertEquals(9.0, triangle.getPerimeter(), 0.01);
	}
	
	/**
	 * checking whether point is inside or not (true case)
	 */
	@Test
	public void isPointEnclosedTrueTest() {
		
		// create a triangle shape with specific point
		Shape triangle = ShapeFactory.getShape(ShapeType.TRIANGLE);
		((Triangle) triangle).setOrigin(new Point(1, 1));
		((Triangle) triangle).setSide1(4);
		((Triangle) triangle).setSide2(3);
		((Triangle) triangle).setSide3(2);
		((Triangle) triangle).setHeight(1);
		((Triangle) triangle).setOriginDistance();
		
		assertFalse(triangle.isPointEnclosed(new Point(3, 3)));
	}
	
	/**
	 * checking whether point is inside or not (false case)
	 */
	@Test
	public void isPointEnclosedFalseTest() {
		
		// create a triangle shape with specific point
		Shape triangle = ShapeFactory.getShape(ShapeType.TRIANGLE);
		((Triangle) triangle).setOrigin(new Point(1, 1));
		((Triangle) triangle).setSide1(4);
		((Triangle) triangle).setSide2(3);
		((Triangle) triangle).setSide3(2);
		((Triangle) triangle).setHeight(1);
		((Triangle) triangle).setOriginDistance();
		assertFalse(triangle.isPointEnclosed(new Point(-5, 0)));
	}

}
