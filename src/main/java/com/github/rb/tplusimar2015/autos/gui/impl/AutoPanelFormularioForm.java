package com.github.rb.tplusimar2015.autos.gui.impl;

import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import java.awt.GridLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class AutoPanelFormularioForm extends PanelFormularioForm {

    private final JTextField jtfPatente;
    private final JTextField jtfNumeroChasis;
    private final JTextField jtfNumeroMotor;
    private final JTextField jtfDescripcion;
    private final JComboBox<Cliente> jcbDni;
    private final JComboBox<Modelo> jcbModelo;

    public AutoPanelFormularioForm(ComboBoxModel<Cliente> modeloClientes,
            ComboBoxModel<Modelo> modeloModelos) {
        this.jtfPatente = new JTextField();
        this.jtfNumeroChasis = new JTextField();
        this.jtfNumeroMotor = new JTextField();
        this.jtfDescripcion = new JTextField();
        this.jcbDni = new JComboBox<>(modeloClientes);
        this.jcbModelo = new JComboBox<>(modeloModelos);
        this.armarPanel();
    }

    public AutoPanelFormularioForm(Auto auto,
            ComboBoxModel<Cliente> modeloClientes,
            ComboBoxModel<Modelo> modeloModelos) {

        this.jtfPatente = new JTextField();
        this.jtfPatente.setEnabled(false);
        this.jtfNumeroChasis = new JTextField();
        this.jtfNumeroMotor = new JTextField();
        this.jtfDescripcion = new JTextField();
        this.jcbDni = new JComboBox<>(modeloClientes);
        this.jcbModelo = new JComboBox<>(modeloModelos);

        this.cargarDatosIniciales(auto);
        this.armarPanel();
    }

    private void cargarDatosIniciales(Auto auto) {
        this.jtfPatente.setText(auto.getPatente());
        this.jtfDescripcion.setText(auto.getDescripcionParticular());
        this.jcbDni.setSelectedItem(auto.getCliente());
        this.jcbModelo.setSelectedItem(auto.getModelo());
        this.jtfNumeroChasis.setText(auto.getNumeroDeChasis());
        this.jtfNumeroMotor.setText(auto.getNumeroDeMotor());
    }

    private void armarPanel() {

        super.getContenedor().setLayout(new GridLayout(6, 2, 5, 5));
        super.getContenedor().add(new JLabel("Patente:"));
        super.getContenedor().add(jtfPatente);
        super.getContenedor().add(new JLabel("Numero de Chasis:"));
        super.getContenedor().add(jtfNumeroChasis);
        super.getContenedor().add(new JLabel("Numero de Motor:"));
        super.getContenedor().add(jtfNumeroMotor);
        super.getContenedor().add(new JLabel("Descripcion:"));
        super.getContenedor().add(jtfDescripcion);
        super.getContenedor().add(new JLabel("DNI:"));
        super.getContenedor().add(jcbDni);
        super.getContenedor().add(new JLabel("Modelo:"));
        super.getContenedor().add(jcbModelo);

        this.add(super.getContenedor());

    }

    public JTextField getJtfPatente() {
        return jtfPatente;
    }

    public JTextField getJtfNumeroChasis() {
        return jtfNumeroChasis;
    }

    public JTextField getJtfNumeroMotor() {
        return jtfNumeroMotor;
    }

    public JTextField getJtfDescripcion() {
        return jtfDescripcion;
    }

    public JComboBox<Cliente> getJcbDni() {
        return jcbDni;
    }

    public JComboBox<Modelo> getJcbModelo() {
        return jcbModelo;
    }

}
