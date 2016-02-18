package com.github.rb.tplusimar2015.reparaciones.impl;

import com.github.rb.tplusimar2015.autos.impl.AutoModelo;
import com.github.rb.tplusimar2015.core.gui.impl.PrincipalVentana;
import com.github.rb.tplusimar2015.core.impl.MainController;
import com.github.rb.tplusimar2015.core.pojo.Reparacion;
import com.github.rb.tplusimar2015.empleados.impl.EmpleadoModelo;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import com.github.rb.tplusimar2015.reparaciones.gui.impl.ReparacionSoportePanel;
import com.github.rb.tplusimar2015.reparaciones.gui.impl.ReparacionListarSoportePanel;
import javax.swing.JOptionPane;

public final class ReparacionController {

    private final MainController mainController;
    private static ReparacionController INSTANCE;

    public static ReparacionController getInstance(MainController mainController) {

        synchronized (ReparacionController.class) {

            INSTANCE = (INSTANCE == null) ? new ReparacionController(mainController) : INSTANCE;
        }
        return INSTANCE;
    }

    private ReparacionController(MainController mainController) {

        this.mainController = mainController;
    }

    public void mostrarPanelListar() {
        try {

            ReparacionListarSoportePanel panelListado = new ReparacionListarSoportePanel(
                    this,
                    ReparacionModelo.getInstance());

            ReparacionModelo.getInstance()
                    .addTableModelListener(panelListado.getTabla());

            this.mainController
                    .render(panelListado);

        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public void mostrarPanelAlta() {
        try {

            ReparacionSoportePanel reparacionSoportePanel = new ReparacionSoportePanel(this,
                    AutoModelo.getInstance(),
                    EmpleadoModelo.getInstance(),
                    ReparacionSoportePanel.Tipo.ALTA,
                    null);

            this.mainController
                    .render(reparacionSoportePanel);

        } catch (RuntimeException | ModelException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public void mostrarPanelAsignarMecanico(Reparacion reparacion) {
        try {

            ReparacionSoportePanel reparacionSoportePanel = new ReparacionSoportePanel(this,
                    AutoModelo.getInstance(),
                    EmpleadoModelo.getInstance(),
                    ReparacionSoportePanel.Tipo.ASIGNARMEC,
                    reparacion);

            this.mainController
                    .render(reparacionSoportePanel);

        } catch (RuntimeException | ModelException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public void mostrarPanelPresupuestar(Reparacion reparacion) {
        try {

            ReparacionSoportePanel reparacionSoportePanel = new ReparacionSoportePanel(this,
                    AutoModelo.getInstance(),
                    EmpleadoModelo.getInstance(),
                    ReparacionSoportePanel.Tipo.PRESUPUESTAR,
                    reparacion);

            this.mainController
                    .render(reparacionSoportePanel);

        } catch (RuntimeException | ModelException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public void mostrarPanelEntregar(Reparacion reparacion) {
        try {

            ReparacionSoportePanel reparacionSoportePanel = new ReparacionSoportePanel(this,
                    AutoModelo.getInstance(),
                    EmpleadoModelo.getInstance(),
                    ReparacionSoportePanel.Tipo.ENTREGAR,
                    reparacion);

            this.mainController
                    .render(reparacionSoportePanel);

        } catch (RuntimeException | ModelException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public void alta(Reparacion reparacion) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea dar de alta la Reparacion?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ReparacionModelo.getInstance()
                        .altaReparacion(reparacion);

                this.mostrarPanelListar();
            }
            if (respuesta == JOptionPane.NO_OPTION) {
            } else {
                this.mostrarPanelListar();
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public void asignarMecanico(Reparacion reparacion) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea asignar el mecanico a la Reparacion?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ReparacionModelo
                        .getInstance()
                        .asignarMecanico(reparacion);

                this.mostrarPanelListar();
            }
            if (respuesta == JOptionPane.NO_OPTION) {
            } else {
                this.mostrarPanelListar();
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public void presupuestar(Reparacion reparacion) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea presupuestar la Reparacion?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ReparacionModelo
                        .getInstance()
                        .presupuestar(reparacion);

                this.mostrarPanelListar();
            }
            if (respuesta == JOptionPane.NO_OPTION) {
            } else {
                this.mostrarPanelListar();
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }

    public MainController getMainController() {
        return this.mainController;
    }

    public void entregar(Reparacion reparacion) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea entregar la Reparacion?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ReparacionModelo
                        .getInstance()
                        .entregar(reparacion);

                this.mostrarPanelListar();
            }
            if (respuesta == JOptionPane.NO_OPTION) {
            } else {
                this.mostrarPanelListar();
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }
    }
}
