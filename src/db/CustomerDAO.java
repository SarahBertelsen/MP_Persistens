package db;

import java.sql.SQLException;

import model.Customer;

public interface CustomerDAO {
	public void addCustomer(Customer customer) throws SQLException;
	public Customer findCustomerById(int customerId) throws SQLException;
	
}
