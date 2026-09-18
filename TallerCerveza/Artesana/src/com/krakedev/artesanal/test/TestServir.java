package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {

		Maquina rubia = new Maquina("Pilsener", "09437", "Cerveza rubia", 0.02, 10000);

		System.out.println("----------RECARGA UNO----------");
		rubia.imprimir();
		System.out.println("----------LLENANDO MAQUINA----------");
		rubia.llenarMaquina();
		rubia.imprimir();
		System.out.println("----------SERVIR MIL ML----------");

		double valor;
		valor = rubia.servirCerveza(1000);

		System.out.println("Valor a pagar: " + valor);
		rubia.imprimir();
		System.out.println("----------SERVIR DOS ML----------");

		valor = rubia.servirCerveza(2000);
		System.out.println("Valor a pagar: " + valor);
		rubia.imprimir();
		System.out.println("----------SERVIR SEIS ML----------");

		valor = rubia.servirCerveza(6000);
		System.out.println("Valor a pagar: " + valor);
		rubia.imprimir();
	}

}
