package com.metacube.factory;

import com.metacube.model.Circle;
import com.metacube.model.Rectangle;
import com.metacube.model.Square;
import com.metacube.model.Triangle;
import com.metacube.utility.ShapeType;
import com.metacube.utility.Shape;

/**
 * Shape factory is an example of Factory method which always creates a single object
 * and always returns the same object
 * @author ameet.khemani_metacu
 *
 */
public class ShapeFactory {
	
	/**
	 * Used to get the object of type any Shape
	 * @param shapeType of type ShapeType
	 * @return same object of type ShapeType
	 */
	public static Shape getShape (ShapeType shapeType) {
	
		Shape shape = null;
		switch (shapeType) {
			
			case CIRCLE:
				shape = new Circle();
				break;
				
			case RECTANGLE:
				shape = new Rectangle();
				break;
				
			case SQUARE:
				shape = new Square();
				break;
				
			case TRIANGLE:
				shape = new Triangle();
				break;
				
			default:
				System.out.println("Invalid shape type");
				System.exit(0);
		}
		
		return shape;
		
	}
	
}
