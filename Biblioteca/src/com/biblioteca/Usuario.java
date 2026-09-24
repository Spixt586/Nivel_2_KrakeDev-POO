package com.biblioteca;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String apellido;
	private String cedula;
	private int idUsuario;

	private ArrayList<Libro> librosPrestados;
	
	//Constructor vacio
	
	public Usuario() {
		this.librosPrestados = new ArrayList<Libro>(); 
	} 
	//Constructor inicializado
	
	public Usuario(String nombre, String apellido, String cedula, int idUsuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.idUsuario = idUsuario;
		this.librosPrestados = new ArrayList<Libro>();
	}
	
	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	//Crear metodo SALUDAR
	//Metodo tomar libro
	public void tomarLibro(Libro libro) {
		librosPrestados.add(libro);
	}
	//Metodo toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", idUsuario="
				+ idUsuario + ", \n librosPrestados=" + librosPrestados + "]";
	}

	//Metodo devolver libro
	public void devolverLibro(Libro libro) {
		librosPrestados.remove(libro);
	}
	
	//Metodo 
	
}
