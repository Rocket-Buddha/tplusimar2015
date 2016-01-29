package com.github.rb.tplusimar2015.core.pojo;

public abstract class Persona {

	private Integer dni;
	private String nombre;
	private String apellido;
	private String telefono;

	public Persona() {

	}

	public Persona(Integer dni, String nombre, String apellido, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Persona(Integer dni) {
		this.dni = dni;
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}