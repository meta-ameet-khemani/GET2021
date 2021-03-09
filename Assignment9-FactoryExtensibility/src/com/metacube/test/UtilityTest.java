package com.metacube.test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.factory.ShapeFactory;
import com.metacube.model.Point;
import com.metacube.model.Rectangle;
import com.metacube.model.Square;
import com.metacube.utility.Screen;
import com.metacube.utility.Shape;
import com.metacube.utility.ShapeType;

/**
 * Test class for checking functionality for screen
 * like adding, deleting shape and shape type
 * @author ameet.khemani_metacu
 */
public class UtilityTest {

	/**
	 * Positive test case for adding shape
	 */
	@Test
	public void addShapePositiveTest () {
		
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		// creating rectangle shape
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		// adding rectangle to screen
		screen.addShape(rectangle);
	}
	
	/**
	 * Test case for adding shape to screen on passing null
	 */
	@Test(expected = AssertionError.class)
	public void addShapeOnNull () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		screen.addShape(null);
	}
	
	/**
	 * Test case for adding shape whose point is out of screen
	 */
	@Test(expected = AssertionError.class)
	public void addShapeOnPointOutsideScreen () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		// creating rectangle shape with point outside the screen
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(120, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		// adding shape to screen
		screen.addShape(rectangle);
	}
	
	/**
	 * Test case for deleting shape from screen
	 */
	@Test
	public void deleteShape () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		// creating a rectangle shape
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		// adding rectangle to screen
		screen.addShape(rectangle);
		
		// deleting rectangle from screen
		screen.deleteShape(rectangle);
	}
	
	/**
	 * Deleting shape from screen on passing null
	 */
	@Test
	public void deleteShapeOnNull () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		screen.deleteShape(null);
	}
	
	/**
	 * Test case for deleting shape type from screen
	 */
	@Test
	public void deleteShapeType () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		// creating a rectangle shape
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		// adding rectangle to screen
		screen.addShape(rectangle);
		
		// creating another rectangle shape
		Shape rectangle2 = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle2).setOrigin(new Point(1, 1));
		((Rectangle) rectangle2).setLength(4);
		((Rectangle) rectangle2).setBreadth(2);
		((Rectangle) rectangle2).setOriginDistance();
		
		// adding shape to screen
		screen.addShape(rectangle2);
		
		screen.deleteShapeType(ShapeType.RECTANGLE);
	}
	
	/**
	 * Test case for deleting shape type from screen on passing null
	 */
	@Test
	public void deleteShapeTypeOnNull () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		screen.deleteShapeType(null);
	}
	
	/**
	 * Test case for sorting shapes by area
	 */
	@Test
	public void sortByArea () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		// creating a rectangle shape
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		// adding rectangle to screen
		screen.addShape(rectangle);
		
		// creating a square shape
		Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
		((Square) square).setOrigin(new Point(1, 1));
		((Square) square).setSide(4);
		((Square) square).setOriginDistance();
		
		// adding square to screen
		screen.addShape(square);
		
		// getting list of sorted shapes by area
		List<Shape> sortByArea = screen.sortByArea();
		
		assertEquals(sortByArea, Arrays.asList(rectangle, square));
	}
	
	/**
	 * Test case for sorting shapes by area on passing null
	 */
	@Test(expected = AssertionError.class)
	public void sortByAreaOnNull () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		screen.sortByArea();
	}
	
	/**
	 * Test case for sorting screen by origin distance of shapes
	 */
	@Test
	public void sortByOriginDistance () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		// creating a rectangle shape
		Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
		((Rectangle) rectangle).setOrigin(new Point(1, 1));
		((Rectangle) rectangle).setLength(4);
		((Rectangle) rectangle).setBreadth(2);
		((Rectangle) rectangle).setOriginDistance();
		
		// adding shape to screen
		screen.addShape(rectangle);
		
		// creating a square shape
		Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
		((Square) square).setOrigin(new Point(1, 1));
		((Square) square).setSide(4);
		((Square) square).setOriginDistance();
		
		// adding square to screen
		screen.addShape(square);
		
		// getting sorted list of shapes by origin distance
		List<Shape> sortByArea = screen.sortByOriginDistance();
		
		assertEquals(sortByArea, Arrays.asList(rectangle, square));
	}
	
	/**
	 * Test case for sorting screen by area of shapes and passing as null
	 */
	@Test(expected = AssertionError.class)
	public void sortByOriginDistanceOnNull () {
		// creating a virtual screen
		Screen screen = new Screen (100, 100);
		
		// sorting by area on null
		screen.sortByArea();
	}
}
