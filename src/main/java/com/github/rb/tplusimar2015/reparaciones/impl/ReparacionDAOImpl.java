package com.github.rb.tplusimar2015.reparaciones.impl;

import com.github.rb.tplusimar2015.core.pojo.Auto;
import com.github.rb.tplusimar2015.core.pojo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.github.rb.tplusimar2015.utils.DBManagerInterface;
import com.github.rb.tplusimar2015.utils.HSQLDBManager;
import com.github.rb.tplusimar2015.core.pojo.Reparacion;
import com.github.rb.tplusimar2015.core.pojo.Vehiculo;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.reparaciones.ReparacionDAOInterface;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class ReparacionDAOImpl implements ReparacionDAOInterface {

    private static ReparacionDAOImpl INSTANCE;

    public static ReparacionDAOImpl getInstance() {

        synchronized (ReparacionDAOImpl.class) {

            INSTANCE = (INSTANCE == null) ? new ReparacionDAOImpl() : INSTANCE;
        }
        return INSTANCE;

    }

    @Override
    public void altaReparacion(Reparacion reparacion) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            reparacion.setFechaEntrada(new Date(System.currentTimeMillis()));
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("INSERT INTO TB_REPARACIONES (VEHICULO, FECHA_ENTRADA) VALUES (?,?)");

            preparedstatement.setString(1, reparacion.getVehiculo().getPatente());
            preparedstatement.setString(2, formatoFecha.format(reparacion.getFechaEntrada()));

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
    public void bajaReparacion(Reparacion reparacion) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("DELETE FROM TB_REPARACION WHERE N_REPARACION = ?");

            preparedstatement.setInt(1, reparacion.getNumeroReparacion());

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
    public void modificarReparacion(Reparacion reparacion) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("UPDATE TB_REPARACIONES SET VEHICULO = ?, MECANICO = ?, FECHA_ENTRADA = ?, PRESUPUESTO = ?, DETALLE = ?, FECHA_SALIDA = ? WHERE N_REPARACION = ?");

            preparedstatement.setString(1, reparacion.getVehiculo().getPatente());
            preparedstatement.setInt(2, reparacion.getMecanico().getLegajo());
            preparedstatement.setDate(3, (Date) reparacion.getFechaEntrada());
            preparedstatement.setDouble(4, reparacion.getPresupuesto());
            preparedstatement.setString(5, reparacion.getDetalle());
            preparedstatement.setDate(6, (Date) reparacion.getFechaSalida());
            preparedstatement.setInt(7, reparacion.getNumeroReparacion());

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

    public void asignarMecanico(Reparacion reparacion) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("UPDATE TB_REPARACIONES SET MECANICO = ? WHERE N_REPARACION = ?");

            preparedstatement.setInt(1, reparacion.getMecanico().getLegajo());
            preparedstatement.setInt(2, reparacion.getNumeroReparacion());

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

    public void presupuestar(Reparacion reparacion) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("UPDATE TB_REPARACIONES SET PRESUPUESTO = ? WHERE N_REPARACION = ?");

            preparedstatement.setDouble(1, reparacion.getPresupuesto());
            preparedstatement.setInt(2, reparacion.getNumeroReparacion());

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
    public Collection<Reparacion> listarReparaciones() throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;
        Collection<Reparacion> listaReparacionesResultado = new ArrayList<>();

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("SELECT * FROM TB_REPARACIONES");
            ResultSet resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {

                Integer n_reparacion = resultSet.getInt("N_REPARACION");
                String patente = resultSet.getString("VEHICULO");
                Integer legajoMecanico = resultSet.getInt("MECANICO");
                Date fechaEntrada = resultSet.getDate("FECHA_ENTRADA");
                Double presupuesto = resultSet.getDouble("PRESUPUESTO");
                String detalle = resultSet.getString("DETALLE");
                Date fechaSalida = resultSet.getDate("FECHA_SALIDA");

                Vehiculo vehiculo = new Auto();
                Empleado mecanico = new Empleado();

                vehiculo.setPatente(patente);
                mecanico.setLegajo(legajoMecanico);

                Reparacion reparacion = new Reparacion(n_reparacion,
                        vehiculo,
                        mecanico,
                        fechaEntrada,
                        presupuesto,
                        detalle,
                        fechaSalida);

                listaReparacionesResultado.add(reparacion);
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

        return listaReparacionesResultado;
    }

    @Override
    public Reparacion buscarReparacion(Reparacion reparacion) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;
        Reparacion reparacionResultado = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("SELECT * FROM TB_REPARACIONES WHERE N_REPARACION = ?");

            preparedstatement.setInt(1, reparacion.getNumeroReparacion());

            ResultSet resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {

                Integer n_reparacion = resultSet.getInt("N_REPARACION");
                String patente = resultSet.getString("VEHICULO");
                Integer legajoMecanico = resultSet.getInt("MECANICO");
                Date fechaEntrada = resultSet.getDate("FECHA_ENTRADA");
                Double presupuesto = resultSet.getDouble("PRESUPUESTO");
                String detalle = resultSet.getString("DETALLE");
                Date fechaSalida = resultSet.getDate("FECHA_SALIDA");

                Vehiculo vehiculo = new Auto();
                Empleado mecanico = new Empleado();

                vehiculo.setPatente(patente);
                mecanico.setLegajo(legajoMecanico);

                return reparacionResultado = new Reparacion(n_reparacion,
                        vehiculo,
                        mecanico,
                        fechaEntrada,
                        presupuesto,
                        detalle,
                        fechaSalida);
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
        return reparacionResultado;
    }

    void entregar(Reparacion reparacion) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("UPDATE TB_REPARACIONES SET DETALLE = ?, FECHA_SALIDA = ? WHERE N_REPARACION = ?");

            reparacion.setFechaEntrada(new Date(System.currentTimeMillis()));
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

            preparedstatement.setString(1, reparacion.getDetalle());
            preparedstatement.setString(2, formatoFecha.format(reparacion.getFechaEntrada()));
            preparedstatement.setInt(3, reparacion.getNumeroReparacion());

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
}
