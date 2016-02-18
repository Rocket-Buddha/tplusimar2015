package com.github.rb.tplusimar2015.core.pojo;

import java.util.Date;

public class Reparacion {

    private Integer numeroReparacion;
    private Vehiculo vehiculo;
    private Empleado mecanico;
    private Date fechaEntrada;
    private Double presupuesto;
    private String detalle;
    private Date fechaSalida;

    public Reparacion(Integer numeroReparacion,
            Vehiculo vehiculo,
            Empleado mecanico,
            Date fechaEntrada,
            Double presupuesto,
            String detalle,
            Date fechaSalida) {

        this.numeroReparacion = numeroReparacion;
        this.vehiculo = vehiculo;
        this.mecanico = mecanico;
        this.fechaEntrada = fechaEntrada;
        this.presupuesto = presupuesto;
        this.detalle = detalle;
        this.fechaSalida = fechaSalida;
    }

    public Reparacion(Vehiculo vehiculo,
            Date fechaEntrada) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
    }

    public Reparacion() {
    }

    public Integer getNumeroReparacion() {
        return numeroReparacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Empleado getMecanico() {
        return mecanico;
    }

    public void setNumeroReparacion(Integer numeroReparacion) {
        this.numeroReparacion = numeroReparacion;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setMecanico(Empleado mecanico) {
        this.mecanico = mecanico;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public String getDetalle() {
        return detalle;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

}
