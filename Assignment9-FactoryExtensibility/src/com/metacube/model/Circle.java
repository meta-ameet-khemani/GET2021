package com.metacube.model;

import java.util.Date;

import com.metacube.utility.ShapeType;
import com.metacube.utility.Shape;

/**
 * Circle class represents Circle shape
 * @author ameet.khemani_metacu
 *
 */
public class Circle implements Shape {
	
	// point of starting
	private Point point;
	
	// length of radius
	private double radius;
	
	// time of creation of shape
	private Date timeStamp;
	
	// distance of origin
	private double originDistance;
	
	public Circle() {
		
	}

	/**
	 * Used to get the are of circle
	 * @return are in double
	 */
	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	/**
	 * Used to get the perimeter of circle
	 * @return perimeter in double
	 */
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius * this.radius;
	}

	/**
	 * Used to get the origin of circle
	 * @return coordinates as Point object
	 */
	@Override
	public Point getOrigin() {
		double distance = Math.sqrt((this.point.getX() * this.point.getX()) + (this.point.getY() * this.point.getY()));
		return new Point ((distance - this.radius) * this.point.getX()/ ((distance - this.radius) + this.radius),
						  (distance - this.radius) * this.point.getY()/ ((distance - this.radius) + this.radius));
	}

	/**
	 * Used to check whether the passed point lies inside circle or not
	 * @return true if lies inside else false
	 */
	@Override
	public boolean isPointEnclosed (Point point) {
		double distance = Math.sqrt(Math.abs(point.getX() - this.point.getX()) * Math.abs(point.getX() - this.point.getX())) + 
						  Math.sqrt(Math.abs(point.getY() - this.point.getY()) * Math.abs(point.getY() - this.point.getY()));
		return distance < radius;
	}
	
	/**
	 * Used to calculate the distance from origin
	 * @return distance in double
	 */
	private double calculateOriginDistance () {
		return Math.sqrt(Math.pow(getOrigin().getX(), 2) + Math.pow(getOrigin().getY(), 2));
	}

	@Override
	public ShapeType getShapeType () {
		return ShapeType.CIRCLE;
	}
	
	public void setPoint (Point point) {
		this.point = point;
	}
	
	public double getRadius () {
		return this.radius;
	}
	
	public void setRadius (double radius) {
		this.radius = radius;
	}

	@Override
	public double getOriginDistance () {
		return this.originDistance;
	}

	@Override
	public Date getTimeStamp() {
		return this.timeStamp;
	}
	
	public void setOriginDistance () {
		this.originDistance = calculateOriginDistance ();
	}

	@Override
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
