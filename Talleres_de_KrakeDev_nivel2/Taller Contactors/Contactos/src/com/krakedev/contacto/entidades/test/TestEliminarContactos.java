package com.krakedev.contacto.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestEliminarContactos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directorio dir = new Directorio();

		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		c1.setCelular("12343423413412");

		Contacto c2 = new Contacto();
		c2.setNombre("Juan");
		c2.setCelular("54637382463298");

		Contacto c3 = new Contacto();
		c3.setNombre("Carlos");
		c3.setCelular("13847005736234");

		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);

		boolean r1 = dir.eliminarContacto("12343423413412");
		System.out.println("Resultado de eliminar contacto 1: " + r1);
		System.out.println("Cantidad de contactos: " + dir.obtenerCantidadContactos());
		
		boolean r2 = dir.eliminarContacto("12343423413412");
		System.out.println("Resultado de eliminar contacto 1: " + r2);
		System.out.println("Cantidad de contactos: " + dir.obtenerCantidadContactos());
	}

}
