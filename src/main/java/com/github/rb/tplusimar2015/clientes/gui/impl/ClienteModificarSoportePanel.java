package com.github.rb.tplusimar2015.clientes.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;

public final class ClienteModificarSoportePanel extends PanelSoporteForm {

    public ClienteModificarSoportePanel(InterfaceModuleController controller,
            Cliente cliente) throws GUIException {

        super(controller,
                new ClientePanelBotoneraForm(),
                new ClientePanelFormularioForm(cliente),
                PanelSoporteForm.Tipo.MODIFICACION);

    }

    @Override
    protected Object prepararDatos() {

        PanelFormularioForm panelCentral = super.getPanelCentral();

        Integer dni = Integer.valueOf(((ClientePanelFormularioForm) panelCentral)
                .getJtfDni()
                .getText());
        String nombre = ((ClientePanelFormularioForm) panelCentral)
                .getJtfNombre()
                .getText();
        String apellido = ((ClientePanelFormularioForm) panelCentral).getJtfApellido()
                .getText();
        String telefono = ((ClientePanelFormularioForm) panelCentral).getJtfTelefono()
                .getText();

        Cliente cliente = new Cliente(dni,
                nombre.toUpperCase(),
                apellido.toUpperCase(),
                telefono.toUpperCase());

        return cliente;
    }
}
