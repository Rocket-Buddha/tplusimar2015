package com.github.rb.tplusimar2015.clientes.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.github.rb.tplusimar2015.clientes.ClienteDAOInterface;
import com.github.rb.tplusimar2015.utils.DBManagerInterface;
import com.github.rb.tplusimar2015.utils.HSQLDBManager;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.exceptions.DAOException;

public class ClienteDAOImpl implements ClienteDAOInterface {

	private static ClienteDAOImpl INSTANCE;

	public static ClienteDAOImpl getInstance() {

		if (INSTANCE == null)
			createInstance();
		return INSTANCE;

	}

	private static void createInstance() {

		
		if (INSTANCE == null) {
			synchronized (ClienteDAOImpl.class) {
			
				if (INSTANCE == null) {
					INSTANCE = new ClienteDAOImpl();
				}
			}
		}
	}

	@Override
	public void altaCliente(Cliente cliente) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;

		try {

			conexion = dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("INSERT INTO tb_clientes (dni, nombre, apellido, telefono) VALUES (?,?,?,?)");
			preparedstatement.setInt(1, cliente.getDni());
			preparedstatement.setString(2, cliente.getNombre());
			preparedstatement.setString(3, cliente.getApellido());
			preparedstatement.setString(4, cliente.getTelefono());

			preparedstatement.executeUpdate();

			conexion.commit();
			dbManager.closeConnection(conexion);

		} catch (SQLException e) {
			try {
				conexion.rollback();
				throw new DAOException(e);
			} catch (SQLException e1) {
				throw new DAOException(e1);
			}
		} finally {
			try {
				dbManager.closeConnection(conexion);
			} catch (SQLException e2) {
				throw new DAOException(e2);
			}
		}
	}

	@Override
	public void bajaCliente(Cliente cliente) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;

		try {

			conexion = dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("DELETE FROM tb_clientes WHERE dni=?");
			preparedstatement.setInt(1, cliente.getDni());

			preparedstatement.executeUpdate();

			conexion.commit();
			dbManager.closeConnection(conexion);

		} catch (SQLException e) {
			try {
				conexion.rollback();
				throw new DAOException(e);
			} catch (SQLException e1) {
				throw new DAOException(e);
			}
		} finally {
			try {
				dbManager.closeConnection(conexion);
			} catch (SQLException e3) {
				throw new DAOException(e3);
			}
		}
	}

	@Override
	public void modificarCliente(Cliente cliente) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;

		try {

			conexion = dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("UPDATE TB_CLIENTES SET nombre=?,apellido=?,telefono=? WHERE dni=?");
			preparedstatement.setString(1, cliente.getNombre());
			preparedstatement.setString(2, cliente.getApellido());
			preparedstatement.setString(3, cliente.getTelefono());
			preparedstatement.setInt(4, cliente.getDni());

			preparedstatement.executeUpdate();

			conexion.commit();
			dbManager.closeConnection(conexion);

		} catch (SQLException e) {
			try {
				conexion.rollback();
				throw new DAOException(e);
			} catch (SQLException e1) {
				throw new DAOException(e1);
			}
		} finally {
			try {
				dbManager.closeConnection(conexion);
			} catch (SQLException e3) {
				throw new DAOException(e3);
			}
		}

	}

	@Override
	public Collection<Cliente> listarClientes() throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;
		Collection<Cliente> listaClientesResultado = new ArrayList<Cliente>();

		try {

			conexion = dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("SELECT * FROM TB_CLIENTES");
			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {

				Integer dni = resultSet.getInt("dni");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String telefono = resultSet.getString("telefono");
				

				Cliente cliente = new Cliente(dni, nombre, apellido, telefono);

				listaClientesResultado.add(cliente);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				dbManager.closeConnection(conexion);
			} catch (SQLException e3) {
				throw new DAOException(e3);
			}
		}

		return listaClientesResultado;
	}

	@Override
	public Cliente buscarCliente(Cliente cliente) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;

		try {

			conexion = dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("SELECT * FROM TB_CLIENTES WHERE DNI=?");
			preparedstatement.setInt(1, cliente.getDni());
			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {

				//Integer dni = resultSet.getInt("dni");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String telefono = resultSet.getString("telefono");

				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setTelefono(telefono);

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				dbManager.closeConnection(conexion);
			} catch (SQLException e3) {
				throw new DAOException(e3);
			}
		}
		return cliente;
	}

}