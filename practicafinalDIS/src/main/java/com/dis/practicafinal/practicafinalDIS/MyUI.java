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
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
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

	
	//Inicialización de variables
	
	Lista agenda = new Lista();
	//Web de Vaadin
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	//Vista general.
        final VerticalLayout layout = new VerticalLayout();
        

        //------------ELEMENTOS PRINCIPALES---------------------
        
        //Pestañas (tabs)
        TabSheet tabsheet = new TabSheet();
        
        VerticalLayout tab1 = new VerticalLayout();
        VerticalLayout tab2 = new VerticalLayout();
        VerticalLayout tab3 = new VerticalLayout();
        VerticalLayout tab4 = new VerticalLayout();
        VerticalLayout tab5 = new VerticalLayout();
        
        tabsheet.addTab(tab1, "Overview");
        tabsheet.addTab(tab2, "Añadir");
        tabsheet.addTab(tab3, "Modificar");
        tabsheet.addTab(tab4, "Borrar");
        tabsheet.addTab(tab5, "Configuración (Gson)");
        
        //Botón 1
        Button button2 = new Button("Click Me2");
        button2.addClickListener(e -> {
            layout.addComponent(new Label("Thanks, it works!"));
        });
        
        //------------FIN DE ELEMENTOS PRINCIPALES--------------
        
        
        
        //------------------PESTAÑA OVERVIEW---------------------
        
        //Objeto 1
        final TextField name1 = new TextField();
        name1.setCaption("Pestaña 1");
        
        //Grid
        Grid<Usuario> grid = new Grid<>(Usuario.class);
        grid.setItems(agenda.getContactos());
        grid.setColumns("nombre", "ape", "dir", "empresa", "mail", "numero");
        
        //Cargamos los elementos en la pestaña asociada.
        tab1.addComponents();
        
        //----------------FIN DE PESTAÑA DE OVERVIEW-------------------
        
        
        
        //------------------PESTAÑA CREAR NUEVO USUARIO---------------------
        
        //Objeto 1
        final TextField name2 = new TextField();
        name2.setCaption("Pestaña 2");
        
        //Objeto 2
        Button button = new Button("Click Me");

        
        //Cargamos los elementos en la pestaña asociada.
        tab2.addComponents();
        
        //----------------FIN DE PESTAÑA DE CREAR USUARIO-------------------
        

        
        //------------------PESTAÑA CREAR MODIFICAR USUARIO---------------------
        
        //Objeto 1
        final TextField name3 = new TextField();
        name3.setCaption("Pestaña 3");
        
        //Cargamos los elementos en la pestaña asociada.
        tab3.addComponents();
        
        //----------------FIN DE PESTAÑA DE MODIFICAR USUARIO-------------------
        
        
        
        
        //------------------PESTAÑA DE BORRAR USUARIO---------------------
        
        //Objeto 1
        final TextField name4 = new TextField();
        name4.setCaption("Pestaña 4");
        
        //Cargamos los elementos en la pestaña asociada.
        tab4.addComponents();
        
        //----------------FIN DE PESTAÑA DE BORRAR USUARIO-------------------
        
        
        
        
        //------------------PESTAÑA GSON---------------------
        //Objeto 1
        final TextField name5 = new TextField();
        name5.setCaption("Pestaña 5");
        
        //Cargamos los elementos en la pestaña asociada.
        tab5.addComponents();
        
        //----------------FIN DE PESTAÑA GSON-------------------

      
     
        
        //-----------EVENTOS-------------
        
        //Evento botón Crear Usuario

        
        //Evento de cambiar pestaña.
        tabsheet.addSelectedTabChangeListener(new TabSheet.SelectedTabChangeListener() {
            public void selectedTabChange(SelectedTabChangeEvent event) {
	        	//Cogemos el tab actual
	            TabSheet tabsheetActual = event.getTabSheet();
	            //Cogemos el layout
	            Layout tab = (Layout) tabsheetActual.getSelectedTab();
	            //Cogemos el caption
	            String caption = tabsheetActual.getTab(tab).getCaption();
	            System.out.println(caption);
	            //Eliminamos todos los objetos de la pestaña (en pantalla).
	            tab.removeAllComponents();
	            
	            switch(caption) {
	            case "Overview":	            	
	            	for(int i = 0; i<tab1.getComponentCount(); i++) 
			            tab.addComponents(tab1.getComponent(i));
	            	break;
	            case "Añadir":
	            	for(int i = 0; i<tab2.getComponentCount(); i++) 
			            tab.addComponents(tab2.getComponent(i));		
	            	break;
	            case "Modificar":
	            	for(int i = 0; i<tab3.getComponentCount(); i++) 
			            tab.addComponents(tab3.getComponent(i));
	            	break;
	            case "Borrar":
	            	for(int i = 0; i<tab4.getComponentCount(); i++) 
			            tab.addComponents(tab4.getComponent(i));
	            	break;
	            case "Configuración (Gson)":
	            	for(int i = 0; i<tab5.getComponentCount(); i++) 
			            tab.addComponents(tab5.getComponent(i));
	            	break;
	            default:
	            	break;
	            
	            }
            }
        });
        //-----------FIN DE EVENTOS-------------
        
        //----------CARGA DEL LAYOUT------------------
        //Ponemos los elementos del layout (siempre visibles)
        layout.addComponents(tabsheet);
        
        //Ponemos los elementos de la pestaña que queremos cargar (tab1).
        layout.addComponents();

        setContent(layout);
        //----------FIN DE CARGA DEL LAYOUT------------------
        
        //agenda.mostrarLista();   
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
