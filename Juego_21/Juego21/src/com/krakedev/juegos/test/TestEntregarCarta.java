package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestEntregarCarta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dealer dealer = new Dealer();
		for(int i = 0; i < 52 ; i++) {
			dealer.entregarCarta().imprimir();
			dealer.getNaipe().size();
		}
	}

}
