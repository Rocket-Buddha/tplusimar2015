package com.github.rb.tplusimar2015.empleados;

import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import java.util.Collection;

public interface EmpleadoDAOInterface {
	
	public Empleado altaEmpleado(Empleado cliente) throws DAOException;

	public void bajaEmpleado(Empleado cliente) throws DAOException;

	public void modificarEmpleado(Empleado cliente) throws DAOException;

	public Collection<Empleado> listarEmpleados() throws DAOException;

	public Empleado buscarEmpleado(Empleado cliente) throws DAOException;

}