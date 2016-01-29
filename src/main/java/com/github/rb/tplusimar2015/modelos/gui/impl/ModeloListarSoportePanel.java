package com.github.rb.tplusimar2015.modelos.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Marca;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteList;
import javax.swing.table.AbstractTableModel;

public class ModeloListarSoportePanel extends PanelSoporteList {

    public ModeloListarSoportePanel(InterfaceModuleController controller,
            AbstractTableModel modelo) {

        super(controller,
                new ModeloPanelBotoneraList(),
                new ModeloPanelFormularioList(modelo));
        
        
       
        //super.getTabla().borrarColumna("NºMODELO", 0);
    }
    
    @Override
    protected Modelo prepararDatos() {

        Integer indice = super.getPanelCentral()
                .getTabla()
                .getSelectedRow();

        Integer nModelo = Integer.valueOf((String)super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 0));

        String nombre = (String)super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 1);
                
        String descripcion = (String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 2);
        
        Marca marca = Marca.getMarca(super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 3).toString());

        Modelo modelo = new Modelo(nModelo,nombre, descripcion, marca);

        return modelo;
    }
}
