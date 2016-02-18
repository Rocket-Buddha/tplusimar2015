package com.github.rb.tplusimar2015.autos.gui.impl;

import javax.swing.ComboBoxModel;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;

public final class AutoModificarSoportePanel extends PanelSoporteForm {

    public AutoModificarSoportePanel(InterfaceModuleController controller,
            Auto auto, ComboBoxModel<Cliente> modeloClientes,
            ComboBoxModel<Modelo> modeloModelos)
            throws GUIException {

        super(controller,
                new AutoPanelBotoneraForm(),
                new AutoPanelFormularioForm(auto,
                        modeloClientes,
                        modeloModelos),
                PanelSoporteForm.Tipo.MODIFICACION);

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

        Modelo modelo = (Modelo) ((AutoPanelFormularioForm) panelCentral).getJcbModelo().getSelectedItem();
        Cliente cliente = (Cliente) ((AutoPanelFormularioForm) panelCentral).getJcbDni().getSelectedItem();
        Auto auto = new Auto();

        auto.setDescripcionParticular(descripcion.toUpperCase());
        auto.setCliente(cliente);
        auto.setModelo(modelo);
        auto.setNumeroDeChasis(numeroChasis.toUpperCase());
        auto.setNumeroDeMotor(numeroMotor.toUpperCase());
        auto.setPatente(patente.toUpperCase());

        return auto;
    }
}
