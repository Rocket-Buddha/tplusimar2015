package com.github.rb.tplusimar2015.core.pojo;

public class Respuesto {

	private Integer numeroDeInventario;
	private String nombre;
	private String descripccion;
	private String costo;
	private Reparacion Reparacion = null;

	public Respuesto() {

	}

	public Respuesto(Integer numeroDeInventario, String nombre,
			String descripccion, String costo) {
		this.numeroDeInventario = numeroDeInventario;
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.costo = costo;
	}

	public Integer getNumeroDeInventario() {
		return numeroDeInventario;
	}

	public void setNumeroDeInventario(Integer numeroDeInventario) {
		this.numeroDeInventario = numeroDeInventario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripccion() {
		return descripccion;
	}

	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public Reparacion getReparacion() {
		return Reparacion;
	}

	public void setReparacion(Reparacion reparacion) {
		Reparacion = reparacion;
	}

}