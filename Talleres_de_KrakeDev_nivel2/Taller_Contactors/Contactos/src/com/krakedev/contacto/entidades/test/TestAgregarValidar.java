package com.krakedev.contacto.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestAgregarValidar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directorio dir = new Directorio();
		
		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		c1.setCelular("12343423413412");
		
		Contacto c2 = new Contacto();
		c2.setNombre("Juan");
		c2.setCelular("12343423413412");
		
		boolean r1 = dir.agregarContacto(c1);
		boolean r2 = dir.agregarContacto(c2);
		
		System.out.println("Agregado c1: " + r1);
		System.out.println("Agregado c2: " + r2);
		
		
		
	}

}
