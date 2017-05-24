package org.vaadin.miki.charts.intro;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataProviderSeries;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.miki.charts.data.mock.MockDataService;
import org.vaadin.miki.charts.data.model.Book;
import org.vaadin.miki.charts.data.model.BookPrice;

import javax.servlet.annotation.WebServlet;
import java.util.Collection;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("introtheme")
@Widgetset("org.vaadin.miki.charts.intro.IntroChartsWidgetset")
public class IntroChartsUI extends UI {

	private MockDataService service = new MockDataService();
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        Chart chart = new Chart(ChartType.COLUMN);
        Configuration config = chart.getConfiguration();
        config.setTitle("Good books and their random prices");
        config.setSubTitle("Years 2011-2015, prices in EUR");
        
        Collection<Book> books = service.getBooks();
        
        for(Book book: books) {
        	Collection<BookPrice> prices = this.service.getPrices(book, 2011, 2012, 2013, 2014, 2015);

            // Vaadin 8 no longer has containers - instead we are using Java 8 awesomeness
            ListDataProvider<BookPrice> provider = new ListDataProvider<>(prices);

        	DataProviderSeries<BookPrice> series = new DataProviderSeries<>(provider);
        	series.setY(BookPrice::getAmount);
        	series.setX(BookPrice::getYear);
        	series.setName(book.toString());
        	config.addSeries(series);
        }

        layout.addComponent(chart);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "IntroChartsUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = IntroChartsUI.class, productionMode = false)
    public static class IntroChartsUIServlet extends VaadinServlet {
    }
}
