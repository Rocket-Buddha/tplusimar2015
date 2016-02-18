package com.github.rb.tplusimar2015.core.pojo;

public class Auto extends Vehiculo {

    public Auto() {

    }

    @Override
    public String toString() {
        return super.getPatente()
                + " "
                + super.getModelo()
                .getNombre();
    }

}
