package com.github.rb.tplusimar2015.core.pojo;



public abstract class Vehiculo {

	private String patente;
	private String numeroDeChasis;
	private String numeroDeMotor;
	private String descripcionParticular;
	private Cliente cliente;
	private Modelo modelo;

	public Vehiculo() {

	}

	public Vehiculo(String patente, String numeroDeChasis,
			String numeroDeMotor, String descripcionParticular,
			Cliente cliente, Modelo modelo) {
		this.patente = patente;
		this.numeroDeChasis = numeroDeChasis;
		this.numeroDeMotor = numeroDeMotor;
		this.descripcionParticular = descripcionParticular;
		this.cliente = cliente;
		this.modelo = modelo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getNumeroDeChasis() {
		return numeroDeChasis;
	}

	public void setNumeroDeChasis(String numeroDeChasis) {
		this.numeroDeChasis = numeroDeChasis;
	}

	public String getNumeroDeMotor() {
		return numeroDeMotor;
	}

	public void setNumeroDeMotor(String numeroDeMotor) {
		this.numeroDeMotor = numeroDeMotor;
	}

	public String getDescripcionParticular() {
		return descripcionParticular;
	}

	public void setDescripcionParticular(String descripcionParticular) {
		this.descripcionParticular = descripcionParticular;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}



}