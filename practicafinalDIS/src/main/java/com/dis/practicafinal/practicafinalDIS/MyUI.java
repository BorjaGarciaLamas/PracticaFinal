package com.dis.practicafinal.practicafinalDIS;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	Lista agenda = new Lista();
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        /*
        //Tabs
        Tab tab1 = new Tab("Tab one");
        Div page1 = new Div();
        page1.setText("Page#1");

        Tab tab2 = new Tab("Tab two");
        Div page2 = new Div();
        page2.setText("Page#2");
        page2.setVisible(false);

        Tab tab3 = new Tab("Tab three");
        Div page3 = new Div();
        page3.setText("Page#3");
        page3.setVisible(false);

        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);
        Tabs tabs = new Tabs(tab1, tab2, tab3);
        Div pages = new Div(page1, page2, page3);
        Set<Component> pagesShown = Stream.of(page1)
                .collect(Collectors.toSet());

        
    	*/
        
        TabSheet tabsheet = new TabSheet();

        // Create the first tab
        VerticalLayout tab1 = new VerticalLayout();
        VerticalLayout tab2 = new VerticalLayout();
        VerticalLayout tab3 = new VerticalLayout();
        VerticalLayout tab4 = new VerticalLayout();

        tab1.addComponents(name, button);
        tab2.addComponents(button);
        tab3.addComponents(name);
        tab4.addComponents(button);
        
        tabsheet.addTab(tab1, "Overview");
        tabsheet.addTab(tab2, "Añadir");
        tabsheet.addTab(tab3, "Modificar");
        tabsheet.addTab(tab4, "Borrar");
        
        //Evento de cambiar pestaña.
        tabsheet.addSelectedTabChangeListener(event -> {
        	// Find the tabsheet
            TabSheet tabsheetActual = event.getTabSheet();

            // Find the tab (here we know it's a layout)
            Layout tab = (Layout) tabsheetActual.getSelectedTab();

            // Get the tab caption from the tab object
            String caption = tabsheet.getTab(tab).getCaption();

            // Fill the tab content
            tab.removeAllComponents();
        	
        });
      
        //Grid e impresión de layout.
        Grid<Usuario> grid = new Grid<>(Usuario.class);
        grid.setItems(agenda.getContactos());
        grid.setColumns("nombre", "ape", "dir", "empresa", "mail", "numero");
        
        //Elementos en el layout.
        layout.addComponents(tabsheet, grid);
        
        setContent(layout);
        
        agenda.mostrarLista();   
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
