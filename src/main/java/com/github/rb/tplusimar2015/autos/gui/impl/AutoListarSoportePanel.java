package com.github.rb.tplusimar2015.autos.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.core.pojo.Modelo;

import com.github.rb.tplusimar2015.core.gui.PanelSoporteList;
import javax.swing.table.AbstractTableModel;

public class AutoListarSoportePanel extends PanelSoporteList {

    public AutoListarSoportePanel(InterfaceModuleController controller,
                                  AbstractTableModel modelo){
        
        super(controller, new AutoPanelBotoneraList(),new AutoPanelFormularioList(modelo));
        
    }

    @Override
    protected Auto prepararDatos() {

        Integer indice = super.getPanelCentral().getTabla().getSelectedRow();

        String patente = (String) (super.getPanelCentral().getTabla()
                .getValueAt(indice, 0));
        String nChasis = (String) (super.getPanelCentral().getTabla()
                .getValueAt(indice, 1));
        String nMotor = (String) (super.getPanelCentral().getTabla()
                .getValueAt(indice, 2));
        String descripcion = (String) (super.getPanelCentral().getTabla()
                .getValueAt(indice, 3));
        Integer dniCliente = Integer.valueOf((String) (super.getPanelCentral()
                .getTabla().getValueAt(indice, 4)));
        String modelo = (String) (super.getPanelCentral().getTabla()
                .getValueAt(indice, 5));

        Auto autoRetorno = new Auto();
        Cliente cliente = new Cliente();
        Modelo oModelo = new Modelo();

        cliente.setDni(dniCliente);
        oModelo.setDescripcion(modelo);

        autoRetorno.setPatente(patente);
        autoRetorno.setCliente(cliente);
        autoRetorno.setDescripcionParticular(descripcion);
        autoRetorno.setModelo(oModelo);
        autoRetorno.setNumeroDeChasis(nChasis);
        autoRetorno.setNumeroDeMotor(nMotor);

        return autoRetorno;
    }
}
