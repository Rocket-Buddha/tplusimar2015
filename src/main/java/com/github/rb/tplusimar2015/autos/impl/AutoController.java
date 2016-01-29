package com.github.rb.tplusimar2015.autos.impl;

import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import com.github.rb.tplusimar2015.autos.gui.impl.AutoAltaSoportePanel;
import com.github.rb.tplusimar2015.autos.gui.impl.AutoListarSoportePanel;
import com.github.rb.tplusimar2015.autos.gui.impl.AutoModificarSoportePanel;
import com.github.rb.tplusimar2015.core.gui.impl.PrincipalVentana;
import javax.swing.JOptionPane;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.clientes.impl.ClienteModelo;
import com.github.rb.tplusimar2015.core.impl.MainController;
import com.github.rb.tplusimar2015.modelos.impl.ModeloModelo;

public class AutoController implements InterfaceModuleController {

    MainController mainController;
    private static AutoController INSTANCE;

    public static AutoController getInstance(MainController mainController) {
        if (INSTANCE == null) {
            createInstance(mainController);
        }
        return INSTANCE;
    }

    private static void createInstance(MainController mainController) {
        synchronized (AutoController.class) {
            if (INSTANCE == null) {
                INSTANCE = new AutoController(mainController);
            }
        }
    }

    private AutoController(MainController mainController) {

        this.mainController = mainController;
    }

    @Override
    public void mostrarPanelListar() {

        try {

            AutoListarSoportePanel panelListado = new AutoListarSoportePanel( this, AutoModelo.getInstance());

            AutoModelo.getInstance().addTableModelListener(
                    panelListado.getTabla());

            this.mainController.render(panelListado);

        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void mostrarPanelAlta() {
        try {

            PanelSoporteForm panelSoporteForm = new AutoAltaSoportePanel(this, ClienteModelo.getInstance(), ModeloModelo.getInstance());
            this.mainController.render(panelSoporteForm);

        } catch (GUIException | RuntimeException | ModelException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }

    }

    @Override
    public void mostrarPanelModificar(Object auto) {

        try {

            PanelSoporteForm panelSoporteForm = new AutoModificarSoportePanel(
                    this, (Auto) auto, ClienteModelo.getInstance(), ModeloModelo.getInstance());

            this.mainController.render(panelSoporteForm);

        } catch (GUIException | RuntimeException | ModelException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void alta(Object auto) {

        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea dar de alta el Auto?");

            if (respuesta == JOptionPane.OK_OPTION) {

                AutoModelo.getInstance().altaAuto((Auto) auto);
                this.mostrarPanelListar();
            }
            if (respuesta == JOptionPane.NO_OPTION) {
                return;
            } else {
                this.mostrarPanelListar();
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void baja(Object auto) {
        try {

            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea eliminar el Auto?");

            if (respuesta == JOptionPane.OK_OPTION) {

                AutoModelo.getInstance().bajaAuto((Auto) auto);
            } else {
                return;
            }

        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    @Override
    public void modificar(Object auto) {
        try {
            Integer respuesta = JOptionPane.showConfirmDialog(
                    PrincipalVentana.getInstance(this.mainController),
                    "¿Esta seguro que desea modificar el Auto?");

            if (respuesta == JOptionPane.OK_OPTION) {

                AutoModelo.getInstance().modificarAuto((Auto) auto);
                this.mostrarPanelListar();

                if (respuesta == JOptionPane.NO_OPTION) {
                    return;
                } else {
                    this.mostrarPanelListar();
                }
            }
        } catch (ModelException | RuntimeException e) {
            this.mainController.getExceptionController().ErrorGenerico(e);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public MainController getMainController() {

        return this.mainController;

    }
}
