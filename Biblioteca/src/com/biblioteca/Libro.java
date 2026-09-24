package com.biblioteca;

public class Libro {
	private int id;
	private String autor;
	private String genero;
	private String titulo;
	private int anio;
	private String isbn; 
	private String editorial;
	private double precio;
	private boolean prestado;
	
	
	//Constructor vacio
		public Libro() {
			
		}
		
	//Constructor
	public Libro(int id,String autor, String titulo, String genero, int anio, double precio) {
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.anio = anio;	
		this.prestado = false;
		this.precio= precio;
	}

	public Libro(String autor, String titulo, String genero, int anio, double precio) {
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.anio = anio;	
		this.prestado = false;
		this.precio= precio;
	}
	
	//Getters and Setters
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean isPrestado() {
		return prestado;
	}
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	//Metodo prestar
	public void prestar() {
		prestado = true;
	}
	
	//Metodo devolver libro
	public void devolverLibro() {
		if(prestado == true) {
			prestado = false;
			System.out.println("libro devuelto");
		}else{
			System.out.println("libro NO se encuentra prestado");
		}
	}
	
	
//Metodo toString
	
	

	public void imprimir() {
		System.out.println("titulo= "+titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", genero=" + genero + ", titulo=" + titulo + ", anio=" + anio
				+ ", prestado=" + prestado + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
