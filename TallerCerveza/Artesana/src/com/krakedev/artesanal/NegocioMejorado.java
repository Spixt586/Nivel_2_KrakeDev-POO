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
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina maquinaExistente = recuperarMaquina(codigo);
		if(maquinaExistente != null) {
			return false;
		}
		Maquina maq = new Maquina(nombreCerveza, codigo, descripcion, precioPorMl);
		maquinas.add(maq);
		return true;
	}
	public void cargarMaquinas() {
		
		//For-each para tener un código más limpio
		for(Maquina maquina : maquinas) {
			maquina.llenarMaquina();
		}
		/*
		 * Este for es el tradicional el cual se puede usar
		 * 
		for(int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			maquina.llenarMaquina();
		}*/
	}
	
	public Maquina recuperarMaquina(String codigo) {
		for(Maquina maquina: maquinas) {
			if(maquina.getCodigo().equals(codigo)) {
				return maquina;
			}
		}
		return null;
	}
}
