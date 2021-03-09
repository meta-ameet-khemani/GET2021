package com.metacube.utility;

import java.util.Date;

import com.metacube.model.Point;

/**
 * Shape interface to list down all functionalities of Shapes
 * @author ameet.khemani_metacu
 */
public interface Shape {

	double getArea();
	
	double getPerimeter();
	
	Point getOrigin();
	
	boolean isPointEnclosed(Point point);
	
	ShapeType getShapeType();
	
	double getOriginDistance();
	
	Date getTimeStamp();
	
	void setTimeStamp (Date timeStamp);
}
