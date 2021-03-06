package com.github.rb.tplusimar2015.clientes.impl;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.exceptions.ModelException;

public final class ClienteModelo extends AbstractTableModel implements
        ComboBoxModel<Cliente> {

    private ArrayList<Cliente> listaClientes;
    private final String[] columnas;
    private Cliente selectedItem;
    private static ClienteModelo INSTANCE;

    public static ClienteModelo getInstance() throws ModelException {

        synchronized (ClienteModelo.class) {

            INSTANCE = (INSTANCE == null) ? new ClienteModelo() : INSTANCE;
        }
        return INSTANCE;
    }

    private ClienteModelo() throws ModelException {
        this.columnas = new String[]{"DNI", "NOMBRE", "APELLIDO", "TELEFONO"};
        try {
            this.listaClientes = (ArrayList<Cliente>) ClienteDAOImpl
                    .getInstance().listarClientes();

        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void altaCliente(Cliente cliente) throws ModelException {

        try {
            this.listaClientes.add(cliente);

            ClienteDAOImpl clienteDAOImpl = ClienteDAOImpl.getInstance();
            clienteDAOImpl.altaCliente(cliente);

            this.fireTableDataChanged();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void bajaCliente(Cliente cliente) throws ModelException {

        try {
            this.modeloRemover(cliente);

            ClienteDAOImpl clienteDAOImpl = ClienteDAOImpl.getInstance();
            clienteDAOImpl.bajaCliente(cliente);

            this.fireTableDataChanged();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void modificarCliente(Cliente cliente) throws ModelException {
        try {

            this.modeloModificar(cliente);

            ClienteDAOImpl clienteDAOImpl = ClienteDAOImpl.getInstance();
            clienteDAOImpl.modificarCliente(cliente);

            this.fireTableDataChanged();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    private void modeloRemover(Cliente cliente) throws ModelException {

        Cliente clienteI;

        for (int i = 0; i < this.listaClientes.size(); i++) {

            clienteI = this.listaClientes.get(i);

            if (clienteI.getDni().equals(cliente.getDni())) {
                this.listaClientes.remove(i);
                i = -1;
            }
        }
    }

    private void modeloModificar(Cliente cliente) throws ModelException {

        Cliente clienteI;

        for (int i = 0; i < this.listaClientes.size(); i++) {

            clienteI = this.listaClientes.get(i);

            if (clienteI.getDni().equals(cliente.getDni())) {
                this.listaClientes.set(i, cliente);
            }
        }
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public String getColumnName(int arg0) {
        return columnas[arg0];
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {

        String stringPosicion = null;
        Cliente cliente = this.listaClientes.get(arg0);

        switch (arg1) {
            case 0:
                stringPosicion = String.valueOf(cliente.getDni());
                break;
            case 1:
                stringPosicion = cliente.getNombre();
                break;
            case 2:
                stringPosicion = cliente.getApellido();
                break;
            case 3:
                stringPosicion = cliente.getTelefono();
                break;
        }
        return stringPosicion;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public Cliente getElementAt(int index) {
        return this.listaClientes.get(index);
    }

    @Override
    public int getSize() {
        return this.listaClientes.size();
    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }

    @Override
    public void setSelectedItem(Object arg0) {
        this.selectedItem = (Cliente) arg0;

    }

}
