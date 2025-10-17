package ctrl;

import db.CustomerDAO;
import model.Customer;

public class CustomerCtrl implements CustomerCtrlIF {

	private CustomerDAO customerDao;
	
	@Override
	public Customer findCustomerById(int customerId) {
		// customerDao.findCustomerById(customerId);
		return null;
	}
	
	private CustomerDAO customerDAO () {
		return customerDao;
	}
}
