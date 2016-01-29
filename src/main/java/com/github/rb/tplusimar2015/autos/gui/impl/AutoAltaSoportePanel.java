package com.github.rb.tplusimar2015.autos.gui.impl;

import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import javax.swing.ComboBoxModel;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;

public final class AutoAltaSoportePanel extends PanelSoporteForm {

    public AutoAltaSoportePanel(InterfaceModuleController controller,
            ComboBoxModel<Cliente> modeloClientes,
            ComboBoxModel<Modelo> modeloModelos)
            throws GUIException {

        super(controller,
                new AutoPanelBotoneraForm(),
                new AutoPanelFormularioForm(modeloClientes, modeloModelos), PanelSoporteForm.Tipo.ALTA);
    }

    @Override
    protected Auto prepararDatos() {

        PanelFormularioForm panelCentral = super.getPanelCentral();

        String descripcion = ((AutoPanelFormularioForm) panelCentral)
                .getJtfDescripcion().getText();
        String numeroChasis = ((AutoPanelFormularioForm) panelCentral)
                .getJtfNumeroChasis().getText();
        String numeroMotor = ((AutoPanelFormularioForm) panelCentral)
                .getJtfNumeroMotor().getText();
        String patente = ((AutoPanelFormularioForm) panelCentral)
                .getJtfPatente().getText();

        Auto auto = new Auto();
        Cliente cliente = (Cliente) ((AutoPanelFormularioForm) panelCentral).getJcbDni().getSelectedItem();
        Modelo modelo = (Modelo) ((AutoPanelFormularioForm) panelCentral).getJcbModelo().getSelectedItem();

        auto.setDescripcionParticular(descripcion.toUpperCase());
        auto.setCliente(cliente);
        auto.setModelo(modelo);
        auto.setNumeroDeChasis(numeroChasis.toUpperCase());
        auto.setNumeroDeMotor(numeroMotor.toUpperCase());
        auto.setPatente(patente.toUpperCase());

        return auto;
    }
}
