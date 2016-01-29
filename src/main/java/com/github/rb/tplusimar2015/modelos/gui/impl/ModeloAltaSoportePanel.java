/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rb.tplusimar2015.modelos.gui.impl;
import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import com.github.rb.tplusimar2015.core.pojo.Marca;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.GUIException;


/**
 *
 * @author Andres
 */
final public class ModeloAltaSoportePanel extends PanelSoporteForm {

    public ModeloAltaSoportePanel(InterfaceModuleController controller)
            throws GUIException {
        super(controller, new ModeloPanelBotoneraForm(),
                new ModeloPanelFormularioForm(),PanelSoporteForm.Tipo.ALTA);
        try {
         
        } catch (Exception e) {
            throw new GUIException(e);
        }
    }

    @Override
    protected Object prepararDatos() {
      
        PanelFormularioForm panelCentral = super.getPanelCentral();

//		Integer nModelo = Integer.valueOf(((ModeloPanelFormularioForm) panelCentral)
//				.getJtfNumero()
//                                .getText());
		String nombre = ((ModeloPanelFormularioForm) panelCentral)
				.getJtfNombre()
                                .getText();
		String descripcion = ((ModeloPanelFormularioForm) panelCentral)
                                .getJtfDescripcion()
                                .getText();
		
		Marca marca= (Marca)((ModeloPanelFormularioForm) panelCentral).getJcbMarca().getSelectedItem();
                
		Modelo modelo = new Modelo(nombre,descripcion,marca);

		return modelo;
    }

}
