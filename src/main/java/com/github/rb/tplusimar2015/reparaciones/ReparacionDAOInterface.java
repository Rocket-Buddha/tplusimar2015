package com.github.rb.tplusimar2015.reparaciones;

import java.util.Collection;
import com.github.rb.tplusimar2015.core.pojo.Reparacion;
import com.github.rb.tplusimar2015.exceptions.DAOException;

public interface ReparacionDAOInterface {

    public void altaReparacion(Reparacion reparacion) throws DAOException;

    public void bajaReparacion(Reparacion reparacion) throws DAOException;

    public void modificarReparacion(Reparacion reparacion) throws DAOException;

    public Collection<Reparacion> listarReparaciones() throws DAOException;

    public Reparacion buscarReparacion(Reparacion reparacion) throws DAOException;

}
