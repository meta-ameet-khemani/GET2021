package com.metacube.utility;

import com.metacube.model.Category;

/**
 * Elephant class represents Elephant Animal
 * @author ameet.khemani_metacu
 *
 */
public class Elephant extends Animal {

	public Elephant(String id, String name, int age, boolean isDead, float weight, Category category, String sound) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setDead(isDead);
		this.setWeight(weight);
		this.setCategory(category);
		this.setSound(sound);
	}
}
