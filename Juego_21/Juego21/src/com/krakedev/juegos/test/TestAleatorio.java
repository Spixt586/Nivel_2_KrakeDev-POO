package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dealer dealer = new Dealer();
		
		for(int i = 0; i < 100 ; i++) {
			System.out.println(dealer.generarAleatorio(10));
		}
	}

}