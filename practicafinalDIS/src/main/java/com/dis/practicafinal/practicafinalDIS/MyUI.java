package com.dis.practicafinal.practicafinalDIS;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
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
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
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
        	
            layout.addComponent(new Label("Gracias " + txtnombre.getValue() 
                    + ", Se ha registrado satisfactoriamente"));
            
            agenda.mostrarLista();
        });
        
        
        grid.setColumns("nombre", "ape", "dir", "empresa", "mail", "numero");
        
        grid.setItems(agenda.getContactos());
		
        layout.addComponents(txtnombre, txtape, txtape, txtdir, txtempresa, txtmail, txtnumero, button, grid);
        
        setContent(layout);
        
        
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
