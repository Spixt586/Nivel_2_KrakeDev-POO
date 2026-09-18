package com.krakedev.artesanal.test.Negocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {

	public static void main(String[] args) {
		
		Maquina nueva = new Maquina("Cerveza club", "023123", "cerveza fría", 0.02, 8000);
		Negocio negocio1 = new Negocio("Mi negocio", nueva);
		
		System.out.println("Nombre: " + negocio1.getNombre());
		System.out.println("Máquina: " + negocio1.getMaquinaA());
		
		Maquina m1 = negocio1.getMaquinaA();
		double capacidad = m1.getCapacidadMaxima();
	}

}
