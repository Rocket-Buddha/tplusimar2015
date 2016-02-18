package com.github.rb.tplusimar2015.core.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class PanelBotoneraList extends JPanel {

    private final JButton jbAlta;
    private final JButton jbActualizar;
    private final JButton jbEliminar;

    public PanelBotoneraList() {

        this.jbAlta = new JButton("Alta");
        this.jbActualizar = new JButton("Actualizar");
        this.jbEliminar = new JButton("Eliminar");

        this.armarPanel();
    }

    private void armarPanel() {

        this.setLayout(new FlowLayout());
        this.add(jbAlta);
        this.add(jbActualizar);
        this.add(jbEliminar);
    }

    public final JButton getJbAlta() {
        return jbAlta;
    }

    public final JButton getJbActualizar() {
        return jbActualizar;
    }

    public final JButton getJbEliminar() {
        return jbEliminar;
    }

}
