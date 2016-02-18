package com.github.rb.tplusimar2015.modelos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.github.rb.tplusimar2015.utils.DBManagerInterface;
import com.github.rb.tplusimar2015.utils.HSQLDBManager;
import com.github.rb.tplusimar2015.core.pojo.Marca;
import com.github.rb.tplusimar2015.core.pojo.Modelo;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.modelos.ModeloDAOInterface;

public final class ModeloDAOImpl implements ModeloDAOInterface {

    private static ModeloDAOImpl INSTANCE;

    public static ModeloDAOImpl getInstance() {

        synchronized (ModeloDAOImpl.class) {

            INSTANCE = (INSTANCE == null) ? new ModeloDAOImpl() : INSTANCE;
        }
        return INSTANCE;

    }

    @Override
    public void altaModelo(Modelo modelo) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("INSERT INTO TB_MODELOS (NOMBRE, DESCRIPCION, MARCA) VALUES (?,?,?)");

            preparedstatement.setString(1, modelo.getNombre());
            preparedstatement.setString(2, modelo.getDescripcion());
            preparedstatement.setInt(3, modelo.getMarca().getCodigo());

            preparedstatement.executeUpdate();

            conexion.commit();
            dbManager.closeConnection(conexion);

        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
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
    public void bajaModelo(Modelo modelo) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("DELETE FROM TB_MODELOS WHERE N_MODELO = ?");
            
            preparedstatement.setInt(1, modelo.getN_modelo());

            preparedstatement.executeUpdate();

            conexion.commit();
            dbManager.closeConnection(conexion);

        } catch (SQLException e) {
            try {
                 if (conexion != null) {
                conexion.rollback();
                 }
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
    public void modificarModelo(Modelo modelo) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("UPDATE TB_MODELOS SET NOMBRE = ?, DESCRIPCION = ?, MARCA = ? WHERE N_MODELO = ?");

            preparedstatement.setString(1, modelo.getNombre());
            preparedstatement.setString(2, modelo.getDescripcion());
            preparedstatement.setInt(3, modelo.getMarca().getCodigo());
            preparedstatement.setInt(4, modelo.getN_modelo());

            preparedstatement.executeUpdate();

            conexion.commit();
            dbManager.closeConnection(conexion);

        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                    throw new DAOException(e);
                }
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
    public Collection<Modelo> listarModelos() throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;
        Collection<Modelo> listaModelosResultado = new ArrayList<>();

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("SELECT * FROM TB_MODELOS");
            ResultSet resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {

                Integer n_modelo = resultSet.getInt("N_MODELO");
                String nombre = resultSet.getString("NOMBRE");
                String descripcion = resultSet.getString("DESCRIPCION");
                Marca marca = Marca.getMarca((resultSet.getInt("MARCA")));

                Modelo modelo = new Modelo(n_modelo,
                        nombre,
                        descripcion,
                        marca);

                listaModelosResultado.add(modelo);
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

        return listaModelosResultado;
    }

    @Override
    public Modelo buscarModelo(Modelo modelo) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;
        Modelo modeloResultado = new Modelo();

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("SELECT * FROM TB_MODELOS WHERE N_MODELO = ?");
            preparedstatement.setInt(1, modelo.getN_modelo());
            ResultSet resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {

                Integer nModelo = resultSet.getInt("N_MODELO");
                String nombre = resultSet.getString("NOMBRE");
                String descripcion = resultSet.getString("DESCRIPCION");
                Marca marca = Marca.getMarca(resultSet.getInt("MARCA"));

                modeloResultado.setN_modelo(nModelo);
                modeloResultado.setNombre(nombre);
                modeloResultado.setDescripcion(descripcion);
                modeloResultado.setMarca(marca);
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
        return modeloResultado;
    }
}
