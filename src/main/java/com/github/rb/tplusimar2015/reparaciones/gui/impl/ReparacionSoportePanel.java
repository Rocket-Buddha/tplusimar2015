package com.github.rb.tplusimar2015.reparaciones.gui.impl;

import com.github.rb.tplusimar2015.autos.impl.AutoModelo;
import com.github.rb.tplusimar2015.core.pojo.Reparacion;
import com.github.rb.tplusimar2015.core.gui.PanelBotoneraForm;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.core.pojo.Vehiculo;
import com.github.rb.tplusimar2015.empleados.impl.EmpleadoModelo;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import com.github.rb.tplusimar2015.reparaciones.impl.ReparacionController;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public final class ReparacionSoportePanel extends JPanel {

    private final ReparacionController controller;
    private final PanelBotoneraForm panelSur;
    private final PanelFormularioForm panelCentral;

    public static enum Tipo {
        ALTA,
        ASIGNARMEC,
        PRESUPUESTAR,
        ENTREGAR
    };

    public ReparacionSoportePanel(ReparacionController controller,
            AutoModelo autoModelo,
            EmpleadoModelo empleadoModelo,
            ReparacionSoportePanel.Tipo tipo,
            Reparacion reparacion) throws ModelException {

        this.panelSur = new ReparacionPanelBotoneraForm();
        this.panelCentral = new ReparacionPanelFormularioForm(autoModelo,
                empleadoModelo,
                tipo,
                reparacion);

        this.controller = controller;

        this.armarPanel();
        this.cargarListeners(tipo);
    }

    private void armarPanel() {
        setLayout(new BorderLayout());
        this.add(this.panelSur, BorderLayout.SOUTH);
        this.add(this.panelCentral, BorderLayout.CENTER);
    }

    private void cargarListeners(ReparacionSoportePanel.Tipo tipo) {
        switch (tipo) {
            case ALTA:
                panelSur.getJbAceptar().addActionListener((ActionEvent e) -> {
                    try {
                        controller.alta(prepararDatos());

                    } catch (NumberFormatException exc) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(exc);
                    }
                });
                break;

            case ASIGNARMEC:
                panelSur.getJbAceptar().addActionListener((ActionEvent e) -> {
                    try {
                        controller.asignarMecanico(prepararDatos());
                    } catch (NumberFormatException exc) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(exc);
                    }
                });
                break;

            case PRESUPUESTAR:
                panelSur.getJbAceptar().addActionListener((ActionEvent e) -> {
                    try {
                        controller.presupuestar(prepararDatos());
                    } catch (NumberFormatException exc) {
                        controller.getMainController()
                                .getExceptionController()
                                .ErrorGenerico(exc);
                    }
                });
                break;

            case ENTREGAR:
                panelSur.getJbAceptar().addActionListener((ActionEvent e) -> {
                    try {
                        controller.entregar(prepararDatos());
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
        panelSur.getJbCancelar().addActionListener((ActionEvent e) -> {
            controller.mostrarPanelListar();
        });
    }

    protected Reparacion prepararDatos() {

        PanelFormularioForm panelCentralLocal = this.panelCentral;

        Empleado mecanico = new Empleado();
        Reparacion reparacion = new Reparacion();

        Integer numeroReparacion = null;
        Vehiculo vehiculo = null;
        Double presupuesto = null;
        String detalle = null;

        if (((ReparacionPanelFormularioForm) panelCentralLocal).getJtfnumeroReparacion() != null) {

            numeroReparacion = Integer.valueOf(((ReparacionPanelFormularioForm) panelCentralLocal).getJtfnumeroReparacion().getText());

        }

        if (((ReparacionPanelFormularioForm) panelCentralLocal).getJcbVehiculo() != null) {

            vehiculo = (Vehiculo) ((ReparacionPanelFormularioForm) panelCentralLocal).getJcbVehiculo().getSelectedItem();

        }

        if (((ReparacionPanelFormularioForm) panelCentralLocal).getJcbMecanico() != null) {

            mecanico = (Empleado) ((ReparacionPanelFormularioForm) panelCentralLocal).getJcbMecanico().getSelectedItem();

        }

        if (((ReparacionPanelFormularioForm) panelCentralLocal).getJtfPresupuesto() != null) {

            presupuesto = Double.valueOf(((ReparacionPanelFormularioForm) panelCentralLocal).getJtfPresupuesto().getText());

        }

        if (((ReparacionPanelFormularioForm) panelCentralLocal).getJtfDetalle() != null) {

            detalle = ((ReparacionPanelFormularioForm) panelCentralLocal).getJtfDetalle().getText();

        }

        reparacion.setNumeroReparacion(numeroReparacion);
        reparacion.setVehiculo(vehiculo);
        reparacion.setMecanico(mecanico);
        reparacion.setPresupuesto(presupuesto);
        reparacion.setDetalle(detalle);

        return reparacion;
    }
}
