package com.metacube.utility;

import com.metacube.model.Category;

/**
 * Base class which represents all animals
 * @author ameet.khemani_metacu
 *
 */
public abstract class Animal {

	String id;
	String name;
	int age;
	boolean isDead;
	float weight;
	Category category;
	String sound;
	
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", age=" + age
				+ ", isDead=" + isDead + ", weight=" + weight + ", category="
				+ category + ", sound=" + sound + "]";
	}
}
