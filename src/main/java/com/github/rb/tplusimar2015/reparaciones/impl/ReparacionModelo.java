package com.github.rb.tplusimar2015.reparaciones.impl;

import com.github.rb.tplusimar2015.core.pojo.Reparacion;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.exceptions.ModelException;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class ReparacionModelo extends AbstractTableModel implements ComboBoxModel<Reparacion>{

	private ArrayList<Reparacion> listaReparaciones;
	private String[] columnas = { "N°REPARACION", "VEHICULO", "MECANICO","FECHA ENTRADA", "PRESUPUESTO", "DETALLE", "FECHA SALIDA"};
	private static ReparacionModelo INSTANCE;
        private Reparacion selectedItem;

	public static ReparacionModelo getInstance() throws ModelException {

		if (INSTANCE == null)
			createInstance();
		return INSTANCE;

	}

	private static void createInstance() throws ModelException {
		// S�lo se accede a la zona sincronizada cuando la instancia no est�
		// creada
		if (INSTANCE == null) {
			synchronized (ReparacionModelo.class) {
				// En la zona sincronizada ser�a necesario volver a comprobar
				// que no se ha creado la instancia.
				if (INSTANCE == null) {
					INSTANCE = new ReparacionModelo();
				}
			}
		}
	}

	private ReparacionModelo() throws ModelException {
		try {

			this.listaReparaciones = (ArrayList<Reparacion>) ReparacionDAOImpl.getInstance()
					.listarReparaciones();
		} catch (DAOException e) {
			throw new ModelException(e);
		}
	}

	public void altaReparacion(Reparacion reparacion) throws ModelException {

		try {
			//this.listaReparaciones.add(reparacion);
			ReparacionDAOImpl
                                .getInstance()
                                .altaReparacion(reparacion);
                        //refactorizar muy chino
                        this.listaReparaciones = (ArrayList<Reparacion>) ReparacionDAOImpl.getInstance()
					.listarReparaciones();
			//this.fireTableDataChanged();
                        
		} catch (DAOException e) {
			throw new ModelException(e);
		}
	}

	public void bajaReparacion(Reparacion reparacion) throws ModelException {

		try {
			this.modeloRemover(reparacion);

			ReparacionDAOImpl reparacionDAOImpl = ReparacionDAOImpl.getInstance();
			reparacionDAOImpl.bajaReparacion(reparacion);

			this.fireTableDataChanged();
		} catch (DAOException e) {
			throw new ModelException(e);
		}
	}

	public void modificarReparacion(Reparacion reparacion) throws ModelException {
		try {

			this.modeloModificar(reparacion);

			ReparacionDAOImpl reparacionDAOImpl = ReparacionDAOImpl.getInstance();
			reparacionDAOImpl.modificarReparacion(reparacion);

			this.fireTableDataChanged();
		} catch (DAOException e) {
			throw new ModelException(e);
		}
	}

	// metodos help

	private void modeloRemover(Reparacion reparacion) throws ModelException {

		Reparacion reparacionI;

		for (int i = 0; i < this.listaReparaciones.size(); i++) {

			reparacionI = this.listaReparaciones.get(i);

			if (reparacionI.getNumeroReparacion().equals(reparacion.getNumeroReparacion())) {
				this.listaReparaciones.remove(i);
				i = -1;
			}
		}
	}

	private void modeloModificar(Reparacion reparacion) throws ModelException {

		Reparacion reparacionI;

		for (int i = 0; i < this.listaReparaciones.size(); i++) {

			reparacionI = this.listaReparaciones.get(i);

			if (reparacionI.getNumeroReparacion().equals(reparacion.getNumeroReparacion())) {
				this.listaReparaciones.set(i, reparacion);
			}
		}
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return listaReparaciones.size();
	}

	@Override
	public String getColumnName(int arg0) {
		return columnas[arg0];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {

		String stringPosicion = null;
		Reparacion reparacion = this.listaReparaciones.get(arg0);

		switch (arg1) {
		case 0:
                        stringPosicion = (reparacion.getNumeroReparacion() == null) ? "-" : reparacion.getNumeroReparacion().toString();
			break;
		case 1:
                        stringPosicion = (reparacion.getVehiculo() == null) ? "-" : reparacion.getVehiculo().getPatente();
			break;
		case 2:
                        stringPosicion = (reparacion.getMecanico().getLegajo() == 0) ? "-" : reparacion.getMecanico().getLegajo().toString();
			break;
		case 3:
                        stringPosicion = (reparacion.getFechaEntrada() == null) ? "-" : reparacion.getFechaEntrada().toString();
			break;
                case 4:
                        stringPosicion = (reparacion.getPresupuesto() == 0) ? "-" : reparacion.getPresupuesto().toString();
			break;
                case 5:
                        stringPosicion = (reparacion.getDetalle() == null) ? "-" : reparacion.getDetalle();
			break;
                case 6:
                        stringPosicion = (reparacion.getFechaSalida() == null) ? "-" : reparacion.getFechaSalida().toString();
			break;
                    
		}
		return stringPosicion;
	}

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = (Reparacion) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }

    @Override
    public int getSize() {
        return this.listaReparaciones.size();
    }

    @Override
    public Reparacion getElementAt(int index) {
        return this.listaReparaciones.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }

    void asignarMecanico(Reparacion reparacion) throws ModelException {
       try {

			//this.modeloModificar(reparacion);

			ReparacionDAOImpl reparacionDAOImpl = ReparacionDAOImpl.getInstance();
			reparacionDAOImpl.asignarMecanico(reparacion);
                        
                         this.listaReparaciones = (ArrayList<Reparacion>) ReparacionDAOImpl.getInstance()
					.listarReparaciones();

			//this.fireTableDataChanged();
		} catch (DAOException e) {
			throw new ModelException(e);
		}
    }

    void presupuestar(Reparacion reparacion) throws ModelException {
        try {

			//this.modeloModificar(reparacion);

			ReparacionDAOImpl reparacionDAOImpl = ReparacionDAOImpl.getInstance();
			reparacionDAOImpl.presupuestar(reparacion);
                        
                         this.listaReparaciones = (ArrayList<Reparacion>) ReparacionDAOImpl.getInstance()
					.listarReparaciones();

			//this.fireTableDataChanged();
		} catch (DAOException e) {
			throw new ModelException(e);
		}
    }
    
    void entregar(Reparacion reparacion) throws ModelException {
        try {

			//this.modeloModificar(reparacion);

			ReparacionDAOImpl reparacionDAOImpl = ReparacionDAOImpl.getInstance();
			reparacionDAOImpl.entregar(reparacion);
                        
                         this.listaReparaciones = (ArrayList<Reparacion>) ReparacionDAOImpl.getInstance()
					.listarReparaciones();

			//this.fireTableDataChanged();
		} catch (DAOException e) {
			throw new ModelException(e);
		}
    }
}
