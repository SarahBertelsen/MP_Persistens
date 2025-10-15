package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;

public class CustomerDB implements CustomerDAO {
	private static final String SELECT_BY_ID_Q = "SELECT * FROM Customer WHERE CustomerId = ?";
	private static final String INSERT_Q = "INSERT INTO Customer VALUES (CustomerId, FName, LName, Address, Zipcode, PhoneNo) (?, ?, ?, ?,?,?)";
	private PreparedStatement selectByIdPS;
	private PreparedStatement insertPS;

	public CustomerDB() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q);
		selectByIdPS = connection.prepareStatement(SELECT_BY_ID_Q);
	}

	public Customer findCustomerById(int customerId) throws SQLException {
		Customer customer = null;
		ResultSet resultSet;

		selectByIdPS.setInt(1, customerId);
		resultSet = selectByIdPS.executeQuery();
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

	@Override
	public void addCustomer(Customer customer) {
		try {
			insertPS.setInt(1, customer.getCustomerId());
			insertPS.setString(2, customer.getfName());
			insertPS.setString(3, customer.getlName());
			insertPS.setString(4, customer.getAddress());
			insertPS.setInt(5, customer.getZipcode());
			insertPS.setString(6, customer.getPhone());

			insertPS.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
