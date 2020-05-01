package com.dis.practicafinal.practicafinalDIS;

public class Usuario {

	String nombre;
	String ape;
	String dir;
	String empresa;
	String mail;
	String numero;
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	/*Constructores*/
	public Usuario(String nombre, String ape, String dir, String empresa, String mail, String numero) {
		super();
		this.nombre = nombre;
		this.ape = ape;
		this.dir = dir;
		this.empresa = empresa;
		this.mail = mail;
		this.numero = numero;
	}
	
	
	public Usuario() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", ape=" + ape + ", dir=" + dir + ", empresa=" + empresa + ", mail=" + mail
				+ ", numero=" + numero + "]";
	}
	
	
	
	
}
