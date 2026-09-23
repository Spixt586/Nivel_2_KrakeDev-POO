package com.krakedev.juegos.servicios;
import java.util.ArrayList;
import java.util.List;

import com.krakedev.juegos.entidades.Carta;

public class Dealer {
	
	private ArrayList<Carta> naipe;
	
	public Dealer() {
	    this.naipe = new ArrayList<Carta>();
	    generarNaipe();
	}

	public Dealer(ArrayList<Carta> naipe) {
	    this.naipe = naipe;
	    generarNaipe();
	}

	public ArrayList<Carta> getNaipe() {
		return naipe;
	}
	public void setNaipe(ArrayList<Carta> naipe) {
		this.naipe = naipe;
	}
	
	public void generarNaipe() {
		ArrayList<String> palos = new ArrayList<String>(List.of("T", "CN", "CR", "D"));
		ArrayList<String> numeros = new ArrayList<String>(List.of("A", "2", "3", "4", "5", "6" , "7", "8", "9", "10"));
			for(String palo: palos) {
				for(String numero: numeros) {
					Carta carta = new Carta();
					carta.setPalo(palo);
					carta.setValor(numero);
					
					naipe.add(carta);
				}
			}
	}
	
	public void imprim8irNaipe() {
		for(Carta carta: naipe) {
			carta.imprimir();
		}
	}
	
	public int generarAleatorio(int maximo){
		int aleatorio;
		
		aleatorio = (int)Math.random() * (maximo + 1);
				
		return aleatorio;
	}
	
	public Carta entregarCarta() {
		int aleatorio = generarAleatorio(naipe.size() - 1);
		Carta carta = naipe.get(aleatorio);
		naipe.remove(aleatorio);
		return carta;
	}
}
