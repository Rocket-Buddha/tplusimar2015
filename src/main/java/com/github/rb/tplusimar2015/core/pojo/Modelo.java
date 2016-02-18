package com.github.rb.tplusimar2015.core.pojo;

public class Modelo {

    private Integer n_modelo;
    private String nombre;
    private String descripcion;
    private Marca marca;

    public Modelo() {

    }

    public Modelo(Integer n_modelo, String nombre, String descripcion,
            Marca marca) {
        this.n_modelo = n_modelo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public Modelo(String nombre, 
            String descripcion,
            Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public Integer getN_modelo() {
        return n_modelo;
    }

    public void setN_modelo(Integer n_modelo) {
        this.n_modelo = n_modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return this.getMarca().getNombre() + " - " + this.getNombre();
    }
}
