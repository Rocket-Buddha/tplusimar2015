package com.github.rb.tplusimar2015.autos.impl;

import com.github.rb.tplusimar2015.core.pojo.Auto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.github.rb.tplusimar2015.autos.AutoDAOInterface;
import com.github.rb.tplusimar2015.utils.DBManagerInterface;
import com.github.rb.tplusimar2015.utils.HSQLDBManager;
import com.github.rb.tplusimar2015.core.pojo.Cliente;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.modelos.impl.ModeloDAOImpl;

public class AutoDAOImpl implements AutoDAOInterface {

	private static AutoDAOImpl INSTANCE;

	public static AutoDAOImpl getInstance() {

		if (INSTANCE == null)
			createInstance();
		return INSTANCE;

	}

	private static void createInstance() {
		
		if (INSTANCE == null) {
			synchronized (AutoDAOImpl.class) {
				
				if (INSTANCE == null) {
					INSTANCE = new AutoDAOImpl();
				}
			}
		}
	}

	@Override
	public void altaAuto(Auto auto) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;

		try {

			conexion = dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("INSERT INTO tb_autos (patente,n_chasis,n_motor,descripcion,dni_cliente,modelo) VALUES (?,?,?,?,?,?)");
			preparedstatement.setString(1, auto.getPatente());
			preparedstatement.setString(2, auto.getNumeroDeChasis());
			preparedstatement.setString(3, auto.getNumeroDeMotor());
			preparedstatement.setString(4, auto.getDescripcionParticular());
			preparedstatement.setInt(5, auto.getCliente().getDni());
			preparedstatement.setInt(6, auto.getModelo().getN_modelo());

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
	public void bajaAuto(Auto auto) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null; 

		try {
			
			conexion= dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("DELETE FROM tb_autos WHERE patente=?");
			preparedstatement.setString(1, auto.getPatente());

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
			try{
			dbManager.closeConnection(conexion);
			}catch(SQLException e3){
				throw new DAOException(e3);
			}
		}
	}

	@Override
	public void modificarAuto(Auto auto) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;

		try {
			
			conexion =  dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("UPDATE TB_AUTOS SET n_chasis=?,n_motor=?,descripcion=?,dni_cliente=?,modelo=? WHERE patente=?");
			preparedstatement.setString(1, auto.getNumeroDeChasis());
			preparedstatement.setString(2, auto.getNumeroDeMotor());
			preparedstatement.setString(3, auto.getDescripcionParticular());
			preparedstatement.setInt(4, auto.getCliente().getDni());
			preparedstatement.setInt(5, auto.getModelo().getN_modelo());
			preparedstatement.setString(6, auto.getPatente());

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
			try{
			dbManager.closeConnection(conexion);
			}catch(SQLException e3){
				throw new DAOException(e3);
			}
		}

	}

	@Override
	public Collection<Auto> listarAutos() throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null;
		Collection<Auto> listaAutosResultado = new ArrayList<Auto>();

		try {
			
			conexion = dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("SELECT * FROM TB_AUTOS");
			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {

				String patente = resultSet.getString("patente");
				String nChasis = resultSet.getString("n_chasis");
				String nMotor = resultSet.getString("n_motor");
				String descripcion = resultSet.getString("descripcion");
				Integer dniCliente = resultSet.getInt("dni_cliente");
				Integer nModelo = resultSet.getInt("modelo");

				Auto auto = new Auto();
				Cliente cliente = new Cliente(dniCliente);
				
				Modelo modelo= new Modelo();
				modelo.setN_modelo(nModelo);

				auto.setCliente(cliente);
				auto.setDescripcionParticular(descripcion);
				auto.setModelo(ModeloDAOImpl.getInstance().buscarModelo(modelo));
				auto.setNumeroDeChasis(nChasis);
				auto.setNumeroDeMotor(nMotor);
				auto.setPatente(patente);

				listaAutosResultado.add(auto);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try{
			dbManager.closeConnection(conexion);
			}catch(SQLException e3){
				throw new DAOException(e3);
			}
		}

		return listaAutosResultado;
	}

	@Override
	public Auto buscarAuto(Auto auto) throws DAOException {

		DBManagerInterface dbManager = HSQLDBManager.getInstance();
		Connection conexion = null; 
		Auto autoResultado = new Auto();

		try {
			
			conexion=dbManager.getConnection();
			PreparedStatement preparedstatement = conexion
					.prepareStatement("SELECT * FROM TB_AUTOS WHERE PATENTE=?");
			preparedstatement.setString(1, auto.getPatente());
			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {

				String patente = resultSet.getString("patente");
				String nChasis = resultSet.getString("n_chasis");
				String nMotor = resultSet.getString("n_motor");
				String descripcion = resultSet.getString("descripcion");
				Integer dniCliente = resultSet.getInt("dni_cliente");
				Integer nModelo = resultSet.getInt("modelo");

				Cliente cliente = new Cliente(dniCliente);

				Modelo modelo= new Modelo();
				modelo.setN_modelo(nModelo);

				autoResultado.setCliente(cliente);
				autoResultado.setDescripcionParticular(descripcion);
				autoResultado.setModelo(ModeloDAOImpl.getInstance().buscarModelo(modelo));
				autoResultado.setNumeroDeChasis(nChasis);
				autoResultado.setNumeroDeMotor(nMotor);
				autoResultado.setPatente(patente);

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			try{
			dbManager.closeConnection(conexion);
			}catch(SQLException e3){
				throw new DAOException(e3);
			}
		}
		return autoResultado;
	}

}
