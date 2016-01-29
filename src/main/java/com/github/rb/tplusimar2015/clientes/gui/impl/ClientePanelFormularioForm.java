package com.github.rb.tplusimar2015.clientes.gui.impl;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;

public class ClientePanelFormularioForm extends PanelFormularioForm {

    /**
     *
     */
    private JTextField jtfDni;
    private JTextField jtfNombre;
    private JTextField jtfApellido;
    private JTextField jtfTelefono;

    public ClientePanelFormularioForm() {

        super();

        this.jtfDni = new JTextField(10);
        this.jtfNombre = new JTextField(10);
        this.jtfApellido = new JTextField(10);
        this.jtfTelefono = new JTextField(10);

        this.armarPanel();

    }

    public ClientePanelFormularioForm(Cliente cliente) {

        super();
        this.jtfDni = new JTextField();
        this.jtfDni.setEnabled(false);
        this.jtfNombre = new JTextField();
        this.jtfApellido = new JTextField();
        this.jtfTelefono = new JTextField();

        this.cargarDatosIniciales(cliente);
        this.armarPanel();
    }

    private void cargarDatosIniciales(Cliente cliente) {

        this.jtfDni.setText(String.valueOf(cliente.getDni()));
        this.jtfNombre.setText(cliente.getNombre());
        this.jtfApellido.setText(cliente.getApellido());
        this.jtfTelefono.setText(cliente.getTelefono());

    }

    private void armarPanel() {

        //Cantidad de filas, cantidad de columnas, gap horizontal, gap vertical
        super.getContenedor().setLayout(new GridLayout(4, 2, 5, 5));

        super.getContenedor().add(new JLabel("DNI:"));
        super.getContenedor().add(jtfDni);
        super.getContenedor().add(new JLabel("Nombre:"));
        super.getContenedor().add(jtfNombre);
        super.getContenedor().add(new JLabel("Apellido:"));
        super.getContenedor().add(jtfApellido);
        super.getContenedor().add(new JLabel("Telefono:"));
        super.getContenedor().add(jtfTelefono);

        this.add(super.getContenedor());

    }

    public JTextField getJtfDni() {
        return jtfDni;
    }

    public void setJtfDni(JTextField jtfDni) {
        this.jtfDni = jtfDni;
    }

    public JTextField getJtfNombre() {
        return jtfNombre;
    }

    public void setJtfNombre(JTextField jtfNombre) {
        this.jtfNombre = jtfNombre;
    }

    public JTextField getJtfApellido() {
        return jtfApellido;
    }

    public void setJtfApellido(JTextField jtfApellido) {
        this.jtfApellido = jtfApellido;
    }

    public JTextField getJtfTelefono() {
        return jtfTelefono;
    }

    public void setJtfTelefono(JTextField jtfTelefono) {
        this.jtfTelefono = jtfTelefono;
    }

}
