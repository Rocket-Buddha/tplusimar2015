package com.github.rb.tplusimar2015.core.gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.gui.impl.TablaListener;
import java.awt.event.ActionEvent;

public abstract class PanelSoporteList extends JPanel {

    private final InterfaceModuleController controller;
    private final PanelBotoneraList panelSur;
    private final PanelFormularioList panelCentral;

    protected PanelSoporteList(InterfaceModuleController controller,
            PanelBotoneraList panelSur,
            PanelFormularioList panelCentral) {

        this.controller = controller;
        this.panelSur = panelSur;
        this.panelCentral = panelCentral;

        armarPanel();
        cargarListeners();
    }

    ;

	private void armarPanel() {
        setLayout(new BorderLayout());
        this.add(this.panelSur,
                BorderLayout.SOUTH);
        this.add(this.panelCentral,
                BorderLayout.CENTER);
    }

    private void cargarListeners() {

        panelSur.getJbActualizar()
                .addActionListener((ActionEvent e) -> {
                    try {
                        controller.mostrarPanelModificar(prepararDatos());
                    } catch (Exception e1) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(e1);
                    }
                });

        panelSur.getJbEliminar().addActionListener((ActionEvent e) -> {
            try {
                controller.baja(prepararDatos());
            } catch (Exception e1) {
                controller.getMainController()
                        .getExceptionController()
                        .ErrorGenerico(e1);
            }
        });

        panelSur.getJbAlta().addActionListener((ActionEvent e) -> {
            try {
                controller.mostrarPanelAlta();
            } catch (Exception e1) {
                controller.getMainController()
                        .getExceptionController().ErrorGenerico(e1);
            }
        });
    }

    protected abstract Object prepararDatos();

    public InterfaceModuleController getController() {
        return controller;
    }

    public PanelBotoneraList getPanelSur() {
        return panelSur;
    }

    public PanelFormularioList getPanelCentral() {
        return panelCentral;
    }

    public TablaListener getTabla() {
        return this.panelCentral.getTabla();
    }
}
