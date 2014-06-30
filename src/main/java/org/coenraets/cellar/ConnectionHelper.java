package org.coenraets.cellar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.NamingException;

public class ConnectionHelper {
	public static Connection getConnection() throws SQLException {
		try {
	        InitialContext ctx = new InitialContext();
		    DataSource ds = (DataSource) ctx.lookup("jdbc/cellar");
		    return ds.getConnection();
		} catch (NamingException | SQLException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
}
