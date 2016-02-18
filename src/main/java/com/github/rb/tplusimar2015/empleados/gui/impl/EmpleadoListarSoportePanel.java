package com.github.rb.tplusimar2015.empleados.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteList;
import com.github.rb.tplusimar2015.core.pojo.Rol;
import com.github.rb.tplusimar2015.core.pojo.Senority;
import javax.swing.table.AbstractTableModel;

public final class EmpleadoListarSoportePanel extends PanelSoporteList {

    public EmpleadoListarSoportePanel(InterfaceModuleController controller,
            AbstractTableModel modelo) {
        
        super(controller,
                new EmpleadoPanelBotoneraList(),
                new EmpleadoPanelFormularioList(modelo));
    }

    @Override
    protected Empleado prepararDatos() {

        Integer indice = super.getPanelCentral()
                .getTabla()
                .getSelectedRow();

        Integer nLegajo = Integer.valueOf((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 0));

        Integer dniEmpleado = Integer.valueOf((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 1));

        String nombre = ((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 2));

        String apellido = ((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 3));

        String telefono = ((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 4));

        String direccion = ((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 5));

        Rol rol = Rol.valueOf(((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 6)));

        Senority senority = Senority.valueOf(((String) super.getPanelCentral()
                .getTabla()
                .getModel()
                .getValueAt(indice, 7)));

        return new Empleado(nLegajo,
                direccion,
                senority,
                rol,
                dniEmpleado,
                nombre,
                apellido,
                telefono);
    }
}
