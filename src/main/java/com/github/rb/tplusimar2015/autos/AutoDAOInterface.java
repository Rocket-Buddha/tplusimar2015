package com.github.rb.tplusimar2015.autos;

import java.util.Collection;

import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.exceptions.DAOException;

public interface AutoDAOInterface {

	public void altaAuto(Auto auto) throws DAOException;

	public void bajaAuto(Auto auto) throws DAOException;

	public void modificarAuto(Auto auto) throws DAOException;

	public Collection<Auto> listarAutos() throws DAOException;

	public Auto buscarAuto(Auto auto) throws DAOException;

}
