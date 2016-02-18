package com.github.rb.tplusimar2015.reparaciones.gui.impl;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public final class ReparacionPanelBotoneraList extends JPanel {

    private final JButton jbAlta;
    private final JButton jbAsignarMecanico;
    private final JButton jbPresupuestar;
    private final JButton jbEntregar;

    public ReparacionPanelBotoneraList() {
        
        this.jbAlta = new JButton("Alta");
        this.jbAsignarMecanico = new JButton("Asignar Mecanico");
        this.jbPresupuestar = new JButton("Presupuestar");
        this.jbEntregar = new JButton("Entregar");
        this.armarPanel();
    }

    private void armarPanel() {
        this.setLayout(new FlowLayout());
        this.add(this.jbAlta);
        this.add(this.jbAsignarMecanico);
        this.add(this.jbPresupuestar);
        this.add(this.jbEntregar);
    }

    public JButton getJbAlta() {
        return jbAlta;
    }

    public JButton getJbAsignarMecanico() {
        return jbAsignarMecanico;
    }

    public JButton getJbPresupuestar() {
        return jbPresupuestar;
    }

    public JButton getJbEntregar() {
        return jbEntregar;
    }
}
