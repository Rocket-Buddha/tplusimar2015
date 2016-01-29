package com.github.rb.tplusimar2015.core.pojo;

public class Empleado extends Persona {

	private Integer legajo;
	private String direccion;
        private Senority senority;
        private Rol rol;

    public Empleado(Integer legajo, String direccion, Senority senority, Rol rol) {
        this.legajo = legajo;
        this.direccion = direccion;
        this.senority = senority;
        this.rol = rol;
    }

    public Empleado(Integer legajo, String direccion, Senority senority, Rol rol, Integer dni, String nombre, String apellido, String telefono) {
        super(dni, nombre, apellido, telefono);
        this.legajo = legajo;
        this.direccion = direccion;
        this.senority = senority;
        this.rol = rol;
    }

    public Empleado(Integer legajo, String direccion, Senority senority, Rol rol, Integer dni) {
        super(dni);
        this.legajo = legajo;
        this.direccion = direccion;
        this.senority = senority;
        this.rol = rol;
    }

    public Empleado() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getLegajo() {
        return legajo;
    }

    public String getDireccion() {
        return direccion;
    }

    public Senority getSenority() {
        return senority;
    }

    public Rol getRol() {
        return rol;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSenority(Senority senority) {
        this.senority = senority;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
        
        

}