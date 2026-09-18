package com.krakedev.artesanal;

public class Maquina {
	
	private String nombreCerveza;
	private String codigo;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;

	public Maquina(String nombreCerveza, String codigo, String descripcion, double precioPorMl, double capacidadMaxima) {
		this.nombreCerveza = nombreCerveza;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;}
	
	public Maquina(String nombreCerveza, String codigo, String descripcion, double precioPorMl) {
		this.nombreCerveza = nombreCerveza;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;}
	

	public String getCodigo() {
		return codigo;
	}

	
	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(double capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void imprimir() {
		String mensaje;

		mensaje = "Nombre de Cerveza: " + nombreCerveza + "Código de cerveza: "+ codigo +", Descripción: " + descripcion + ", Précio por ml: "
				+ precioPorMl + ", Capacidad Máxima: " + capacidadMaxima + ", Cantidad Actual: " + cantidadActual;

		System.out.println(mensaje);
	}
	
	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima - 100;
	}
	
	public boolean recargarCerveza(double cantidad) {
		
		double limitePermitido;
		limitePermitido = capacidadMaxima - 100;
		
		if(cantidadActual + cantidad <= limitePermitido) {
			
			cantidadActual = cantidadActual + cantidad;
			return true;
		}else{
			return false;
		}
		
	}
	
	public double servirCerveza(double cantidad) {
		if(cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad;
			
			double valor;
			valor = cantidad * precioPorMl;
			
			return valor;
		}else {
			return 0;
		}
	}

}
