package org.vaadin.miki.charts.data.model;

import java.util.Objects;

/**
 * Represents a price of a book in a given year.
 * 
 * @author Miki
 *
 */
public class BookPrice {

	private Book book;
	private int year;
	private float amount;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getBook(), this.getAmount(), this.getYear());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BookPrice) {
			BookPrice o = (BookPrice) obj;
			return Objects.equals(this.getBook(), o.getBook()) && this.getYear() == o.getYear()
					&& this.getAmount() == o.getAmount();
		} else
			return false;
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f (%4d)", this.getBook().toString(), this.getAmount(), this.getYear());
	}
}
