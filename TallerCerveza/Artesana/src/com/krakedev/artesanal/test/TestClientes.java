package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		
		NegocioMejorado nMejorado = new NegocioMejorado();
		nMejorado.registrarCliente("Jose", "1762437485");
		System.out.println(nMejorado);

	}

}
