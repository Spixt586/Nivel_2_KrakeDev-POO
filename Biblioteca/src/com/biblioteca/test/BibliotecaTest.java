package com.biblioteca.test;

import com.biblioteca.Biblioteca;
import com.biblioteca.Libro;
import com.biblioteca.Usuario;

public class BibliotecaTest {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		System.out.println(biblioteca.getLibros());
		
		Libro libro1 = new Libro(1,"JJ Benites", "Harry Potter", "Aventura", 1997, 12.00);
		
		Usuario usuario1 = new Usuario("Addonys", "Herrera" , "1723879662", 1);
		
		System.out.println(usuario1);
		
		biblioteca.agregarLibro(libro1);
		System.out.println(biblioteca.getLibros());
		
		biblioteca.prestarLibro(libro1, usuario1);
		System.out.println(biblioteca.getLibros());
		System.out.println(usuario1);
		
		Libro libro2 = new Libro(2,"Brandon Leon", "1984", "Politica", 1949, 29.99);
		biblioteca.agregarLibro(libro2);
		System.out.println(biblioteca.getLibros());
		System.out.println("Ejercicio 2 \n");
		//biblioteca.prestarLibro(libro2, usuario1);  //comentamos la linea para que se muestre en los libros prestados
		System.out.println(usuario1);
		
		//mandar capturar error mas de 3 libros prestados
		Libro libro3 = new Libro(3, "Jane Austen", "Orgullo y Prejuicio", "Romance",1813, 26.50);
		biblioteca.agregarLibro(libro3);
		System.out.println(biblioteca.getLibros());
		
		Libro libro4 = new Libro(4, "José Saramago", "Ensayo sobre la ceguera", "Novela", 1995, 80.50);
		biblioteca.agregarLibro(libro4);
		System.out.println(biblioteca.getLibros());
		
		biblioteca.prestarLibro(libro3, usuario1);
		System.out.println(usuario1);
		
		biblioteca.prestarLibro(libro4, usuario1);
		System.out.println(usuario1);
		
		//Test probar
		Libro encontrado = biblioteca.buscarPorId(10);
		System.out.println("\n Ejercicio 3 \n");
		if(encontrado != null) {
			System.out.println(encontrado.getAutor());
		}else {
			System.out.println("Libro no encontrado");
		}
		//Test buscar titulo
		Libro libroEncontrado = biblioteca.buscarPorTitulo("frs");
		System.out.println("\n Ejercicio 4 \n");
		if(libroEncontrado != null ) {
			System.out.println(libroEncontrado.getAutor());
		}else {
			System.out.println("Libro no encontrado");
		}
		
		//Test probar visualizacion arreglo libros prestados
		System.out.println("\n Ejercicio 5 \n");
		biblioteca.mostrarLibrosDisponibles();
		
		//Test probar buscar por autor
		biblioteca.buscarPorAutor("josé saramago");
		
		//Test probar buscar precio maximo
		System.out.println("\n Ejercicio 6 \n");
		biblioteca.buscarPrecioMaximo(10);
		
		//Test probar buscar precio minimo
		System.out.println("\n Ejercicio 7 \n");
		biblioteca.buscarPrecioMinimo(90);
	}

}
