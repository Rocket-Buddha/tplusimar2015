package com.github.rb.tplusimar2015.empleados.impl;

import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;

public class EmpleadoModelo extends AbstractTableModel implements
        ComboBoxModel<Empleado> {

    private ArrayList<Empleado> listaEmpleados;
    private String[] columnas = {"LEGAJO", "DNI", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "ROL", "SENORITY"};
    private Empleado selectedItem;
    private static EmpleadoModelo INSTANCE;

    public static EmpleadoModelo getInstance() {
        synchronized (EmpleadoModelo.class) {

            INSTANCE = (INSTANCE == null) ? new EmpleadoModelo() : INSTANCE;
        }
        return INSTANCE;
    }

    private EmpleadoModelo() {

        try {
            this.listaEmpleados = (ArrayList<Empleado>) EmpleadoDAOImpl
                    .getInstance().listarEmpleados();
        } catch (DAOException e) {
            //throw new ModelException(e);
        }
    }

    public void altaEmpleado(Empleado empleado) throws ModelException, DAOException {

        EmpleadoDAOImpl empleadoDAOImpl = EmpleadoDAOImpl.getInstance();
        empleadoDAOImpl.altaEmpleado(empleado);
        this.fireTableDataChanged();
    }

    public void bajaEmpleado(Empleado empleado) throws ModelException {

        try {
            this.modeloRemover(empleado);

            EmpleadoDAOImpl empleadoDAOImpl = EmpleadoDAOImpl.getInstance();
            empleadoDAOImpl.bajaEmpleado(empleado);

            this.fireTableDataChanged();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void modificarEmpleado(Empleado empleado) throws ModelException {
        try {

            this.modeloModificar(empleado);

            EmpleadoDAOImpl empleadoDAOImpl = EmpleadoDAOImpl.getInstance();
            empleadoDAOImpl.modificarEmpleado(empleado);

            this.fireTableDataChanged();
            
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    // metodos help
    private void modeloRemover(Empleado empleado) throws ModelException {

        Empleado empleadoI = new Empleado();

        for (int i = 0; i < this.listaEmpleados.size(); i++) {

            empleadoI = this.listaEmpleados.get(i);

            if (empleadoI.getLegajo().equals(empleado.getLegajo())) {
                this.listaEmpleados.remove(i);
                i = -1;
            }
        }
    }

    private void modeloModificar(Empleado empleado) throws ModelException {

        Empleado empleadoI = new Empleado();

        for (int i = 0; i < this.listaEmpleados.size(); i++) {

            empleadoI = this.listaEmpleados.get(i);

            if (empleadoI.getDni().equals(empleado.getDni())) {
                this.listaEmpleados.set(i, empleado);
            }
        }
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public int getRowCount() {
        return listaEmpleados.size();
    }

    @Override
    public String getColumnName(int arg0) {
        return columnas[arg0];
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {

        String stringPosicion = null;
        Empleado empleado = this.listaEmpleados.get(arg0);
//{"LEGAJO", "DNI", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "ROL", "SENORITY"};
        switch (arg1) {
            case 0:
                stringPosicion = String.valueOf(empleado.getLegajo());
                break;
            case 1:
                stringPosicion = String.valueOf(empleado.getDni());
                break;
            case 2:
                stringPosicion = empleado.getNombre();
                break;
            case 3:
                stringPosicion = empleado.getApellido();
                break;
            case 4:
                stringPosicion = empleado.getTelefono();
                break;
            case 5:
                stringPosicion = empleado.getDireccion();
                break;
            case 6:
                stringPosicion = empleado.getRol().toString();
                break;
            case 7:
                stringPosicion = empleado.getSenority().toString();
                break;
        }
        return stringPosicion;
    }

    // ///////////////////////
    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public Empleado getElementAt(int index) {
        return this.listaEmpleados.get(index);
    }

    @Override
    public int getSize() {
        return this.listaEmpleados.size();
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }

    @Override
    public void setSelectedItem(Object arg0) {
        this.selectedItem = (Empleado) arg0;

    }

}
