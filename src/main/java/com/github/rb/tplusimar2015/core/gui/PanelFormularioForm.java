package com.github.rb.tplusimar2015.core.gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;

public abstract class PanelFormularioForm extends JPanel {

    private final JPanel contenedor;

    public PanelFormularioForm() {
        this.contenedor = new JPanel();
        this.armarPanel();
    }

    private void armarPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
    }

    public final JPanel getContenedor() {
        return contenedor;
    }
    
}
