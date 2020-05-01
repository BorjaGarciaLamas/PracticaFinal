package com.dis.practicafinal.practicafinalDIS;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void nuevoUsuario() {

		Usuario u = new Usuario("Borja", "garcia", "Saliente 651", "BBVA", "borja@gmail.com", "123456789");
		assertEquals("Borja", u.getNombre());
	}

	@Test
	public void guardarUsuario() {
		
		Usuario u = new Usuario("Borja", "garcia", "Saliente 651", "BBVA", "borja@gmail.com", "123456789");
		Lista contactos = new Lista();
		
		contactos.addContacto(u);
		assertEquals(1, contactos.Tamanyo());
		
	}
	
	@Test
	public void modificarUsuario() {
		Usuario u = new Usuario("Borja", "garcia", "Saliente 651", "BBVA", "borja@gmail.com", "123456789");
		Usuario w = new Usuario("Carlos", "garcia", "Saliente 651", "BBVA", "borja@gmail.com", "123456789");
		u = u.modificar(w);		
		assertEquals(w, u);
		
	}
	
	
}
