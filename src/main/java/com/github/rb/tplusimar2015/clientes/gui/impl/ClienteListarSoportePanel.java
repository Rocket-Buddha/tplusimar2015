package com.github.rb.tplusimar2015.clientes.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteList;
import javax.swing.table.AbstractTableModel;

public class ClienteListarSoportePanel extends PanelSoporteList {

   public ClienteListarSoportePanel(InterfaceModuleController controller,
                                  AbstractTableModel modelo){
        
        super(controller, new ClientePanelBotoneraList(),new ClientePanelFormularioList(modelo));
        
    }

    @Override
    protected Cliente prepararDatos() {

        Integer indice = super.getPanelCentral()
                .getTabla()
                .getSelectedRow();

        Integer dniCliente = Integer.valueOf((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 0));
        
        String nombre = ((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 1));
        
        String apellido = ((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 2));
        
        String telefono = ((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 3));

       return  new Cliente(dniCliente, nombre, apellido, telefono);

    }

}
