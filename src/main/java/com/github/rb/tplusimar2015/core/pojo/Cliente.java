package com.github.rb.tplusimar2015.core.pojo;

import java.util.Collection;

public class Cliente extends Persona {

	private Collection<Vehiculo> lista;

	public Cliente() {

	}
	
	public Cliente(Integer dni) {
		
		super(dni);

	}
	
	public Cliente (Integer dni, String nombre, String apellido, String telefono){
		
		super(dni,nombre,apellido,telefono);
	}

	public Cliente(Collection<Vehiculo> lista) {
		this.lista = lista;
	}

	public Collection<Vehiculo> getLista() {
		return lista;
	}

	public void setLista(Collection<Vehiculo> lista) {
		this.lista = lista;
	}
	
	@Override
	public String toString() {
	    return super.getDni() +" - "+ super.getApellido() + ", " + super.getNombre();
	}

}