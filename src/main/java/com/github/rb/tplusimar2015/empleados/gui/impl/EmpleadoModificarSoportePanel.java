package com.github.rb.tplusimar2015.empleados.gui.impl;

import com.github.rb.tplusimar2015.core.InterfaceModuleController;
import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.gui.PanelSoporteForm;
import com.github.rb.tplusimar2015.core.pojo.Rol;
import com.github.rb.tplusimar2015.core.pojo.Senority;

public final class EmpleadoModificarSoportePanel extends PanelSoporteForm {

    public EmpleadoModificarSoportePanel(InterfaceModuleController controller,
            Empleado empleado) throws GUIException {

        super(controller,
                new EmpleadoPanelBotoneraForm(),
                new EmpleadoPanelFormularioForm(empleado),
                PanelSoporteForm.Tipo.MODIFICACION);
    }

    @Override
    protected Object prepararDatos() {

        PanelFormularioForm panelCentral = super.getPanelCentral();

        Integer nLegajo = Integer.valueOf(((EmpleadoPanelFormularioForm) panelCentral)
                .getJtfNLegajo()
                .getText());

        Integer dni = Integer.valueOf(((EmpleadoPanelFormularioForm) panelCentral)
                .getJtfDni()
                .getText());

        String nombre = ((EmpleadoPanelFormularioForm) panelCentral)
                .getJtfNombre()
                .getText();

        String apellido = ((EmpleadoPanelFormularioForm) panelCentral).getJtfApellido()
                .getText();

        String telefono = ((EmpleadoPanelFormularioForm) panelCentral).getJtfTelefono()
                .getText();

        String direccion = ((EmpleadoPanelFormularioForm) panelCentral).getJtfDireccion()
                .getText();

        Rol rol = (Rol) ((EmpleadoPanelFormularioForm) panelCentral).getJcbRol()
                .getSelectedItem();

        Senority senority = (Senority) ((EmpleadoPanelFormularioForm) panelCentral).getJcbSenority()
                .getSelectedItem();

        Empleado empleado = new Empleado(nLegajo,
                direccion,
                senority,
                rol,
                dni,
                nombre,
                apellido,
                telefono);

        return empleado;
    }
}
