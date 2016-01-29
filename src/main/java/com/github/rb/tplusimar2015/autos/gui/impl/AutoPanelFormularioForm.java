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

    private JTextField jtfPatente;
    private JTextField jtfNumeroChasis;
    private JTextField jtfNumeroMotor;
    private JTextField jtfDescripcion;
    private JComboBox<Cliente> jcbDni;
    private JComboBox<Modelo> jcbModelo;

    public AutoPanelFormularioForm(ComboBoxModel<Cliente> modeloClientes, ComboBoxModel<Modelo> modeloModelos) {

        super();
        this.jtfPatente = new JTextField();
        this.jtfNumeroChasis = new JTextField();
        this.jtfNumeroMotor = new JTextField();
        this.jtfDescripcion = new JTextField();
        this.jcbDni = new JComboBox<>(modeloClientes);
        this.jcbModelo = new JComboBox<>(modeloModelos);

        this.armarPanel();

    }

    public AutoPanelFormularioForm(Auto auto, ComboBoxModel<Cliente> modeloClientes, ComboBoxModel<Modelo> modeloModelos) {

        super();
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

//    public void setJtfPatente(JTextField jtfPatente) {
//        this.jtfPatente = jtfPatente;
//    }

    public JTextField getJtfNumeroChasis() {
        return jtfNumeroChasis;
    }

//    public void setJtfNumeroChasis(JTextField jtfNumeroChasis) {
//        this.jtfNumeroChasis = jtfNumeroChasis;
//    }

    public JTextField getJtfNumeroMotor() {
        return jtfNumeroMotor;
    }

//    public void setJtfNumeroMotor(JTextField jtfNumeroMotor) {
//        this.jtfNumeroMotor = jtfNumeroMotor;
//    }

    public JTextField getJtfDescripcion() {
        return jtfDescripcion;
    }

//    public void setJtfDescripcion(JTextField jtfDescripcion) {
//        this.jtfDescripcion = jtfDescripcion;
//    }

    public JComboBox<Cliente> getJcbDni() {
        return jcbDni;
    }

//    public void setJcbDni(JComboBox<Cliente> jcbDni) {
//        this.jcbDni = jcbDni;
//    }

    public JComboBox<Modelo> getJcbModelo() {
        return jcbModelo;
    }

//    public void setJcbModelo(JComboBox<Modelo> jcbModelo) {
//        this.jcbModelo = jcbModelo;
//    }

}
