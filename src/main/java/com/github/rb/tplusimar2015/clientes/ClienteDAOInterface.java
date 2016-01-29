package com.github.rb.tplusimar2015.clientes;

import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import java.util.Collection;

public interface ClienteDAOInterface {
	
	public void altaCliente(Cliente cliente) throws DAOException;

	public void bajaCliente(Cliente cliente) throws DAOException;

	public void modificarCliente(Cliente cliente) throws DAOException;

	public Collection<Cliente> listarClientes() throws DAOException;

	public Cliente buscarCliente(Cliente cliente) throws DAOException;

}