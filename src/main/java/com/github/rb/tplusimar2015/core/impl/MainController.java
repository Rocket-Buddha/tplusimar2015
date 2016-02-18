package com.github.rb.tplusimar2015.core.impl;

import java.awt.Component;
import com.github.rb.tplusimar2015.exceptions.ExceptionController;
import com.github.rb.tplusimar2015.clientes.impl.ClienteController;
import com.github.rb.tplusimar2015.autos.impl.AutoController;
import com.github.rb.tplusimar2015.core.gui.impl.PrincipalVentana;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.empleados.impl.EmpleadoController;
import com.github.rb.tplusimar2015.modelos.impl.ModeloController;
import com.github.rb.tplusimar2015.reparaciones.impl.ReparacionController;

public final class MainController {

    static private MainController INSTANCE;

    private final PrincipalVentana principalVentana;
    private final InterfaceModuleController autoController;
    private final InterfaceModuleController clienteController;
    private final InterfaceModuleController modeloController;
    private final InterfaceModuleController empleadoController;
    private final ReparacionController reparacionController;
    private final ExceptionController exceptionController;

    public static MainController getInstance() {

        synchronized (MainController.class) {

            INSTANCE = (INSTANCE == null) ? new MainController() : INSTANCE;
        }
        return INSTANCE;
    }

    private MainController() {

        this.principalVentana = PrincipalVentana.getInstance(this);
        this.exceptionController = ExceptionController.getInstance(this);
        this.autoController = AutoController.getInstance(this);
        this.clienteController = ClienteController.getInstance(this);
        this.modeloController = ModeloController.getInstance(this);
        this.empleadoController = EmpleadoController.getInstance(this);
        this.reparacionController = ReparacionController.getInstance(this);

        this.autoController.mostrarPanelListar();
    }

    public void render(Component comp) {

        PrincipalVentana ventana = this.principalVentana;

        ventana.getContentPane()
                .removeAll();
        ventana.getContentPane()
                .add(comp);
        ventana.getContentPane()
                .validate();
        ventana.getContentPane()
                .repaint();

    }

    public InterfaceModuleController getAutoController() {
        return autoController;
    }

    public PrincipalVentana getPrincipalVentana() {
        return principalVentana;
    }

    public ExceptionController getExceptionController() {
        return exceptionController;
    }

    public InterfaceModuleController getClienteController() {
        return clienteController;
    }

    public InterfaceModuleController getModeloController() {
        return modeloController;
    }

    public InterfaceModuleController getEmpleadoController() {
        return empleadoController;
    }

    public ReparacionController getReparacionController() {
        return reparacionController;
    }

}
