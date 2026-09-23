package com.krakedev.juegos.test;

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
		juego21.repartirRonda();
		
		for(Jugador jugador : juego21.getJugadores()) {
			jugador.imprimir();
		}
	}

}
