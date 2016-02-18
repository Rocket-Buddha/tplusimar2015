package com.github.rb.tplusimar2015.core.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class PanelBotoneraForm extends JPanel {

    private final JButton jbAceptar;
    private final JButton jbCancelar;

    public PanelBotoneraForm() {

        this.jbAceptar = new JButton("Aceptar");
        this.jbCancelar = new JButton("Cancelar");

        this.armarPanel();

    }

    private void armarPanel() {

        this.setLayout(new FlowLayout());
        this.add(jbAceptar);
        this.add(jbCancelar);
    }

    public final JButton getJbAceptar() {
        return jbAceptar;
    }

    public final JButton getJbCancelar() {
        return jbCancelar;
    }

}
