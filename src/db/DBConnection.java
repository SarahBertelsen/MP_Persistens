package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection uniqueInstance; 	
	private Connection connection = null;

	private static final String DBNAME = "DMA-CSD-V251_10669007";
	private static final String SERVERNAME = "hildur.ucn.dk";
	private static final String PORTNUMBER = "1433";
	private static final String USERNAME = "DMA-CSD-V251_10669007";
	private static final String PASSWORD = "Password1!";

	private DBConnection() {
		String urlString = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=false", SERVERNAME, PORTNUMBER,
				DBNAME);
		try {
			connection = DriverManager.getConnection(urlString, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new DBConnection();
		}
		return uniqueInstance;
	}

	public Connection getConnection() {
		return connection;
	}
	
	public void startTransaction() throws SQLException {
		connection.setAutoCommit(false);
	}
	
	public void commitTransaction() throws SQLException {
		connection.commit();
		connection.setAutoCommit(true);
	}
	
	public void rollbackTransaction() throws SQLException {
		connection.rollback();
		connection.setAutoCommit(true);
	}
}
