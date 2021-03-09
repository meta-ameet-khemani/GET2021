package com.metacube.model;

import java.util.Date;

import com.metacube.utility.ShapeType;
import com.metacube.utility.Shape;

/**
 * Rectangle class represents a Rectangle shape
 * @author ameet.khemani_metacu
 */
public class Rectangle implements Shape {

	// time of creation of shape
	private Date timeStamp;
	
	// orign point
	private Point origin;
	
	// length of rectangle
	private double length;
	
	// breadth of rectangle
	private double breadth;
	
	// distance from origin
	private double originDistance;
	
	public Rectangle () {
		
	}
	
	public Point getPoint () {
		return this.origin;
	}

	@Override
	public double getArea() {
		return this.length * this.breadth;
	}

	@Override
	public double getPerimeter() {
		return 2 * (this.length + this.breadth);
	}

	@Override
	public Point getOrigin() {
		return this.origin;
	}

	/**
	 * Used to check whether point lies inside rectangle or not
	 * @return boolean true if point lies inside else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		return point.getX() >= this.origin.getX() && point.getX() <= this.length + this.origin.getX() &&
							   point.getY() >= this.origin.getY() && point.getY() <= this.breadth + this.origin.getY();
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
		return ShapeType.RECTANGLE;
	}

	@Override
	public double getOriginDistance() {
		return this.originDistance;
	}

	@Override
	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public void setOriginDistance() {
		this.originDistance = calculateOriginDistance();
	}
	
	@Override
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
