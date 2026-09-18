package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado{
	
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private int ultimoCodigo = 100;

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}

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
	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre, cedula);
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
		clientes.add(cliente);
	}
	public Cliente buscarClientePorCedula(String cedula) {
		for(Cliente cliente: clientes) {
			 if(cliente.getCedula().equals(cedula)) {
				 return cliente;
			 }
		}
		return null;
	}
	public Cliente buscarClientePorCodigo(int codigo) {
		for(Cliente cliente: clientes) {
			if(cliente.getCodigo() == codigo) {
				return cliente;
			}
		}
		return null;
	}
	
	public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
		Maquina maquina = recuperarMaquina(codigoMaquina);
		Cliente cliente = buscarClientePorCodigo(codigoCliente);
		if(maquina != null && cliente != null) {
			double servido = maquina.servirCerveza(cantidad);
			double total = cliente.getTotalConsumido() + servido;
			cliente.setTotalConsumido(total);
		}
		
	}
	
	public void imprimir() {
		System.out.println("Hola mundo");
	}
}
