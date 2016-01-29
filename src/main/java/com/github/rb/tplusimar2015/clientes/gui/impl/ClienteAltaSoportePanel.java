package com.github.rb.tplusimar2015.clientes.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.exceptions.GUIException;

import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;

public final class ClienteAltaSoportePanel extends PanelSoporteForm {

	public ClienteAltaSoportePanel(InterfaceModuleController controller)
			throws GUIException {
		super(controller, new ClientePanelBotoneraForm(),
				new ClientePanelFormularioForm(), PanelSoporteForm.Tipo.ALTA);	
	}
	
	@Override
	protected Object prepararDatos() {
		
		PanelFormularioForm panelCentral = super.getPanelCentral();

		Integer dni = Integer.valueOf(((ClientePanelFormularioForm) panelCentral)
				.getJtfDni().getText());
		String nombre = ((ClientePanelFormularioForm) panelCentral)
				.getJtfNombre().getText();
		String apellido = ((ClientePanelFormularioForm) panelCentral).getJtfApellido()
				.getText();
		String telefono = ((ClientePanelFormularioForm) panelCentral).getJtfTelefono()
				.getText();
		
		Cliente cliente = new Cliente(dni, nombre.toUpperCase(), apellido.toUpperCase(), telefono.toUpperCase());

		return cliente;
	}

}
