package org.vaadin.miki.charts.data.model;

import java.util.Objects;

/**
 * Represents a country.
 * @author Miki
 *
 */
public class Country {

	private String name;
	private boolean eu;
	
	public Country() {
		;
	}
	
	public Country(String name, boolean eu) {
		this.setName(name);
		this.setEu(eu);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEu() {
		return eu;
	}
	public void setEu(boolean eu) {
		this.eu = eu;
	}
	
	@Override
	public String toString() {
		return this.getName()+(this.isEu()?"*":"");
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getName());
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Country && Objects.equals(this.getName(), ((Country)obj).getName());
	}
	
}
