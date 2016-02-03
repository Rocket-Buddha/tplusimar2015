package com.github.rb.tplusimar2015.empleados.impl;

import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.core.pojo.Rol;
import com.github.rb.tplusimar2015.core.pojo.Senority;
import com.github.rb.tplusimar2015.empleados.EmpleadoDAOInterface;
import com.github.rb.tplusimar2015.exceptions.DAOException;
import com.github.rb.tplusimar2015.utils.DBManagerInterface;
import com.github.rb.tplusimar2015.utils.HSQLDBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EmpleadoDAOImpl implements EmpleadoDAOInterface {

    private static EmpleadoDAOImpl INSTANCE;
    

    public static EmpleadoDAOImpl getInstance() {
        synchronized (EmpleadoDAOImpl.class) {

            INSTANCE = (INSTANCE == null) ? new EmpleadoDAOImpl() : INSTANCE;
        }
        return INSTANCE;
    }

    /**
     *
     * @param empleado
     * @throws DAOException
     */
    @Override
    public void altaEmpleado(Empleado empleado) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("INSERT INTO TB_EMPLEADOS ( DNI, NOMBRE, APELLIDO, TELEFONO, DIRECCION, ROL, SENORITY) VALUES (?, ?, ?, ?, ?, ?, ?)");
                      

            preparedstatement.setInt(1, empleado.getDni());
            preparedstatement.setString(2, empleado.getNombre());
            preparedstatement.setString(3, empleado.getApellido());
            preparedstatement.setString(4, empleado.getTelefono());
            preparedstatement.setString(5, empleado.getDireccion());
            preparedstatement.setString(6, empleado.getRol().toString());
            preparedstatement.setString(7, empleado.getSenority().toString());

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
    public void bajaEmpleado(Empleado empleado) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("DELETE FROM TB_EMPLEADOS\n"
                            + "WHERE N_LEGAJO = ?");

            preparedstatement.setInt(1, empleado.getLegajo());

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
    public void modificarEmpleado(Empleado empleado) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();
            PreparedStatement preparedstatement = conexion
                    .prepareStatement("UPDATE TB_EMPLEADOS \n"
                            + "SET DNI = ?, NOMBRE = ?, APELLIDO = ?, TELEFONO = ?, DIRECCION = ?, ROL = ?, SENORITY = ? \n"
                            + "WHERE N_LEGAJO = ? ");

            preparedstatement.setInt(1, empleado.getDni());
            preparedstatement.setString(2, empleado.getNombre());
            preparedstatement.setString(3, empleado.getApellido());
            preparedstatement.setString(4, empleado.getTelefono());
            preparedstatement.setString(5, empleado.getDireccion());
            preparedstatement.setString(6, empleado.getRol().toString());
            preparedstatement.setString(7, empleado.getSenority().toString());
            preparedstatement.setInt(8, empleado.getLegajo());

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
    public Collection<Empleado> listarEmpleados() throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;
        Collection<Empleado> listaEmpleadosResultado = new ArrayList<>();

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("SELECT *\n"
                            + "FROM TB_EMPLEADOS");

            ResultSet resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {

                Integer nLegajo = resultSet.getInt("N_LEGAJO");
                Integer dni = resultSet.getInt("DNI");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                String telefono = resultSet.getString("TELEFONO");
                String direccion = resultSet.getString("DIRECCION");
                Rol rol = Rol.valueOf(resultSet.getString("ROL"));
                Senority senority = Senority.valueOf(resultSet.getString("SENORITY"));
                
               listaEmpleadosResultado.add(new Empleado(nLegajo,
                        direccion,
                        senority,
                        rol,
                        dni,
                        nombre,
                        apellido,
                        telefono));

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

        return listaEmpleadosResultado;
    }

    @Override
    public Empleado buscarEmpleado(Empleado empleado) throws DAOException {

        DBManagerInterface dbManager = HSQLDBManager.getInstance();
        Connection conexion = null;

        try {

            conexion = dbManager.getConnection();

            PreparedStatement preparedstatement = conexion
                    .prepareStatement("SELECT *\n" 
                            +"FROM TB_EMPLEADOS\n" 
                            +"WHERE N_LEGAJO = ?");
            
            preparedstatement.setInt(1, empleado.getLegajo());

            ResultSet resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {

                Integer nLegajo = resultSet.getInt("N_LEGAJO");
                Integer dni = resultSet.getInt("DNI");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                String telefono = resultSet.getString("TELEFONO");
                String direccion = resultSet.getString("DIRECCION");
                Rol rol = Rol.valueOf(resultSet.getString("ROL"));
                Senority senority = Senority.valueOf(resultSet.getString("SENORITY"));

                empleado.setDni(dni);
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setTelefono(telefono);
                empleado.setDireccion(direccion);
                empleado.setRol(rol);
                empleado.setSenority(senority);
             
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
        return empleado;
    }
}
