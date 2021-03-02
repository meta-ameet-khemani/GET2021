package com.metacube;

/**
 * Area class represents areas of different shapes
 * @author ameet.khemani_metacu
 *
 */
public class Area {
	
	/**
	 * calculates area of triangle
	 * @param base (assuming) is positive value
	 * @param height (assuming) is positive value
	 * @return area of triangle
	 */
	public double getTriangleArea(double base, double height) {
		return (base * height) / 2;
	}
	
	/**
	 * Calculates area circle
	 * @param radius (assuming) is positive value
	 * @return area of circle
	 */
	public double getCircleArea(double radius) {
		return 3.14 * (radius * radius);
	}
	
	/**
	 * Calculates area of rectangle
	 * @param length (assuming) is positive value
	 * @param breadth (assuming) is positive value
	 * @return area of rectangle
	 */
	public double getRectangleArea(double length, double breadth) {
		return length * breadth;
	}
	
	/**
	 * Calculates area of Square
	 * @param side (assuming) is positive value
	 * @return area of Square
	 */
	public double getSquareArea(double side) {
		return side * side;
	}
	
}
