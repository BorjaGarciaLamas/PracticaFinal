package com.dis.practicafinal.practicafinalDIS;

import java.util.ArrayList;

public class Lista {

	private ArrayList<Usuario> contactos;
	
	/*------------------------------------------------------------------------------------------------------------------------------*/
	/*Contructores*/
	public Lista() {
		
		contactos = new ArrayList<Usuario>();
		
	}
	
	
	public void addContacto(Usuario u) {
		
		contactos.add(u);
		
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------*/
	/*Getters y Setters*/
	public ArrayList<Usuario> getContactos() {
		return contactos;
	}


	public void setContactos(ArrayList<Usuario> contactos) {
		this.contactos = contactos;
	}

	/*----------------------------------------------------------------------------------------------------------------------------*/
	/*Otras funciones*/
	public int Tamanyo() {
		
		return contactos.size();
	}
	
	public void MostrarLista() {
		for(int i = 0; i < this.Tamanyo(); i++) {
			System.out.println(this.getContactos().get(i).toString());
		}
	}

	public void eliminar(Usuario u) {
		
		int posicion = this.buscar(u);
		if(posicion!=-1)
			this.getContactos().remove(posicion);
		else
			System.out.println("No se ha encontrado el usuario");
	}

	public int buscar(Usuario u) {
		
		int posicion = -1;
		
		for(int i = 0; i < this.Tamanyo() && posicion == -1; i++) {
			if(this.contactos.get(i) == u)
				posicion = i;
		}				
		return posicion;
	}
	
	
	
	
}
