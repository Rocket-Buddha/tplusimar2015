package com.github.rb.tplusimar2015.core.impl;

import com.github.rb.tplusimar2015.exceptions.ExceptionController;
import com.github.rb.tplusimar2015.clientes.impl.ClienteController;
import com.github.rb.tplusimar2015.autos.impl.AutoController;
import com.github.rb.tplusimar2015.core.gui.impl.PrincipalVentana;
import java.awt.Component;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.empleados.impl.EmpleadoController;
import com.github.rb.tplusimar2015.modelos.impl.ModeloController;

public class MainController {

    static MainController INSTANCE;
    private PrincipalVentana principalVentana;
    private InterfaceModuleController autoController;
    private InterfaceModuleController clienteController;
    private InterfaceModuleController modeloController;
    private InterfaceModuleController empleadoController;
    private ExceptionController exceptionController;

    
    //refactorizar revisar los seters no hacen falta!!
    
    
    public static MainController getInstance() {

        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;

    }

    private static void createInstance() {

        if (INSTANCE == null) {
            synchronized (MainController.class) {

                if (INSTANCE == null) {
                    INSTANCE = new MainController();
                }
            }
        }
    }

    private MainController() {

        this.principalVentana = PrincipalVentana.getInstance(this);

        this.exceptionController = ExceptionController.getInstance(this);
        this.autoController = AutoController.getInstance(this);
        this.clienteController = ClienteController.getInstance(this);
        this.modeloController = ModeloController.getInstance(this);
        this.empleadoController = EmpleadoController.getInstance(this);

        this.autoController.mostrarPanelListar();
    }
    

    public void render(Component comp) {

        PrincipalVentana ventana = this.principalVentana;

        ventana.getContentPane().removeAll();
        ventana.getContentPane().add(comp);
        ventana.getContentPane().validate();
        ventana.getContentPane().repaint();

    }

    public InterfaceModuleController getAutoController() {
        return autoController;
    }

    public void setAutoController(InterfaceModuleController autoController) {
        this.autoController = autoController;
    }

    public PrincipalVentana getPrincipalVentana() {
        return principalVentana;
    }

    public void setPrincipalVentana(PrincipalVentana principalVentana) {
        this.principalVentana = principalVentana;
    }

    public ExceptionController getExceptionController() {
        return exceptionController;
    }

    public void setExceptionController(ExceptionController exceptionController) {
        this.exceptionController = exceptionController;
    }

    public InterfaceModuleController getClienteController() {
        return clienteController;
    }

    public void setClienteController(InterfaceModuleController clienteController) {
        this.clienteController = clienteController;
    }

    public InterfaceModuleController getModeloController() {
        return modeloController;
    }

    public void setModeloController(InterfaceModuleController modeloController) {
        this.modeloController = modeloController;
    }

    public InterfaceModuleController getEmpleadoController() {
        return empleadoController;
    }

    public void setEmpleadoController(InterfaceModuleController empleadoController) {
        this.empleadoController = empleadoController;
    }

    
    
}
