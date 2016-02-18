package com.github.rb.tplusimar2015.core.gui.impl;

import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.github.rb.tplusimar2015.core.impl.MainController;

public final class PrincipalMenuOpciones extends JMenuBar {

    private final MainController controlador;

    private final JMenu menuAuto;
    private final JMenuItem menuItemAltaAuto;
    private final JMenuItem menuItemListarAuto;

    private final JMenu menuCliente;
    private final JMenuItem menuItemAltaCliente;
    private final JMenuItem menuItemListarCliente;

    private final JMenu menuModelo;
    private final JMenuItem menuItemAltaModelo;
    private final JMenuItem menuItemListarModelo;

    private final JMenu menuEmpleado;
    private final JMenuItem menuItemAltaEmpleado;
    private final JMenuItem menuItemListarEmpleado;

    private final JMenu menuReparacion;
    private final JMenuItem menuItemListarReparacion;

    public PrincipalMenuOpciones(MainController manejadorEventos) {

        this.controlador = manejadorEventos;

        this.menuAuto = new JMenu("Autos");
        this.menuItemAltaAuto = new JMenuItem("Alta Auto");
        this.menuItemListarAuto = new JMenuItem("Listar Autos");

        this.menuCliente = new JMenu("Clientes");
        this.menuItemAltaCliente = new JMenuItem("Alta Cliente");
        this.menuItemListarCliente = new JMenuItem("Listar Clientes");

        this.menuModelo = new JMenu("Modelos");
        this.menuItemAltaModelo = new JMenuItem("Alta Modelo");
        this.menuItemListarModelo = new JMenuItem("Listar Modelos");

        this.menuEmpleado = new JMenu("Empleados");
        this.menuItemAltaEmpleado = new JMenuItem("Alta Empleado");
        this.menuItemListarEmpleado = new JMenuItem("Listar Empleados");

        this.menuReparacion = new JMenu("Reparaciones");
        this.menuItemListarReparacion = new JMenuItem("Listar Reparaciones");

        this.armarMenu();
        this.cargarListeners();

    }

    public final void armarMenu() {

        this.menuAuto
                .add(this.menuItemAltaAuto);
        this.menuAuto
                .add(this.menuItemListarAuto);

        this.menuCliente
                .add(this.menuItemAltaCliente);
        this.menuCliente
                .add(this.menuItemListarCliente);

        this.menuModelo
                .add(this.menuItemAltaModelo);
        this.menuModelo
                .add(this.menuItemListarModelo);

        this.menuEmpleado
                .add(this.menuItemAltaEmpleado);
        this.menuEmpleado
                .add(this.menuItemListarEmpleado);

        this.menuReparacion
                .add(this.menuItemListarReparacion);

        this.add(this.menuAuto);
        this.add(this.menuCliente);
        this.add(this.menuModelo);
        this.add(this.menuEmpleado);
        this.add(this.menuReparacion);

    }

    public final void cargarListeners() {

        menuItemAltaAuto.addActionListener((ActionEvent e) -> {
            controlador.getAutoController()
                    .mostrarPanelAlta();
        });

        menuItemListarAuto.addActionListener((ActionEvent e) -> {
            controlador.getAutoController()
                    .mostrarPanelListar();
        });

        menuItemAltaCliente.addActionListener((ActionEvent e) -> {
            controlador.getClienteController()
                    .mostrarPanelAlta();
        });

        menuItemListarCliente.addActionListener((ActionEvent e) -> {
            controlador.getClienteController()
                    .mostrarPanelListar();
        });

        menuItemAltaModelo.addActionListener((ActionEvent e) -> {
            controlador.getModeloController()
                    .mostrarPanelAlta();
        });

        menuItemListarModelo.addActionListener((ActionEvent e) -> {
            controlador.getModeloController()
                    .mostrarPanelListar();
        });

        menuItemAltaEmpleado.addActionListener((ActionEvent e) -> {
            controlador.getEmpleadoController()
                    .mostrarPanelAlta();
        });

        menuItemListarEmpleado.addActionListener((ActionEvent e) -> {
            controlador.getEmpleadoController()
                    .mostrarPanelListar();
        });

        menuItemListarReparacion.addActionListener((ActionEvent e) -> {
            controlador.getReparacionController()
                    .mostrarPanelListar();
        });

    }
}
