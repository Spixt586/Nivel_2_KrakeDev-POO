package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina("Pilsener", "09437", "Cerveza rubia", 0.02, 10000);
		
		rubia.imprimir();
		
		rubia.llenarMaquina();
		
		rubia.imprimir();
		
		Maquina negra = new Maquina("Club", "07383", "Cerveza buena", 0.03);
		
		negra.imprimir();
		
		negra.llenarMaquina();
		
		negra.imprimir();
	}

}
