package com.metacube.model;

import java.util.Date;

import com.metacube.utility.ShapeType;
import com.metacube.utility.Shape;

/**
 * Triangle class represents a Triangle shape
 * @author ameet.khemani_metacu
 */
public class Triangle implements Shape {

	// origin point
	private Point origin;
	
	// side 1
	private double side1;
	
	// side 2
	private double side2;
	
	// side 3
	private double side3;
	
	// distance from origin
	private double originDistance;
	
	// height of triangle
	private double height;
	
	// time of creation
	private Date timeStamp;
	
	public Triangle () {
		
	}
	
	/**
	 * Used to calculate the area of triangle
	 * @return area in double
	*/
	@Override
	public double getArea () {
		double semiPerimeter = getPerimeter () / 2;
		return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
	}

	/**
	 * Used to calculate the perimeter of triangle
	 * @return perimeter in double
	*/
	@Override
	public double getPerimeter () {
		return (this.side1 + this.side2 + this.side3);
	}

	@Override
	public Point getOrigin () {
		return this.origin;
	}

	/**
	 * Used to check whether point lies inside triangle or not
	 * @return boolean true if point lies inside else false
	*/
	@Override
	public boolean isPointEnclosed (Point point) {
		boolean isEnclosed = false;
		double base = Math.sqrt (Math.pow (this.side3, 2) - Math.pow (this.height, 2));
		Point b = new Point (this.origin.getX () + this.side1, this.origin.getY ());
		Point c = new Point (this.origin.getX () + base, this.origin.getY () + this.height);
		
		if (Math.abs (getArea () - ((getAreaByVertices (point, this.origin, b)) + getAreaByVertices (point, b, c) 
				+ getAreaByVertices (point, this.origin, c))) <= 0.001) {
			isEnclosed = true;
		}
		return isEnclosed;
	}
	
	/**
	 * Calculate area of triangle by its vertices
	 * @param a vertex one as Point
	 * @param b vertex two as Point
	 * @param c vertex three as Point
	 * @return area in double
	 */
	private double getAreaByVertices (Point a, Point b, Point c) {
		return Math.abs((a.getX () * (b.getY () - c.getY ()) + b.getX () * (c.getY () - a.getY ()) + c.getX () * (a.getY () - b.getY ())) / 2.0);
	}
	
	/**
	 * Used to calculate the distance from origin
	 * @return distance in double
	*/
	private double calculateOriginDistance () {
		return Math.sqrt(Math.pow(this.origin.getX(), 2) + Math.pow(this.origin.getY(), 2));
	}

	@Override
	public ShapeType getShapeType () {
		return ShapeType.TRIANGLE;
	}

	@Override
	public double getOriginDistance () {
		return this.originDistance;
	}

	public double getSide1 () {
		return side1;
	}

	public void setSide1 (double side1) {
		this.side1 = side1;
	}

	public double getSide2 () {
		return side2;
	}

	public void setSide2 (double side2) {
		this.side2 = side2;
	}

	public double getSide3 () {
		return side3;
	}

	public void setSide3 (double side3) {
		this.side3 = side3;
	}

	public double getHeight () {
		return height;
	}

	public void setHeight (double height) {
		this.height = height;
	}

	public void setOrigin (Point origin) {
		this.origin = origin;
	}

	public void setOriginDistance () {
		this.originDistance = calculateOriginDistance ();
	}

	@Override
	public Date getTimeStamp () {
		return this.timeStamp;
	}
	
	@Override
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
