package org.vaadin.miki.charts.data.model;

import java.util.Objects;

/**
 * Represents a book.
 * @author Miki
 *
 */
public class Book {

	private String title;
	private Person author;
	
	public Book(String title, Person author) {
		this.setTitle(title);
		this.setAuthor(author);
	}
	
	public Book() {
		;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "\""+this.getTitle()+"\" ("+this.getAuthor()+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Book && Objects.equals(this.getTitle(), ((Book)obj).getTitle()) && Objects.equals(this.getAuthor(), ((Book)obj).getAuthor());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getAuthor(), this.getTitle());
	}
}
