package com.github.rb.tplusimar2015.modelos;

import java.util.Collection;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.DAOException;

public interface ModeloDAOInterface {
		
		public void altaModelo(Modelo modelo) throws DAOException;

		public void bajaModelo(Modelo modelo) throws DAOException;

		public void modificarModelo(Modelo modelo) throws DAOException;

		public Collection<Modelo> listarModelos() throws DAOException;

		public Modelo buscarModelo(Modelo modelo) throws DAOException;

	}

