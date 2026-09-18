package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina("Pilsener", "09437", "Cerveza rubia", 0.02, 10000);
		
		rubia.imprimir();
		
		rubia.setNombreCerveza("Golden Ale");
		rubia.setDescripcion("Cerveza con aroma más intenso");
		
		rubia.imprimir();
	}

}
