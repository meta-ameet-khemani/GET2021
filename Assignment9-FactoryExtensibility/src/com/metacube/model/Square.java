package com.metacube.model;

import java.util.Date;

import com.metacube.utility.ShapeType;
import com.metacube.utility.Shape;

/**
 * Square class represents a Square shape
 * @author ameet.khemani_metacu
 */
public class Square implements Shape {
	
	// time of creation of shape
	private Date timeStamp;
	
	// origin point
	private Point origin;
	
	// side of square
	private double side;
	
	// distance from origin
	private double originDistance;
	
	public Square () {
		
	}

	/**
	 * Used to calculate the area of square
	 * @return area in double
	*/
	@Override
	public double getArea () {
		return this.side * this.side;
	}

	/**
	 * Used to calculate the perimeter of square
	 * @return perimeter in double
	*/
	@Override
	public double getPerimeter () {
		return 4 * this.side;
	}

	@Override
	public Point getOrigin () {
		return this.origin;
	}

	/**
	 * Used to check whether point lies inside square or not
	 * @return boolean true if point lies inside else false
	*/
	@Override
	public boolean isPointEnclosed (Point point) {
		return point.getX() >= this.origin.getX() && point.getX() <= this.side + this.origin.getX() &&
			   point.getY() >= this.origin.getY() && point.getX() <= this.side + this.origin.getX();
	}
	
	/**
	 * Used to calculate the distance from origin
	 * @return distance in double
	*/
	private double calculateOriginDistance () {
		return Math.sqrt(Math.pow(this.origin.getX(), 2) + Math.pow(this.origin.getY(), 2));
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
	}

	@Override
	public double getOriginDistance () {
		return this.originDistance;
	}

	public double getSide () {
		return side;
	}

	public void setSide (double side) {
		this.side = side;
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
