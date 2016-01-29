package com.github.rb.tplusimar2015.core.pojo;

public class Tareas {

	private Integer numeroDeTarea;
	private String nombreDeTarea;
	private String descripcionDeTarea;
	private Double costo;

	public Tareas() {

	}

	public Tareas(Integer numeroDeTarea, String nombreDeTarea,
			String descripcionDeTarea, Double costo) {
		this.numeroDeTarea = numeroDeTarea;
		this.nombreDeTarea = nombreDeTarea;
		this.descripcionDeTarea = descripcionDeTarea;
		this.costo = costo;
	}

	public Integer getNumeroDeTarea() {
		return numeroDeTarea;
	}

	public void setNumeroDeTarea(Integer numeroDeTarea) {
		this.numeroDeTarea = numeroDeTarea;
	}

	public String getNombreDeTarea() {
		return nombreDeTarea;
	}

	public void setNombreDeTarea(String nombreDeTarea) {
		this.nombreDeTarea = nombreDeTarea;
	}

	public String getDescripcionDeTarea() {
		return descripcionDeTarea;
	}

	public void setDescripcionDeTarea(String descripcionDeTarea) {
		this.descripcionDeTarea = descripcionDeTarea;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

}