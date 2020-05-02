package com.dis.practicafinal.practicafinalDIS;

import java.util.ArrayList;

public class Lista {

	private ArrayList<Usuario> contactos;
	private int id = 0;
	
	/*------------------------------------------------------------------------------------------------------------------------------*/
	
		
	public void addContacto(Usuario u) {
		
		u.setId(this.id);
		this.id++;
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
	public int tamanyo() {
		
		return contactos.size();
	}
	
	public void mostrarLista() {
		for(int i = 0; i < this.tamanyo(); i++) {
			System.out.println(this.getContactos().get(i).toString());
		}
	}

	public void eliminar(Usuario u) {
		
		int posicion = this.buscar(u);
		if(posicion!=-1) {
			this.getContactos().remove(posicion);
			System.out.println("Se ha eliminado el usuario");
		}
		else
			System.out.println("No se ha encontrado el usuario");
	}

	
	public int buscar(Usuario u) {
		
		int posicion = -1;
		
		for(int i = 0; i < this.tamanyo() && posicion == -1; i++) {
			if(this.contactos.get(i) == u)
				posicion = i;
		}
		if(posicion == -1)
			System.out.println("No se ha podido encontrado el usuario");
		return posicion;
	}


	public Usuario obtener(Usuario u) {
		
		Usuario usuario_aux = new Usuario();
		int encontrado = -1;
		for(int i =0; i < this.tamanyo() && encontrado == -1; i++) {
			if(this.getContactos().get(i) == u) {
				usuario_aux = u;
				encontrado = 1;
			}
		}
		return usuario_aux;
		
	}
	
	
	
	
}
