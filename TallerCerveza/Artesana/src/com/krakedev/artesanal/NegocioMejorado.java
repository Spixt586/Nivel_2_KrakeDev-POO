package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado{
	
	private ArrayList<Maquina> maquinas;

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public NegocioMejorado() {
		this.maquinas = new ArrayList<>();
	}
	
	public String generarCodigo() {
		int numeroAleatorio = (int)(Math.random() * 100) + 1;
		String idMaquina = "M-"+ numeroAleatorio;
		return idMaquina;
	}
	
	public String agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina maq = new Maquina(nombreCerveza, codigo, descripcion, precioPorMl);
		maquinas.add(maq);
		return codigo;
	}
	public void metodoDeVerificación() {
		System.out.println("Si este método fue detectado como una modificación en git, ya funciona correctamente el programa git bash");
	}
}
