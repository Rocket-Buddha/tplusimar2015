package com.github.rb.tplusimar2015.modelos.gui.impl;

import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.pojo.Marca;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class ModeloPanelFormularioForm extends PanelFormularioForm {

    private final JTextField jtfNumero;
    private final JTextField jtfNombre;
    private final JTextField jtfDescripcion;
    private final JComboBox<Marca> jcbMarca;

    public ModeloPanelFormularioForm() {

        this.jtfNumero = new JTextField(10);
        jtfNumero.setEnabled(false);
        this.jtfNombre = new JTextField(10);
        this.jtfDescripcion = new JTextField(10);
        this.jcbMarca = new JComboBox<>(Marca.values());

        this.armarPanel();

    }

    public ModeloPanelFormularioForm(Modelo modelo) {

        this.jtfNumero = new JTextField(10);
        jtfNumero.setEnabled(false);
        this.jtfNombre = new JTextField(10);
        this.jtfDescripcion = new JTextField(10);
        this.jcbMarca = new JComboBox<>(Marca.values());

        this.cargarDatosIniciales(modelo);
        this.armarPanel();
    }

    private void cargarDatosIniciales(Modelo modelo) {

        this.jtfNumero
                .setText(modelo.getN_modelo()
                        .toString());
        this.jtfNombre.setText(modelo.getNombre());
        this.jtfDescripcion.setText(modelo.getDescripcion());
        this.jcbMarca.setSelectedItem(modelo.getMarca());
    }

    private void armarPanel() {

        super.getContenedor()
                .setLayout(new GridLayout(4, 2, 5, 5));

        super.getContenedor()
                .add(new JLabel("Numero:"));
        super.getContenedor()
                .add(jtfNumero);
        super.getContenedor()
                .add(new JLabel("Nombre:"));
        super.getContenedor()
                .add(jtfNombre);
        super.getContenedor()
                .add(new JLabel("Descripcion:"));
        super.getContenedor()
                .add(jtfDescripcion);
        super.getContenedor()
                .add(new JLabel("Marca:"));
        super.getContenedor()
                .add(jcbMarca);

        this.add(super.getContenedor());
    }

    public JTextField getJtfNumero() {
        return jtfNumero;
    }

    public JTextField getJtfNombre() {
        return jtfNombre;
    }

    public JTextField getJtfDescripcion() {
        return jtfDescripcion;
    }

    public JComboBox<Marca> getJcbMarca() {
        return jcbMarca;
    }
}
