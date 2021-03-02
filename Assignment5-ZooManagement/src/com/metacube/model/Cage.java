package com.metacube.model;

import java.util.ArrayList;
import java.util.List;
import com.metacube.utility.Animal;

/**
 * Cage represents a single cage in zoo
 * @author ameet.khemani_metacu
 *
 */
public class Cage {

	// list of animals in single cage
	public List<Animal> animalList;
	
	public Category category;
	
	private final int maxNumberOfAnimals;
	
	private int animalsPresent;
	
	public Cage(Category category, int maxNumberOfAnimals) {
		this.category = category;
		this.maxNumberOfAnimals = maxNumberOfAnimals;
		this.animalsPresent = 0;
		animalList = new ArrayList<>();
	}
	
	public void removeAnimal(Animal animalToRemove) {
		for (int animalListCounter = 0; animalListCounter < this.animalList.size(); animalListCounter++) {
			if (animalToRemove.getId().equals(this.animalList.get(animalListCounter).getId())) {
				this.animalList.get(animalListCounter).setDead(true);
				this.animalsPresent--;
			}
		}
	}

	public List<Animal> getAnimalList() {
		List<Animal> animalListToReturn = new ArrayList<>();
		for(Animal animal : this.animalList)
			if (!animal.isDead())
				animalListToReturn.add(animal);
		return animalListToReturn;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	public void setAnimal(Animal animal) {
		this.animalList.add(animal);
		this.animalsPresent++;
	}

	public int getMaxNumberOfAnimals() {
		return maxNumberOfAnimals;
	}

	public int getAnimalsPresent() {
		return animalsPresent;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
