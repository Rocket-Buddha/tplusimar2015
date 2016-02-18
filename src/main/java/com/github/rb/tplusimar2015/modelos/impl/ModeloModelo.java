package com.github.rb.tplusimar2015.modelos.impl;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.exceptions.ModelException;

public final class ModeloModelo extends AbstractTableModel implements ComboBoxModel<Modelo> {

    private ArrayList<Modelo> listaModelos;
    private final String[] columnas;
    private Modelo selectedItem;
    private static ModeloModelo INSTANCE;

    public static ModeloModelo getInstance() throws ModelException {

        synchronized (ModeloModelo.class) {

            INSTANCE = (INSTANCE == null) ? new ModeloModelo() : INSTANCE;
        }
        return INSTANCE;

    }

    private ModeloModelo() throws ModelException {
        this.columnas = new String[]{"NºMODELO",
            "NOMBRE",
            "DESCRIPCION",
            "MARCA"};

        try {

            this.listaModelos = (ArrayList<Modelo>) ModeloDAOImpl.getInstance().listarModelos();

        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void altaModelo(Modelo modelo) throws ModelException {

        try {
            this.listaModelos.add(modelo);

            ModeloDAOImpl modeloDAOImpl = ModeloDAOImpl.getInstance();
            modeloDAOImpl.altaModelo(modelo);

            this.listaModelos = (ArrayList<Modelo>) ModeloDAOImpl.getInstance()
                    .listarModelos(); //REFACT

            this.fireTableDataChanged();

        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void bajaModelo(Modelo modelo) throws ModelException {

        try {

            ModeloDAOImpl.getInstance()
                    .bajaModelo(modelo);

            this.modeloRemover(modelo);

            this.fireTableDataChanged();

        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void modificarModelo(Modelo modelo) throws ModelException {
        try {

            this.modeloModificar(modelo);

            ModeloDAOImpl modeloDAOImpl = ModeloDAOImpl.getInstance();
            modeloDAOImpl.modificarModelo(modelo);

            this.fireTableDataChanged();

        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    private void modeloRemover(Modelo modelo) throws ModelException {

        Modelo modeloI;

        for (int i = 0; i < this.listaModelos.size(); i++) {

            modeloI = this.listaModelos.get(i);

            if (modeloI.getN_modelo().equals(modelo.getN_modelo())) {
                this.listaModelos.remove(i);
                i = -1;
            }
        }
    }

    private void modeloModificar(Modelo modelo) throws ModelException {

        Modelo modeloI;

        for (int i = 0; i < this.listaModelos.size(); i++) {

            modeloI = this.listaModelos.get(i);

            if (modeloI.getN_modelo().equals(modelo.getN_modelo())) {
                this.listaModelos.set(i, modelo);
            }
        }
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public int getRowCount() {
        return listaModelos.size();
    }

    @Override
    public String getColumnName(int arg0) {
        return columnas[arg0];
    }

    @Override
    public Object getValueAt(int arg0,
            int arg1) {

        String stringPosicion = null;
        Modelo modelo = this.listaModelos.get(arg0);

        switch (arg1) {
            case 0:
                stringPosicion = modelo.getN_modelo().toString();
                break;
            case 1:
                stringPosicion = modelo.getNombre();
                break;
            case 2:
                stringPosicion = modelo.getDescripcion();
                break;
            case 3:
                stringPosicion = modelo.getMarca().toString();
                break;
        }
        return stringPosicion;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public Modelo getElementAt(int index) {
        return this.listaModelos.get(index);
    }

    @Override
    public int getSize() {
        return this.listaModelos.size();
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
        this.selectedItem = (Modelo) arg0;

    }
}
