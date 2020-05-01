package com.dis.practicafinal.practicafinalDIS;

import java.util.ArrayList;

public class Lista {

	private ArrayList<Usuario> contactos;
	
	public Lista() {
		
		contactos = new ArrayList<Usuario>();
		
	}
	
	public Lista() {
		
	}
	
	
	
	
	public void addContacto(Usuario u) {
		
		contactos.add(u);
		
	}

	public int Tamaño() {
		
		return contactos.size();
	}

}
