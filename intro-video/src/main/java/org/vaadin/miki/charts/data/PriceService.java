package org.vaadin.miki.charts.data;

import java.util.Collection;

import org.vaadin.miki.charts.data.model.Book;
import org.vaadin.miki.charts.data.model.BookPrice;

/**
 * Interface for objects that return prices of books.
 * @author Miki
 *
 */
@FunctionalInterface
public interface PriceService {

	/**
	 * Returns prices of specified books in given years. If no years specified, the result is undefined.
	 * @param book Book to check price of.
	 * @param years Years to check prices for.
	 * @return A collection of prices.
	 */
	public Collection<BookPrice> getPrices(Book book, int... years);
	
}
