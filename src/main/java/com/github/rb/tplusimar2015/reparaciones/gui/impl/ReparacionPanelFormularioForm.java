package com.github.rb.tplusimar2015.reparaciones.gui.impl;

import com.github.rb.tplusimar2015.core.pojo.Reparacion;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.core.pojo.Vehiculo;
import java.awt.GridLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class ReparacionPanelFormularioForm extends PanelFormularioForm {

    private JTextField jtfnumeroReparacion;
    private JComboBox<Vehiculo> jcbVehiculo;
    private JComboBox<Empleado> jcbMecanico;
    private JTextField jtfPresupuesto;
    private JTextField jtfDetalle;

    public ReparacionPanelFormularioForm(ComboBoxModel<Vehiculo> modeloVehiculos,
            ComboBoxModel<Empleado> modeloEmpleados,
            ReparacionSoportePanel.Tipo tipo,
            Reparacion reparacion) {

        switch (tipo) {
            case ALTA:
                this.jcbVehiculo = new JComboBox<>(modeloVehiculos);
                super.getContenedor().setLayout(new GridLayout(1, 2, 5, 5));
                super.getContenedor().add(new JLabel("Auto:"));
                super.getContenedor().add(this.jcbVehiculo);
                break;

            case ASIGNARMEC:

                this.jtfnumeroReparacion = new JTextField();
                this.jtfnumeroReparacion.setText(reparacion.getNumeroReparacion()
                        .toString());
                this.jtfnumeroReparacion.setEnabled(false);

                this.jcbMecanico = new JComboBox<>(modeloEmpleados);

                super.getContenedor().setLayout(new GridLayout(2, 2, 5, 5));
                super.getContenedor().add(new JLabel("NºReparacion"));
                super.getContenedor().add(this.jtfnumeroReparacion);
                super.getContenedor().add(new JLabel("Mecanico:"));
                super.getContenedor().add(this.jcbMecanico);
                break;

            case PRESUPUESTAR:

                this.jtfnumeroReparacion = new JTextField();
                this.jtfnumeroReparacion.setText(reparacion.getNumeroReparacion()
                        .toString());
                this.jtfnumeroReparacion.setEnabled(false);

                this.jtfPresupuesto = new JTextField();

                super.getContenedor().setLayout(new GridLayout(2, 2, 5, 5));
                super.getContenedor().add(new JLabel("NºReparacion"));
                super.getContenedor().add(this.jtfnumeroReparacion);

                super.getContenedor().add(new JLabel("Presupuesto"));
                super.getContenedor().add(this.jtfPresupuesto);
                break;

            case ENTREGAR:
                this.jtfnumeroReparacion = new JTextField();
                this.jtfnumeroReparacion.setText(reparacion.getNumeroReparacion()
                        .toString());
                this.jtfnumeroReparacion.setEnabled(false);
                this.jtfDetalle = new JTextField();

                super.getContenedor().setLayout(new GridLayout(1, 2, 5, 5));
                super.getContenedor().add(new JLabel("NºReparacion"));
                super.getContenedor().add(this.jtfnumeroReparacion);

                super.getContenedor().add(new JLabel("Detalle"));
                super.getContenedor().add(this.jtfDetalle);
                break;
            default:
                throw new AssertionError(tipo.name());
        }

        super.add(super.getContenedor());
    }

    public JTextField getJtfnumeroReparacion() {
        return jtfnumeroReparacion;
    }

    public JComboBox<Vehiculo> getJcbVehiculo() {
        return jcbVehiculo;
    }

    public JComboBox<Empleado> getJcbMecanico() {
        return jcbMecanico;
    }

    public JTextField getJtfPresupuesto() {
        return jtfPresupuesto;
    }

    public JTextField getJtfDetalle() {
        return jtfDetalle;
    }
}
