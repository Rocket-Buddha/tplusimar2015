package com.github.rb.tplusimar2015.empleados.impl;


import javax.swing.JOptionPane;
import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import com.github.rb.tplusimar2015.empleados.gui.impl.EmpleadoAltaSoportePanel;
import com.github.rb.tplusimar2015.empleados.gui.impl.EmpleadoListarSoportePanel;
import com.github.rb.tplusimar2015.empleados.gui.impl.EmpleadoModificarSoportePanel;
import com.github.rb.tplusimar2015.core.gui.impl.PrincipalVentana;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.impl.MainController;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoController implements  InterfaceModuleController{

	private final MainController mainController;
	private static EmpleadoController INSTANCE;

    public static EmpleadoController getInstance(MainController mainController) {

        synchronized (EmpleadoController.class) {
            if (INSTANCE == null) {
                
                INSTANCE = new EmpleadoController(mainController);
            }
            return INSTANCE;
        }
    }

    private EmpleadoController(MainController mainController) {
        this.mainController = mainController;
    }

	
	@Override
	public void mostrarPanelListar() {
		try {

			EmpleadoListarSoportePanel panelListado = new EmpleadoListarSoportePanel(this, EmpleadoModelo.getInstance());

			EmpleadoModelo.getInstance().addTableModelListener(panelListado.getTabla());

			this.mainController.render(panelListado);

		} catch (RuntimeException e) {
			this.mainController.getExceptionController().ErrorGenerico(e);
		}
		
	}

	@Override
	public void mostrarPanelAlta() {
		try {

			PanelSoporteForm panelSoporteForm = new EmpleadoAltaSoportePanel(this);
			
			this.mainController.render(panelSoporteForm);

		} catch (GUIException | RuntimeException e) {
			this.mainController.getExceptionController().ErrorGenerico(e);
		}
	
	}

	@Override
	public void mostrarPanelModificar(Object empleado) {
		try {

			PanelSoporteForm panelSoporteForm = new EmpleadoModificarSoportePanel(this, (Empleado) empleado);

			this.mainController.render(panelSoporteForm);

		} catch (GUIException | RuntimeException e) {
			this.mainController.getExceptionController().ErrorGenerico(e);
		}
		
	}

	@Override
	public void alta(Object empleado) {
		try {

			Integer respuesta = JOptionPane.showConfirmDialog(
					PrincipalVentana.getInstance(this.mainController),
					"¿Esta seguro que desea dar de alta el Empleado?");

			if (respuesta == JOptionPane.OK_OPTION) {

				EmpleadoModelo.getInstance().altaEmpleado((Empleado) empleado);
				this.mostrarPanelListar();
			}
			if (respuesta == JOptionPane.NO_OPTION) {} else { //REFACTOREAR ESTO
				this.mostrarPanelListar();
			}

		} catch (ModelException | RuntimeException e) {
			this.mainController.getExceptionController().ErrorGenerico(e);
		} catch (DAOException ex) {
                Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}

	@Override
	public void baja(Object empleado) {
		
		try {

			Integer respuesta = JOptionPane.showConfirmDialog(
					PrincipalVentana.getInstance(this.mainController), "�Esta seguro que desea eliminar el Empleado?");

			if (respuesta == JOptionPane.OK_OPTION) {

				EmpleadoModelo.getInstance().bajaEmpleado((Empleado) empleado);
			} else {
			}

		} catch (ModelException | RuntimeException e) {
			this.mainController.getExceptionController().ErrorGenerico(e);
		}
		
	}

	@Override
	public void modificar(Object empleado) {
		try {
			Integer respuesta = JOptionPane.showConfirmDialog(
					PrincipalVentana.getInstance(this.mainController),
					"¿Esta seguro que desea modificar el Empleado?");

			if (respuesta == JOptionPane.OK_OPTION) {

				EmpleadoModelo.getInstance().modificarEmpleado((Empleado) empleado);
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
	public MainController getMainController(){
		
		return this.mainController;
		
	}
}

