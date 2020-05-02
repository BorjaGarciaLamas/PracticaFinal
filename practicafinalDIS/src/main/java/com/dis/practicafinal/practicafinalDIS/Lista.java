package com.dis.practicafinal.practicafinalDIS;

import java.util.ArrayList;

public class Lista {

	private ArrayList<Usuario> contactos;
	
	/*------------------------------------------------------------------------------------------------------------------------------*/
	
		
	public void addContacto(Usuario u) {
		
		this.contactos.add(u);		
	}
	
	
	/*Contructores*/
	public Lista() {
		
		this.contactos = new ArrayList<Usuario>();
		
		this.addContacto(new Usuario("ObiWan","Kenobi","Coruscant","OrdenJedi","obiwankenobi@ordenjedi.com","123456"));
		this.addContacto(new Usuario("Anakin","SkyWalker","Tatooine","OrdenJedi","anakinskywalker@ordenjedi.com","1236"));
		this.addContacto(new Usuario("Lando","Calrissian","Ciudad de las Nubes","Gobierno","landomilenario@codere.com","569"));
		this.addContacto(new Usuario("Leia","Organa","Not Alderaan","Republica","lorganarep@futurarepublica.com","3456789"));
		this.addContacto(new Usuario("Han","Solo","Tatooine","Jabba the hutt,","halconmilenariosolo@jabbafriends.com","45679"));
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
		if(posicion == -1)
			System.out.println("No se ha encontrado el usuario");
		return posicion;
	}
	
	
	
	
}
