package com.metacube.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metacube.model.Point;

/**
 * Screen class represents a virtual screen
 * @author ameet.khemani_metacu
 */
public class Screen {

	// list to contain different shapes
	private List<Shape> listOfShapes = new ArrayList<Shape>();
	
	// maximum value of x and y axis on screen
	private final double XMAX, YMAX;
	
	public Screen (double XMAX, double YMAX) {
		this.XMAX = XMAX;
		this.YMAX = XMAX;
	}
	
	/**
	 * Add a shape to screen
	 * @param shape of type Shape
	 */
	public void addShape (Shape shape) {
		// if shape is null
		if (shape == null) {
			throw new AssertionError("Shape cant be NULL");
		}
		
		// get origin point of shape
		Point origin = shape.getOrigin();
		
		// check if shape's point is inside the screen or outside the screen
		if (origin.getX() < 0 || origin.getX() > this.XMAX || origin.getY() < 0 || origin.getY() > this.YMAX) {
			throw new AssertionError("Cannot create shape outside the screen");
		}
		
		// add shape to screen
		this.listOfShapes.add(shape);
		
		// add current time as created time to shape also
		shape.setTimeStamp(new Date());
	}
	
	/**
	 * Delete shape from screen
	 * @param shape of type Shape
	 */
	public void deleteShape (Shape shape) {
		
		// check if list contains the shape
		if (this.listOfShapes.contains(shape)) {
			this.listOfShapes.remove(shape);
		} else {
			System.out.println("Shape not found");
		}
	}
	
	/**
	 * Delete shape type from screen
	 * @param shapeType of type ShapeType
	 */
	public void deleteShapeType (ShapeType shapeType) {
		boolean flag = false;
		List<Shape> removeList = new ArrayList<>();
		
		// iterate through complete list and add similar shapeType shapes to list
		for (Shape shape : this.listOfShapes) {
			if (shape.getShapeType() == shapeType) {
				flag = true;
				removeList.add(shape);
			}
		}
		
		// remove the list from original one
		this.listOfShapes.removeAll(removeList);
		
		if (!flag) {
			System.out.println("Shape not found");
		}
	}
	
	/**
	 * Sort the shapes of screen on their area wise
	 * @return new List of shapes
	*/
	public List<Shape> sortByArea () {
		// creates a copy of original list
		List<Shape> sortedListByArea = new ArrayList<>(this.listOfShapes);
		
		int noOfObjects = this.listOfShapes.size();
		
		// if list is empty
		if (noOfObjects == 0) {
			throw new AssertionError ("No shape found");
		}
		
		// iterate through all shapes
		for (int i = 0; i < noOfObjects; i++) {
			for (int j = 0; j < noOfObjects - 1 - i; j++) {
				if (sortedListByArea.get(j).getArea() > sortedListByArea.get(j + 1).getArea()) {
					Shape temp = sortedListByArea.get(j);
					sortedListByArea.set(j, sortedListByArea.get(j + 1));
					sortedListByArea.set(j + 1, temp);
				}
			}
		}
		return sortedListByArea;
	}
	
	/**
	 * Sort the shapes of screen on their perimeter wise
	 * @return new List of shapes
	*/
	public List<Shape> sortByPerimeter () {
		// create a copy of list from original one
		List<Shape> sortByPerimeter = new ArrayList<>(this.listOfShapes);
		
		int noOfObjects = this.listOfShapes.size();
		
		// if list is empty
		if (noOfObjects == 0) {
			throw new AssertionError ("No shape found");
		}
		
		// iterate through all shapes
		for (int i = 0; i < noOfObjects; i++) {
			for (int j = 0; j < noOfObjects - 1 - i; j++) {
				if (sortByPerimeter.get(j).getPerimeter() > sortByPerimeter.get(j + 1).getPerimeter()) {
					Shape temp = sortByPerimeter.get(j);
					sortByPerimeter.set(j, sortByPerimeter.get(j + 1));
					sortByPerimeter.set(j + 1, temp);
				}
			}
		}
		return sortByPerimeter;
	}
	
	/**
	 * Sort the shapes of screen on their distance of origin wise
	 * @return new List of shapes
	*/
	public List<Shape> sortByOriginDistance () {
		// create a copy of list from original one
		List<Shape> sortByOriginalDistance = new ArrayList<>(this.listOfShapes);
		int noOfObjects = this.listOfShapes.size();
		
		// if list is empty
		if (noOfObjects == 0) {
			throw new AssertionError ("No shape found");
		}
		
		// iterate through all shapes
		for (int i = 0; i < noOfObjects; i++) {
			for (int j = 0; j < noOfObjects - 1 - i; j++) {
				if (sortByOriginalDistance.get(j).getOriginDistance() > sortByOriginalDistance.get(j + 1).getOriginDistance()) {
					Shape temp = sortByOriginalDistance.get(j);
					sortByOriginalDistance.set(j, sortByOriginalDistance.get(j + 1));
					sortByOriginalDistance.set(j + 1, temp);
				}
			}
		}
		return sortByOriginalDistance;
	}
	
	/**
	 * Sort the shapes of screen on their creation time wise
	 * @return new List of shapes
	*/
	public List<Shape> sortByTimeStamp () {
		// create a copy list from original one
		List<Shape> sortByTimeStamp = new ArrayList<>(this.listOfShapes);
		int noOfObjects = this.listOfShapes.size();
		
		// if list is empty
		if (noOfObjects == 0) {
			throw new AssertionError ("No shape found");
		}
		
		// iterate through all shapes
		for (int i = 0; i < noOfObjects; i++) {
			for (int j = 0; j < noOfObjects - 1 - i; j++) {
				if (sortByTimeStamp.get(j).getTimeStamp().getTime() > sortByTimeStamp.get(j + 1).getTimeStamp().getTime()) {
					Shape temp = sortByTimeStamp.get(j);
					sortByTimeStamp.set(j, sortByTimeStamp.get(j + 1));
					sortByTimeStamp.set(j + 1, temp);
				}
			}
		}
		return sortByTimeStamp;
	}
	
	/**
	 * Used to check whether a point is overlapping to other shapes or not
	 * @param point of type Point
	 * @return a list of shapes on whihc point is overlapping
	 */
	public List<Shape> shapesEnclosingPoint (Point point) {
		List<Shape> listOfShapes = new ArrayList<>();
		if (point == null) {
			throw new AssertionError ("Point cant be null");
		}
		for (Shape shape : this.listOfShapes) {
			if (shape.isPointEnclosed(point))
				listOfShapes.add(shape);
		}
		return listOfShapes;
	}
	
}
