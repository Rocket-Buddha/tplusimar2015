package com.github.rb.tplusimar2015.core.gui.impl;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.github.rb.tplusimar2015.core.impl.MainController;
import com.github.rb.tplusimar2015.utils.Grafico;

public final class PrincipalVentana extends JFrame {

    private final PrincipalMenuOpciones menuOpciones;
    private static PrincipalVentana INSTANCE;

    public static PrincipalVentana getInstance(MainController mainController) {

        synchronized (PrincipalVentana.class) {

            INSTANCE = (INSTANCE == null) ? new PrincipalVentana(mainController) : INSTANCE;
        }
        return INSTANCE;
    }

    private PrincipalVentana(MainController controllador) {
        this.menuOpciones = new PrincipalMenuOpciones(controllador);
        this.armarVentana();
        this.mostraVentana();

    }

    private void armarVentana() {
        this.setBounds(0, 0, Grafico.obtenerAnchoPantalla() / 2,
                Grafico.obtenerAltoPantalla() / 2);
        this.setJMenuBar(menuOpciones);

    }

    private void mostraVentana() {
        this.setVisible(true);
    }

    public final void mostrarError(String error) {

        JOptionPane.showMessageDialog(this,
                error,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
