package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado{
	
	private ArrayList<Maquina> maquina;

	public ArrayList<Maquina> getMaquina() {
		return maquina;
	}

	public void setMaquina(ArrayList<Maquina> maquina) {
		this.maquina = maquina;
	}

	public NegocioMejorado(ArrayList<Maquina> maquina) {
		this.maquina = new ArrayList<>();
	}
	
	public String generarCodigo() {
		int numeroAleatorio = (int)(Math.random() * 100) + 1;
		String idMaquina = "M-"+ numeroAleatorio;
		return idMaquina;
	}
	
	public String agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina maq = new Maquina(nombreCerveza, codigo, descripcion, precioPorMl);
		maquina.add(maq);
		return codigo;
	}

	
}
