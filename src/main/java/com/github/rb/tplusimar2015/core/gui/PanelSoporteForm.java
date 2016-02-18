package com.github.rb.tplusimar2015.core.gui;

import javax.swing.JPanel;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public abstract class PanelSoporteForm extends JPanel {

    private final InterfaceModuleController controller;
    private final PanelBotoneraForm panelSur;
    private final PanelFormularioForm panelCentral;

    public static enum Tipo {
        ALTA, MODIFICACION
    };

    protected PanelSoporteForm(InterfaceModuleController manejadorEventos,
            PanelBotoneraForm panelSur,
            PanelFormularioForm panelCentral,
            Tipo tipo) {

        this.controller = manejadorEventos;
        this.panelSur = panelSur;
        this.panelCentral = panelCentral;

        this.armarPanel();
        this.cargarListeners(tipo);

    }

    private void armarPanel() {
        setLayout(new BorderLayout());
        this.add(this.panelSur,
                BorderLayout.SOUTH);
        this.add(this.panelCentral,
                BorderLayout.CENTER);
    }

    private void cargarListeners(Tipo tipo) {
        switch (tipo) {
            case ALTA:
                panelSur.getJbAceptar()
                        .addActionListener((ActionEvent e) -> {
                    try {
                        controller.alta(prepararDatos());

                    } catch (NumberFormatException exc) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(exc);
                    }
                });
                break;

            case MODIFICACION:
                panelSur.getJbAceptar()
                        .addActionListener((ActionEvent e) -> {
                    try {
                        controller.modificar(prepararDatos());
                    } catch (NumberFormatException exc) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(exc);
                    }
                });
                break;
            default:
                throw new AssertionError(tipo.name());
        }
        panelSur.getJbCancelar()
                .addActionListener((ActionEvent e) -> {
            controller.mostrarPanelListar();
        });
    }

    protected abstract Object prepararDatos();

    public InterfaceModuleController getController() {
        return controller;
    }

    public final PanelBotoneraForm getPanelSur() {
        return panelSur;
    }

    public final PanelFormularioForm getPanelCentral() {
        return panelCentral;
    }
}
