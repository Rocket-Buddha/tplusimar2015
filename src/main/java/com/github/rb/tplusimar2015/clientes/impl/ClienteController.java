package com.github.rb.tplusimar2015.clientes.impl;

import javax.swing.JOptionPane;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import com.github.rb.tplusimar2015.clientes.gui.impl.ClienteAltaSoportePanel;
import com.github.rb.tplusimar2015.clientes.gui.impl.ClienteListarSoportePanel;
import com.github.rb.tplusimar2015.clientes.gui.impl.ClienteModificarSoportePanel;
import com.github.rb.tplusimar2015.core.gui.impl.PrincipalVentana;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.impl.MainController;

public final class ClienteController implements InterfaceModuleController {

    private final MainController mainController;
    private static ClienteController INSTANCE;

    public static ClienteController getInstance(MainController mainController) {

        synchronized (ClienteController.class) {

            INSTANCE = (INSTANCE == null) ? new ClienteController(mainController) : INSTANCE;
        }
        return INSTANCE;
    }

    private ClienteController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void mostrarPanelListar() {
        try {

            ClienteListarSoportePanel panelListado = new ClienteListarSoportePanel(this,
                    ClienteModelo.getInstance());

            ClienteModelo.getInstance()
                    .addTableModelListener(panelListado.getTabla());

            this.mainController
                    .render(panelListado);

        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }

    }

    @Override
    public void mostrarPanelAlta() {
        try {

            PanelSoporteForm panelSoporteForm = new ClienteAltaSoportePanel(this);

            this.mainController
                    .render(panelSoporteForm);

        } catch (GUIException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }

    }

    @Override
    public void mostrarPanelModificar(Object cliente) {
        try {

            PanelSoporteForm panelSoporteForm = new ClienteModificarSoportePanel(this,
                    (Cliente) cliente);

            this.mainController
                    .render(panelSoporteForm);

        } catch (GUIException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }

    }

    @Override
    public void alta(Object cliente) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea dar de alta el Cliente?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ClienteModelo.getInstance()
                        .altaCliente((Cliente) cliente);
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

    @Override
    public void baja(Object cliente) {

        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea eliminar el Cliente?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ClienteModelo.getInstance()
                        .bajaCliente((Cliente) cliente);
            } else {
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }

    }

    @Override
    public void modificar(Object cliente) {
        try {
            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea modificar el Cliente?");

            if (respuesta == JOptionPane.OK_OPTION) {

                ClienteModelo.getInstance()
                        .modificarCliente((Cliente) cliente);
                this.mostrarPanelListar();

                if (respuesta == JOptionPane.NO_OPTION) {
                } else {
                    this.mostrarPanelListar();
                }
            }
        } catch (ModelException | RuntimeException e) {
            this.mainController
                    .getExceptionController()
                    .ErrorGenerico(e);
        }

    }

    @Override
    public MainController getMainController() {

        return this.mainController;

    }
}
