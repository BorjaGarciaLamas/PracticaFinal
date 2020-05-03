package com.dis.practicafinal.practicafinalDIS;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
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
	Usuario usuario = new Usuario();
	Usuario uborrar = new Usuario();
	Usuario umodificar = new Usuario();

	//Web de Vaadin
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	//Vista general.
        final VerticalLayout layout = new VerticalLayout();
        
        // ------------------------- pasar de objeto a json -------------------------------------------------------------------------
    	/*
    	agenda.addContacto(new Usuario("ObiWan","Kenobi","Coruscant","OrdenJedi","obiwankenobi@ordenjedi.com","123456"));
    	agenda.addContacto(new Usuario("Anakin","SkyWalker","Tatooine","OrdenJedi","anakinskywalker@ordenjedi.com","1236"));
		agenda.addContacto(new Usuario("Lando","Calrissian","Ciudad de las Nubes","Gobierno","landomilenario@codere.com","569"));
		agenda.addContacto(new Usuario("Leia","Organa","Not Alderaan","Republica","lorganarep@futurarepublica.com","3456789"));
		agenda.addContacto(new Usuario("Han","Solo","Tatooine","Jabba the hutt,","halconmilenariosolo@jabbafriends.com","45679"));
		
		try {
			agenda.guardarJson();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
    // ------------------------ FIN pasar de objeto a json ---------------------------------------------------------------------

    	
    // ----------------------------- Pasar de json a Objeto PETA -------------------------------------------------------------------
    	/*
		try {
			agenda.cargarJson();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	*/
    // ----------------------------  Fin Pasar de json a objeto PETA -------------------------------------------------------------------
 
        
        
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
        
        //Título
        final Label titulo = new Label();
        titulo.setCaption("Nuestra Aplicación de Contactos");
        titulo.addStyleName("mititulo");
        
        //Label + Caja Mensajes
        final Label mensajeAbajo = new Label();
        mensajeAbajo.setCaption("");
        
        //Grid
        Grid<Usuario> grid = new Grid<>(Usuario.class);
        grid.setSizeFull();
        grid.setItems(agenda.getContactos());
        grid.setColumns("nombre", "ape", "dir", "empresa", "mail", "numero");
        if(agenda.tamanyo()>=8)
            grid.setHeightByRows(8);
        else 
            grid.setHeightByRows(agenda.tamanyo());
        
        //Evento_GRID - Pulsar en un elemento del grid saca el detalle (este coso solo la funcion mostrar nombre por apellido)
        grid.addItemClickListener(
                event -> mensajeAbajo.setCaption(event.getItem().getNombre()+" "+event.getItem().getApe()+", "+event.getItem().getDir()+", "+event.getItem().getEmpresa()+", "+event.getItem().getMail()+", "+event.getItem().getNumero()+".")
                );
        
        //------------FIN DE ELEMENTOS PRINCIPALES--------------
        
        
        
        //------------------PESTAÑA OVERVIEW---------------------
        
        //Descripción inicial
        final Label Descripcion0 = new Label();
        Descripcion0.setCaption("Vista general de los contactos de la aplicación.");
        
        

        //Cargamos los elementos en la pestaña asociada.
        tab1.addComponents(grid);
        
        //----------------FIN DE PESTAÑA DE OVERVIEW-------------------
        
        
        
        //------------------PESTAÑA CREAR NUEVO USUARIO---------------------
        
        //Descripción inicial
        final Label Descripcion1 = new Label();
        Descripcion1.setCaption("Aquí puede añadir un nuevo usuario, rellenando los campos mostrados y haciendlo click en añadir. Puede comprobarlo en la tabla inferior.");
        
        final TextField txtnombre = new TextField();
        txtnombre.setCaption("Escribe tu nombre aqui:");
       
        final TextField txtape = new TextField();
        txtape.setCaption("Escribe tu apellido aqui:");
        
        final TextField txtdir = new TextField();
        txtdir.setCaption("Escribe tu ndireccion aqui:");
               
        final TextField txtempresa = new TextField();
        txtempresa.setCaption("Escribe tu empresa aqui:");      
        
        final TextField txtmail = new TextField();
        txtmail.setCaption("Escribe tu email aqui:");      
        
        final TextField txtnumero = new TextField();
        txtnumero.setCaption("Escribe tu numero de telefono aqui:");
        
        //Grid<Usuario> grid1 = new Grid<>(Usuario.class);
        
		Button button = new Button("Añadir");
        button.addClickListener(e -> {
        	usuario.setNombre(txtnombre.getValue());
        	usuario.setApe(txtape.getValue());
        	usuario.setDir(txtdir.getValue());
        	usuario.setEmpresa(txtempresa.getValue());
        	usuario.setMail(txtmail.getValue());
        	usuario.setNumero(txtnumero.getValue());
        	
        	agenda.addContacto(usuario);
        	
        	//Comprobacion para ajustar la altura
            if(agenda.tamanyo()>=8)
                grid.setHeightByRows(8);
            else 
                grid.setHeightByRows(agenda.tamanyo());
            
            grid.setItems(agenda.getContactos());
       		
            mensajeAbajo.setCaption("Se ha procedido a añadir al usuario " + usuario.getNombre());
            
            agenda.mostrarLista();
        });

        //Cargamos los elementos en la pestaña asociada.
        tab2.addComponents(Descripcion1, txtnombre, txtape, txtape, txtdir, txtempresa, txtmail, txtnumero, button, grid);

        //----------------FIN DE PESTAÑA DE CREAR USUARIO-------------------
        

        
        //------------------PESTAÑA CREAR MODIFICAR USUARIO---------------------
        
        final Label Descripcion2 = new Label();
        Descripcion2.setCaption("Aquí puede modificar un usuario existente, haciendo click en el usuario y modificando sus valores. Una vez modificado, puede comprobarlo en la tabla inferior.");
        
    	final TextField modnombre = new TextField();
    	modnombre.setCaption("Escribe tu nombre aqui:");        

        final TextField modape = new TextField();
        modape.setCaption("Escribe tu apellido aqui:");       
        
        final TextField moddir = new TextField();
        moddir.setCaption("Escribe tu ndireccion aqui:");      
        
        final TextField modempresa = new TextField();
        modempresa.setCaption("Escribe tu empresa aqui:");       
        
        final TextField modmail = new TextField();
        modmail.setCaption("Escribe tu email aqui:");       
        
        final TextField modnumero = new TextField();
        modnumero.setCaption("Escribe tu numero de telefono aqui:");
        
        //Pulsar en un elemento del grid saca el detalle (este coso solo la funcion mostrar nombre por apellido)
        grid.addItemClickListener(
                event -> {umodificar = event.getItem();
                modnombre.setValue(umodificar.getNombre());
                modape.setValue(umodificar.getApe());
                moddir.setValue(umodificar.getDir());
                modempresa.setValue(umodificar.getEmpresa());
                modmail.setValue(umodificar.getMail());
                modnumero.setValue(umodificar.getNumero());             
                } );
        
        Button buttonModificar = new Button("Modificar");
        buttonModificar.addClickListener(e -> {
        	System.out.println("Antes");
        	agenda.mostrarLista();
        	
       		mensajeAbajo.setCaption("Se ha procedido a modificar el usuario " + umodificar.getNombre());
            
            umodificar.setNombre(modnombre.getValue());
            umodificar.setApe(modape.getValue());
            umodificar.setDir(moddir.getValue());
            umodificar.setEmpresa(modempresa.getValue());
            umodificar.setMail(modmail.getValue());
            umodificar.setNumero(modnumero.getValue());       	
        	//agenda.addContacto(usuario);
            //Comprobacion para ajustar la altura
            if(agenda.tamanyo()>=8)
                grid.setHeightByRows(8);
            else 
                grid.setHeightByRows(agenda.tamanyo());
            
            grid.setItems(agenda.getContactos());                       
            
            System.out.println("\n Despues");
            agenda.mostrarLista();
        });

        //Cargamos los elementos en la pestaña asociada.
        tab3.addComponents(Descripcion2, grid, modnombre, modape, moddir, modempresa, modmail, modnumero, buttonModificar);
        
        //----------------FIN DE PESTAÑA DE MODIFICAR USUARIO-------------------
        
        
        
        
        //------------------PESTAÑA DE BORRAR USUARIO---------------------
        
        final Label Descripcion3 = new Label();
        Descripcion3.setCaption("Aquí puede borrar un usuario existente. Haga click en el usuario deseado y después pulse 'borrar'. Una vez borrado, puede comprobarlo en la tabla inferior.");
                
        //Pulsar en un elemento del grid saca el detalle (este coso solo la funcion mostrar nombre por apellido)
        grid.addItemClickListener(
                event -> {uborrar = event.getItem();
                	System.out.println(uborrar.toString());
                } );
           
        Button buttonEliminar = new Button("Eliminar");
        buttonEliminar.addClickListener(e -> {
        	System.out.println("Antes");
        	agenda.mostrarLista();
           	
        	agenda.eliminar(uborrar);	
           	
        	mensajeAbajo.setCaption("Se ha procedido a eliminar el usuario " + uborrar.getNombre());
               
           	//Comprobacion para ajustar la altura
            if(agenda.tamanyo()>=8)
                 grid.setHeightByRows(8);
             else 
                 grid.setHeightByRows(agenda.tamanyo());
                
            grid.setItems(agenda.getContactos());
               
           	System.out.println("\n Despues");
           	agenda.mostrarLista();
        });           

        //Cargamos los elementos en la pestaña asociada.
        tab4.addComponents(Descripcion3, grid, buttonEliminar);

        //----------------FIN DE PESTAÑA DE BORRAR USUARIO-------------------
        
        
        
        
        //------------------PESTAÑA GSON---------------------
        
        //Descripción
        final Label Descripcion4 = new Label();
        Descripcion4.setCaption("Aquí puede gestionar el Gson.");         
        
        //Cargamos los elementos en la pestaña asociada.
        tab5.addComponents(Descripcion4);
        
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
	            	tab.addComponents(Descripcion0, grid);
	            	break;
	            case "Añadir":
	                tab.addComponents(Descripcion1, txtnombre, txtape, txtape, txtdir, txtempresa, txtmail, txtnumero, button, grid);
	            	break;
	            case "Modificar":
	                tab.addComponents(Descripcion2, grid, modnombre, modape, moddir, modempresa, modmail, modnumero, buttonModificar);
	                break;
	            case "Borrar":
	            	tab.addComponents(Descripcion3, grid, buttonEliminar);
	            	break;
	            case "Configuración (Gson)":
	            	tab.addComponents(Descripcion4);
	            	mensajeAbajo.setCaption("");
	            	break;
	            default:
	            	break;
	            }
            }
        });
        
        //-----------FIN DE EVENTOS-------------
        
        //----------CARGA DEL LAYOUT------------------
        //Ponemos los elementos del layout (siempre visibles)
        layout.addComponents(titulo, tabsheet,mensajeAbajo);
        
        //Ponemos los elementos de la pestaña que queremos cargar (tab1).
        Layout tabInicial = (Layout) tabsheet.getSelectedTab();
        tabInicial.addComponents(Descripcion0, grid);

        setContent(layout);
        //----------FIN DE CARGA DEL LAYOUT------------------
        
        //agenda.mostrarLista();   
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
