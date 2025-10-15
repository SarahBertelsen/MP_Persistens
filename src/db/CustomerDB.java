package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dal.DBConnection;
import dal.DBMessages;
import dal.DataAccessException;
import model.Customer;
import model.Lecturer;

public class CustomerDB {
	private static final String SELECT_BY_ID_Q = "SELECT * FROM Customer WHERE CustomerId = ?";
	private static final String INSERT_Q = "INSERT INTO Customer VALUES (?, ?, ?, ?,?,?)";
	private PreparedStatement selectByIdPS;
	private PreparedStatement insertPS;

	public CustomerDB() throws SQLException {
		initPreparedStatement();
	}
	
	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q, Statement.RETURN_GENERATED_KEYS);
		selectByIdPS = connection.prepareStatement(SELECT_BY_ID_Q);
	}
	
	public Customer findById(int customerId) throws SQLException {
		Customer customer = null;
		ResultSet resultSet;
		
		selectByIdPS.setInt(1, customerId);
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			customer = buildObject(resultSet);
		}
		return customer;
	}
	
	public Customer insertQ() throws SQLException {
		Customer customer = null;
		ResultSet resultSet;
		insertPS.setString(1, INSERT_Q);
		resultSet = insertPS.executeQuery();
		if (resultSet.next()) {
			customer = buildObject(resultSet);
		}
		return customer;
	}
	
	private Customer buildObject(ResultSet rs) throws SQLException {
			Customer customer = null;
			
			int customerId = rs.getInt(1);
			String fName = rs.getString(2);
			String lName = rs.getString(3);
			String address = rs.getString(4);
			int zipcode = rs.getInt(5);
			String phoneNo = rs.getString(6);
			return new Customer(customerId, fName, lName, address, zipcode, phoneNo);
			}
}
