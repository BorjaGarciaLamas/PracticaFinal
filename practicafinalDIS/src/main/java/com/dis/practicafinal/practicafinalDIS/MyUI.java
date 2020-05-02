package com.dis.practicafinal.practicafinalDIS;

import java.io.IOException;
import java.util.Set;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
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

	Usuario usuario = new Usuario();
	Lista agenda = new Lista();
	Usuario uborrar = new Usuario();
	Usuario umodificar = new Usuario();
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
    	
    	
        
    	
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
        
		
    // --------------------------  Insertar nuevo usuario y verlo en la tabla ----------------------------------------------------------
		final VerticalLayout layout1 = new VerticalLayout();
		
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
        
        Grid<Usuario> grid = new Grid<>(Usuario.class);
        
		Button button = new Button("Anyadir");
        button.addClickListener(e -> {
        	usuario.setNombre(txtnombre.getValue());
        	usuario.setApe(txtape.getValue());
        	usuario.setDir(txtdir.getValue());
        	usuario.setEmpresa(txtempresa.getValue());
        	usuario.setMail(txtmail.getValue());
        	usuario.setNumero(txtnumero.getValue());
        	
        	agenda.addContacto(usuario);
        	
        	
            grid.setItems(agenda.getContactos());
        	
            layout1.addComponent(new Label("Gracias " + txtnombre.getValue() 
                    + ", Se ha registrado satisfactoriamente"));
            
            agenda.mostrarLista();
        });
        
        
        grid.setColumns("nombre", "ape", "dir", "empresa", "mail", "numero");
        
        grid.setItems(agenda.getContactos());
        

        // pulsar en un elemento del grid saca el detalle (este coso solo la funcion mostrar nombre por apellido)
        grid.addItemClickListener(
                event -> layout1.addComponent(new Label(event.getItem().toString() ))
                );

        
		
        layout1.addComponents(txtnombre, txtape, txtape, txtdir, txtempresa, txtmail, txtnumero, button, grid);
        
        setContent(layout1);
        
    // ----------------------------------- FIN Insertar nuevo usuario y verlo en la tabla --------------------------------------------------------
        
        
    // -------------------------------------------------- eliminar un usuario -------------------------------------------------------------
       
        final VerticalLayout layout2 = new VerticalLayout();
        
       
        
     // pulsar en un elemento del grid saca el detalle (este coso solo la funcion mostrar nombre por apellido)
        grid.addItemClickListener(
                event -> {uborrar = event.getItem();
                System.out.println(uborrar.toString());
                } );
        
        Button buttonEliminar = new Button("Eliminar");
        buttonEliminar.addClickListener(e -> {
        	System.out.println("Antes");
        	agenda.mostrarLista();
        	
            layout2.addComponent(new Label("el usuario " + uborrar.getNombre() 
                    + ", Se ha eliminado satisfactoriamente"));
            
            grid.setItems(agenda.getContactos());
            
            agenda.eliminar(uborrar);
            
            System.out.println("\n Despues");
            agenda.mostrarLista();
        });
        
        
        grid.setColumns("nombre", "ape", "dir", "empresa", "mail", "numero");
        
        grid.setItems(agenda.getContactos());
        
        layout2.addComponents(buttonEliminar, grid);
        
        setContent(layout2);
    // -------------------------------------------------- FIN eliminar un usuario ---------------------------------------------------------- 
        
        
    // ---------------------------------------------------- Modificar usuario --------------------------------------------------------------
        final VerticalLayout layout3 = new VerticalLayout();
        
		
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
        
     // pulsar en un elemento del grid saca el detalle (este coso solo la funcion mostrar nombre por apellido)
        grid.addItemClickListener(
                event -> {umodificar = event.getItem();
                System.out.println(umodificar.toString());
                
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
        	
            layout3.addComponent(new Label("el usuario " + umodificar.getNombre() 
                    + ", Se ha modificado satisfactoriamente"));
            
            umodificar.setNombre(modnombre.getValue());
            umodificar.setApe(modape.getValue());
            umodificar.setDir(moddir.getValue());
            umodificar.setEmpresa(modempresa.getValue());
            umodificar.setMail(modmail.getValue());
            umodificar.setNumero(modnumero.getValue());
        	
        	//agenda.addContacto(usuario);
            
            grid.setItems(agenda.getContactos());
            
            
            
            System.out.println("\n Despues");
            agenda.mostrarLista();
        });
        
        
        grid.setColumns("nombre", "ape", "dir", "empresa", "mail", "numero");
        
        grid.setItems(agenda.getContactos());
        
        layout3.addComponents(modnombre, modape, moddir, modempresa, modmail, modnumero, buttonModificar, grid);
        
        setContent(layout3);
    // ---------------------------------------------------- FIN Modificar usuario ----------------------------------------------------------
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
