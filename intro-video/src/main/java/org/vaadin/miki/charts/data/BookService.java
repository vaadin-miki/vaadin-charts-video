package org.vaadin.miki.charts.data;

import java.util.Collection;

import org.vaadin.miki.charts.data.model.Book;

/**
 * Interface for returning books.
 * @author Miki
 *
 */
@FunctionalInterface
public interface BookService {

	/**
	 * Returns a collection of books.
	 * @return Collection of books.
	 */
	public Collection<Book> getBooks();
	
}
