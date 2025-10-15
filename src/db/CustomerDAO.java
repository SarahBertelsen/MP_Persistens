package db;

import java.sql.SQLException;

import model.Customer;

public interface CustomerDAO {
	public Customer findCustomerById(int customerId) throws SQLException;
	public void addCustomer(Customer customer);
}
