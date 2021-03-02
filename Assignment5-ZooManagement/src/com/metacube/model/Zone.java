package com.metacube.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Zone represents different zones in complete zoo
 * @author ameet.khemani_metacu
 *
 */
public class Zone {

	private final Category zoneCategory;
	private List<Cage> cages = new ArrayList<>();
	private int maxNumOfCages;
	boolean hasPark;
	boolean hasCanteen;
	
	public Zone(Category zoneCategory, int maxNumOfCages, int maxNumOfAnimalsInCage, boolean hasPark, boolean hasCanteen) {
		this.zoneCategory = zoneCategory;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
		this.maxNumOfCages = maxNumOfCages;
		for (int loopCounter = 1; loopCounter <= this.maxNumOfCages; loopCounter++) {
			Cage cage = new Cage(zoneCategory, maxNumOfAnimalsInCage);
			this.cages.add(cage);
		}
	}

	public int getMaxNumOfCages() {
		return maxNumOfCages;
	}

	public Category getZoneCategory() {
		return zoneCategory;
	}
	
	public List<Cage> getCages() {
		return cages;
	}
	
	public void addCage(Category zoneCategory, int maxNumOfAnimalsInCage) {
		Cage cage = new Cage(zoneCategory, maxNumOfAnimalsInCage);
		this.cages.add(cage);
		this.maxNumOfCages++;
	}
	
	public boolean isHasPark() {
		return hasPark;
	}
	
	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}
	
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	
	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}

}
