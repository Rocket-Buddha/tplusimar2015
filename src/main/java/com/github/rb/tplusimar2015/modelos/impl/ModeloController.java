/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rb.tplusimar2015.modelos.impl;

import com.github.rb.tplusimar2015.modelos.gui.impl.ModeloModificarSoportePanel;
import com.github.rb.tplusimar2015.modelos.gui.impl.ModeloAltaSoportePanel;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import com.github.rb.tplusimar2015.core.gui.impl.PrincipalVentana;
import com.github.rb.tplusimar2015.core.impl.MainController;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import com.github.rb.tplusimar2015.modelos.gui.impl.ModeloListarSoportePanel;

import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class ModeloController implements InterfaceModuleController {

    MainController mainController;
    private static ModeloController INSTANCE;

    public static ModeloController getInstance(MainController mainController) {
        synchronized (ModeloController.class) {
            if (INSTANCE == null) {
                INSTANCE = new ModeloController(mainController);
            }
        }
        return INSTANCE;
    }

    private ModeloController(MainController mainController) {

        this.mainController = mainController;
    }

    @Override
    public void mostrarPanelListar() {
        try {

            ModeloListarSoportePanel panelListado = new ModeloListarSoportePanel(
                    this, ModeloModelo.getInstance());

            ModeloModelo.getInstance()
                    .addTableModelListener(panelListado.getTabla());

            this.mainController.render(panelListado);

        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void mostrarPanelAlta() {
        try {

            PanelSoporteForm panelSoporteForm = new ModeloAltaSoportePanel(this);
            this.mainController.render(panelSoporteForm);

        } catch (GUIException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void mostrarPanelModificar(Object modelo) {
        try {

            PanelSoporteForm panelSoporteForm = new ModeloModificarSoportePanel(this, (Modelo) modelo);

            this.mainController.render(panelSoporteForm);

        } catch (Exception e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void alta(Object modelo) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(//REFACTOREAR ESTO
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea dar de alta el Modelo?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ModeloModelo.getInstance()
                        .altaModelo((Modelo) modelo);
                this.mostrarPanelListar();
            }
            if (respuesta == JOptionPane.NO_OPTION) {
            } else {
                this.mostrarPanelListar();
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void baja(Object modelo) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController), "¿Esta seguro que desea eliminar el Modelo?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ModeloModelo.getInstance().bajaModelo((Modelo) modelo);
            } else {
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void modificar(Object modelo) {
        try {
            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea modificar el Modelo?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ModeloModelo.getInstance().modificarModelo((Modelo) modelo);
                this.mostrarPanelListar();

                if (respuesta == JOptionPane.NO_OPTION) {
                } else {
                    this.mostrarPanelListar();
                }
            }
        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public MainController getMainController() {
        return this.mainController;
    }

}
