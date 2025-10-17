package ctrl;

import java.sql.SQLException;

import db.CustomerDAO;
import model.Customer;

public class CustomerCtrl implements CustomerCtrlIF {

	private CustomerDAO customerDao;
	
	public CustomerCtrl(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public Customer findCustomerById(int customerId) {
		Customer customer = null;
		try {
			customer = customerDao.findCustomerById(customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
