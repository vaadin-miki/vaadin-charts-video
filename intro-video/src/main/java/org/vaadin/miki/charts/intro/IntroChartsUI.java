package org.vaadin.miki.charts.intro;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;

import org.vaadin.miki.charts.data.mock.MockDataService;
import org.vaadin.miki.charts.data.model.Book;
import org.vaadin.miki.charts.data.model.BookPrice;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ContainerDataSeries;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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
        	BeanItemContainer<BookPrice> container = new BeanItemContainer<>(BookPrice.class, prices);
        	ContainerDataSeries series = new ContainerDataSeries(container);
        	series.setYPropertyId("amount");
        	series.setXPropertyId("year");
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
