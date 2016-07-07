package org.vaadin.miki.charts.data.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.vaadin.miki.charts.data.BookService;
import org.vaadin.miki.charts.data.PriceService;
import org.vaadin.miki.charts.data.model.Book;
import org.vaadin.miki.charts.data.model.BookPrice;
import org.vaadin.miki.charts.data.model.Person;

public class MockDataService implements PriceService, BookService {

	private final Random random = new Random();

	@Override
	public Collection<BookPrice> getPrices(Book book, int... years) {
		final ArrayList<BookPrice> result = new ArrayList<>();
			for (int year : years) {
				BookPrice price = new BookPrice();
				price.setAmount(20.0f + this.random.nextInt(3000) / 100.0f);
				price.setYear(year);
				price.setBook(book);
				result.add(price);
			}
		return result;
	}

	@Override
	public Collection<Book> getBooks() {
		return Arrays.asList(new Book("The Witcher", new Person("Andrzej Sapkowski")),
				new Book("Solaris", new Person("Stanisław Lem")), new Book("1984", new Person("George Orwell")),
				new Book("Brave New World", new Person("Aldus Huxley")),
				new Book("The Painted Man", new Person("Peter V. Brett")),
				new Book("The God Delusion", new Person("Richard Dawkins")));
	}

}
