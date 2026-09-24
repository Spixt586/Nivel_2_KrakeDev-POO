package com.biblioteca;

import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Libro> libros;
	
	//Constructor vacio
	public Biblioteca() {
		this.libros = new ArrayList<Libro>(); 
	}
	public Biblioteca(ArrayList<Libro> libros) {
		this.libros = libros;
	
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	//Metodo agregar libro
	public void agregarLibro(Libro libro) {
		if (libro == null) {
			System.out.println("Libro no es valido para ingresar");
			return;
		}
		
		if (libro.getId() <= 0) {
			libro.setId(libros.size()+1);
		}
		
		libros.add(libro);
		
	}
	
	// Metodo eliminar libro
	
	public void eliminarLibro(Libro libro) {
		
		int indice = obtenerIndice(libro);
		
		if (indice == -1) {
			System.out.println("No exite libro para eliminar");
			
			// Return se usa para indicar al metodo el fin de su ejecución
			return;
		}
		
		libros.remove(indice);
	}
	
	public Libro eliminarLibro(int indice) {
		Libro libro = null;

		if (indice < 0 || indice >= libros.size()) {
			System.out.println("Indice no es correcto");
			
			// Return se usa para indicar al metodo el fin de su ejecución
			return libro;
		}
		
		libro = libros.get(indice);
		
		libros.remove(indice);
		
		return libro;
	}
	
	public int obtenerIndice(Libro libro) {
		int indice = -1;
		
		if (libro == null) {
			return indice;
		}
		
		for (int i = 0; i<libros.size(); i++) {
			if (libros.get(i).getId() == libro.getId()) {
				indice = i;
				
				// rompe el for, ya no recorre el arreglo - Lista
				break;
			}
		}
		
		return indice;
	}
	
	
	//Metodo prestar libro
	public void prestarLibro(Libro libro, Usuario usuario) {
		
		if(usuario.getLibrosPrestados().size()>3) {
			System.out.println("NO PUEDES PEDIR MAS DE 3");
			return;
		}
		
		for(int i = 0; i<libros.size(); i++) {
			
			if(libros.get(i).getId()==libro.getId()) {
				if(libros.get(i).isPrestado()) {
					System.out.println("Lo sentimos no se puede prestar");
					return;
				}
				libros.get(i).prestar();
				usuario.tomarLibro(libro);
			}
		}
	}
	//Metodo buscar por ID
	public Libro buscarPorId(int id) {
		for(Libro libro : libros) {
		if(libro.getId()== id) {
			return libro;
		}
	}
		return null;
	}
	//Metodo buscar por titulo
	public Libro buscarPorTitulo(String titulo) { //metodo tipo libro indica que recibimos un dato y devolvemos 1 unico objeto
		for(Libro libro : libros) {
			if(libro.getTitulo().equalsIgnoreCase(titulo)) { 
				return libro;
			}
		}return null;
	}
	//Metodo mostrar libros 
	public void mostrarLibrosDisponibles() {
		for(Libro libro : libros) {
			if(!libro.isPrestado()) {
				System.out.println(libro);
			}else {
				System.out.println("Libro no disponible");
			}
		}
	}
	
	//Metodo buscar por autor
	public void buscarPorAutor(String nombreAutor) {   		//aqui se usa el void porque queremos una respuesta general no algo especifico
		boolean encontrado = false;
		for(Libro libro : libros) {
			if(libro.getAutor().equalsIgnoreCase(nombreAutor)) {
				System.out.println(libro);
				encontrado = true;
			}
		}if(!encontrado) {
			System.out.println("No se encontraron libros de este AUTOR");
		}
	}
	
	//Metodo buscar por precio MAXIMO
	public void buscarPrecioMaximo(double precioMaximo) {
		boolean encontrado = false;
		for(Libro libro : libros) {
			if(libro.getPrecio() <= precioMaximo) {
				System.out.println(libro);
				encontrado = true;
			}
		}if(!encontrado) {
			System.out.println("No se encontraron libros dentro de ese precio");
		}
	}
	
	//Metodo buscar por precio MINIMO
	public void buscarPrecioMinimo(double precioMinimo) {
		boolean encontrado = false;
		for(Libro libro : libros) {
			if(libro.getPrecio() >= precioMinimo) {
				System.out.println(libro);
				encontrado = true;
			}if(!encontrado) {
				System.out.println("No se encontraron libros menores al precio deseado");
			}
		}
		
	}
	
	public ArrayList<Libro> buscarPorCadena(String cadena) {
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		for (Libro libro: libros) {
			// tolowerCase tranforma todo el string a minusculas
			if (libro.getAutor().toLowerCase().contains(cadena.toLowerCase())) {
				// llenar lista
				lista.add(libro);
			}
		}
		
		// size() == 0 o isEmpty
		if (lista.isEmpty()) {
			System.out.println("No hay resultados");
		}
		
		
		return lista;
	}
	
	}
