package com.github.rb.tplusimar2015.autos.impl;

import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.core.pojo.Vehiculo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public final class AutoModelo extends AbstractTableModel implements
        ComboBoxModel<Vehiculo> {

    private ArrayList<Auto> listaAutos;
    private final String[] columnas = {"PATENTE",
        "NºCHASIS",
        "NºMOTOR",
        "DESCRIPCION",
        "DNI-CLIENTE",
        "MODELO"};
    private static AutoModelo INSTANCE;
    private Auto selectedItem;

    public static AutoModelo getInstance() throws ModelException {

        synchronized (AutoModelo.class) {

            INSTANCE = (INSTANCE == null) ? new AutoModelo() : INSTANCE;
        }
        return INSTANCE;

    }

    private AutoModelo() throws ModelException {
        try {

            this.listaAutos = (ArrayList<Auto>) AutoDAOImpl.getInstance()
                    .listarAutos();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void altaAuto(Auto auto) throws ModelException {

        try {
            this.listaAutos.add(auto);

            AutoDAOImpl autoDAOImpl = AutoDAOImpl.getInstance();
            autoDAOImpl.altaAuto(auto);

            this.fireTableDataChanged();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void bajaAuto(Auto auto) throws ModelException {

        try {
            this.modeloRemover(auto);

            AutoDAOImpl autoDAOImpl = AutoDAOImpl.getInstance();
            autoDAOImpl.bajaAuto(auto);

            this.fireTableDataChanged();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    public void modificarAuto(Auto auto) throws ModelException {
        try {

            this.modeloModificar(auto);

            AutoDAOImpl autoDAOImpl = AutoDAOImpl.getInstance();
            autoDAOImpl.modificarAuto(auto);

            this.fireTableDataChanged();
        } catch (DAOException e) {
            throw new ModelException(e);
        }
    }

    // metodos help
    private void modeloRemover(Auto auto) throws ModelException {

        Auto autoI = new Auto();

        for (int i = 0; i < this.listaAutos.size(); i++) {

            autoI = this.listaAutos.get(i);

            if (autoI.getPatente().equals(auto.getPatente())) {
                this.listaAutos.remove(i);
                i = -1;
            }
        }
    }

    private void modeloModificar(Auto auto) throws ModelException {

        Auto autoI = new Auto();

        for (int i = 0; i < this.listaAutos.size(); i++) {

            autoI = this.listaAutos.get(i);

            if (autoI.getPatente().equals(auto.getPatente())) {
                this.listaAutos.set(i, auto);
            }
        }
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public int getRowCount() {
        return listaAutos.size();
    }

    @Override
    public String getColumnName(int arg0) {
        return columnas[arg0];
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {

        String stringPosicion = null;
        Auto auto = this.listaAutos.get(arg0);

        switch (arg1) {
            case 0:
                stringPosicion = auto.getPatente();
                break;
            case 1:
                stringPosicion = auto.getNumeroDeChasis();
                break;
            case 2:
                stringPosicion = auto.getNumeroDeMotor();
                break;
            case 3:
                stringPosicion = auto.getDescripcionParticular();
                break;
            case 4:
                stringPosicion = String.valueOf(auto.getCliente().getDni());
                break;
            case 5:
                stringPosicion = auto.getModelo().toString();
                break;
        }
        return stringPosicion;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = (Auto) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }

    @Override
    public int getSize() {
        return listaAutos.size();
    }

    @Override
    public Vehiculo getElementAt(int index) {
        return this.listaAutos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

}
