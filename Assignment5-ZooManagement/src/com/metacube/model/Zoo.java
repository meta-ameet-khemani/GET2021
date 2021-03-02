package com.metacube.model;

import java.util.ArrayList;
import java.util.List;
import com.metacube.utility.Animal;

/**
 * Zoo class represents complete Zoo
 * @author ameet.khemani_metacu
 *
 */
public class Zoo {

	// list of all zones available in Zoo
	List<Zone> zones = new ArrayList<>();
	
	public void addZone(Zone zone) {
		this.zones.add(zone);
	}
	
	/**
	 * Adds an animal to particular zone
	 * @param animal to be added
	 * @param zone in whihc animal to be added
	 */
	public void addAnimal(Animal animal, Zone zone) {
		if (zone.getZoneCategory().equals(animal.getCategory())) {
			boolean isAnimalAdded = false;
			for (Cage cage : zone.getCages()) {
				if (cage.getMaxNumberOfAnimals() > cage.getAnimalsPresent()) {
					cage.setAnimal(animal);
					isAnimalAdded = true;
					break;
				}
			}
			if (!isAnimalAdded)
				System.out.println("Cant add animal (No space available)");
		} else {
			System.out.println("Cant add animal (Animal must be of same category as its zone is)");
		}
	}
	
	/**
	 * used to remove animal from zoo
	 * @param animalToRemove
	 */
	public void removeAnimal(Animal animalToRemove) {
		for (int zonesCounter = 0; zonesCounter < this.zones.size(); zonesCounter++) {
			for (int cageCounter = 0; cageCounter < this.zones.get(zonesCounter).getCages().size(); cageCounter++) {
				Cage cage = this.zones.get(zonesCounter).getCages().get(cageCounter);
				cage.removeAnimal(animalToRemove);
			}
		}
	}

	@Override
	public String toString() {
		String output = "Current zoo has " + this.zones.size() + " zones";
		for (int loopCounter = 0; loopCounter < this.zones.size(); loopCounter++) {
			output += "\n==================================\n";
			output += "Zone " + (loopCounter + 1) + " : Category " + this.zones.get(loopCounter).getZoneCategory() + " : Total Cages " + this.zones.get(loopCounter).getCages().size();
			for (int cageCounter = 0; cageCounter < this.zones.get(loopCounter).getCages().size(); cageCounter++) {
				output += "\nCage " + (cageCounter + 1) + " : MaxNumOfAnimals " + this.zones.get(loopCounter).getCages().get(cageCounter).getMaxNumberOfAnimals() + " : Animals Present " + this.zones.get(loopCounter).getCages().get(cageCounter).getAnimalsPresent();
				if (this.zones.get(loopCounter).getCages().get(cageCounter).getAnimalsPresent() > 0) {
					output += " Animal List " + this.zones.get(loopCounter).getCages().get(cageCounter).getAnimalList();
				}
			}
		}
		output += "\n";
		return output;
	}
}
