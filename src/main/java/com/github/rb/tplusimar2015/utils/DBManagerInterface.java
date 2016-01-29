package com.github.rb.tplusimar2015.utils;

import java.sql.Connection;
import java.sql.SQLException;


public interface DBManagerInterface {

	public Connection getConnection() throws SQLException;

	public void closeConnection(Connection c) throws SQLException;

	public void rollback(Connection c) throws SQLException;
	
}