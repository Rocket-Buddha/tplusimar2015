package com.github.rb.tplusimar2015.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hsqldb.jdbcDriver;

public class HSQLDBManager implements DBManagerInterface {

	private static final String WORKSPACE = "F:/Documents/NetBeansProjects/";
	private static final String DATABASE = "TP-Lusi-MAR-2015/db_taller/";
	private static HSQLDBManager INSTANCE;

	public static HSQLDBManager getInstance() {

		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
		
	}
	
	private static void createInstance() {
		
		if (INSTANCE == null) {
			synchronized (HSQLDBManager.class) {
			
				if (INSTANCE == null) {
					INSTANCE = new HSQLDBManager();
				}
			}
		}
	}
	
	public HSQLDBManager() {
		
	}

	@Override
	public Connection getConnection() throws SQLException{
		Connection conexion = null;
		try {
			
                        //Class.forName("org.hsqldb.jdbcDriver");
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:"
					+ WORKSPACE + DATABASE, "SA", "");
			conexion.setAutoCommit(false);

		} catch (SQLException e) {
			throw new SQLException();
		}
		return conexion;
	}

	@Override
	public void closeConnection(Connection conexion) throws SQLException{
		if (conexion!=null){
			try{
				conexion.close();
			}catch(SQLException e){
				throw new SQLException(e);
			}
		}
	}

	@Override
	public void rollback(Connection conexion) throws SQLException {
		if (conexion!=null){
			try{
				conexion.rollback();
			}catch(SQLException e){
				throw new SQLException(e);
			}
		}
	}
}
