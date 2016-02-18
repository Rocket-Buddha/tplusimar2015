package com.github.rb.tplusimar2015.reparaciones.gui.impl;

import com.github.rb.tplusimar2015.core.gui.PanelFormularioList;
import com.github.rb.tplusimar2015.core.gui.impl.TablaListener;
import com.github.rb.tplusimar2015.core.pojo.Reparacion;
import com.github.rb.tplusimar2015.reparaciones.impl.ReparacionController;
import com.github.rb.tplusimar2015.reparaciones.impl.ReparacionModelo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public final class ReparacionListarSoportePanel extends JPanel {

    private final ReparacionController controller;
    private final ReparacionPanelBotoneraList panelSur;
    private final PanelFormularioList panelCentral;

    public ReparacionListarSoportePanel(ReparacionController controller,
            ReparacionModelo reparacionModelo) {

        this.controller = controller;

        this.panelSur = new ReparacionPanelBotoneraList();
        this.panelCentral = new ReparacionPanelFormularioList(reparacionModelo);

        armarPanel();
        cargarListeners();
    }

    private void armarPanel() {
        setLayout(new BorderLayout());
        this.add(this.panelSur, BorderLayout.SOUTH);
        this.add(this.panelCentral, BorderLayout.CENTER);
    }

    private void cargarListeners() {

        panelSur.getJbAlta()
                .addActionListener((ActionEvent e) -> {
                    try {
                        controller.mostrarPanelAlta();
                    } catch (Exception e1) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(e1);
                    }
                });

        panelSur.getJbAsignarMecanico()
                .addActionListener((ActionEvent e) -> {
                    try {
                        controller.mostrarPanelAsignarMecanico(prepararDatos());
                    } catch (Exception e1) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(e1);
                    }
                });

        panelSur.getJbEntregar()
                .addActionListener((ActionEvent e) -> {
                    try {
                        controller.mostrarPanelEntregar(prepararDatos());
                    } catch (Exception e1) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(e1);
                    }
                });

        panelSur.getJbPresupuestar()
                .addActionListener((ActionEvent e) -> {
                    try {
                        controller.mostrarPanelPresupuestar(prepararDatos());
                    } catch (Exception e1) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(e1);
                    }
                });
    }

    protected Reparacion prepararDatos() {

        Integer indice = panelCentral.getTabla().getSelectedRow();
        String numeroReparacion;
        numeroReparacion = (String) panelCentral.getTabla().getValueAt(indice, 0);
        Reparacion reparacionRetorno = new Reparacion();
        reparacionRetorno.setNumeroReparacion(Integer.valueOf(numeroReparacion));
        return reparacionRetorno;
    }

    public TablaListener getTabla() {
        return this.panelCentral.getTabla();
    }
}
