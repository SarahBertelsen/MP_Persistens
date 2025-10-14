package db;

import model.Customer;

public interface CustomerDAO {
	public Customer findCustomerById(Customer customer);
}
