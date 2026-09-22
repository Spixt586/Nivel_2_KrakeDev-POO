package com.krakedev.contacto.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directorio dir = new Directorio();
		
		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		
		Contacto c2 = new Contacto();
		c2.setNombre("Juan");
		
		Contacto c3 = new Contacto();
		c3.setNombre("Carlos");
		
		Contacto c4 = new Contacto();
		c4.setNombre("Javier");
		
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		dir.agregarContacto(c4);
		
		dir.imprimirContactos();
	}

}
