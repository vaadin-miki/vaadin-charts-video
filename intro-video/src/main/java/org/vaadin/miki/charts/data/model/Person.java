package org.vaadin.miki.charts.data.model;

import java.util.Objects;

/**
 * Represents a person.
 * @author Miki
 *
 */
public class Person {

	private String name;

	public Person() {
		;
	}
	
	public Person(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Person && Objects.equals(this.getName(), ((Person)obj).getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getName());
	}
	
}
