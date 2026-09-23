package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Juego21 juego21 = new Juego21();
		
		juego21.agregarJugador(new Jugador("Francisco"));
		juego21.agregarJugador(new Jugador("Karen"));
		juego21.agregarJugador(new Jugador("Andrés"));
		
		juego21.inicializar();
		
		ArrayList<Jugador> ganadores = juego21.jugar();
		
		for(Jugador jugador : ganadores) {
			jugador.imprimir();
		}
		System.out.println(juego21.getDealer().getNaipe().size());
	}

}
