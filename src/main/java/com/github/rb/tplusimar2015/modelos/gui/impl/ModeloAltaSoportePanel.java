package com.github.rb.tplusimar2015.modelos.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import com.github.rb.tplusimar2015.core.pojo.Marca;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.GUIException;

public final class ModeloAltaSoportePanel extends PanelSoporteForm {

    public ModeloAltaSoportePanel(InterfaceModuleController controller)
            throws GUIException {

        super(controller,
                new ModeloPanelBotoneraForm(),
                new ModeloPanelFormularioForm(),
                PanelSoporteForm.Tipo.ALTA);
        try {
        } catch (Exception e) {
            throw new GUIException(e);
        }
    }

    @Override
    protected Object prepararDatos() {

        PanelFormularioForm panelCentral = super.getPanelCentral();

        String nombre = ((ModeloPanelFormularioForm) panelCentral)
                .getJtfNombre()
                .getText();
        String descripcion = ((ModeloPanelFormularioForm) panelCentral)
                .getJtfDescripcion()
                .getText();

        Marca marca = (Marca) ((ModeloPanelFormularioForm) panelCentral).getJcbMarca()
                .getSelectedItem();

        Modelo modelo = new Modelo(nombre,
                descripcion,
                marca);

        return modelo;
    }
}
