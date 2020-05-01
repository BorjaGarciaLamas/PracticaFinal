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
	
}
