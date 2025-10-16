package ctrl;

import java.time.LocalDate;

import db.CustomerDAO;
import db.DBConnection;
import db.DiscountDAO;
import db.FreightDAO;
import db.SaleOrderDAO;
import model.Customer;
import model.Product;
import model.SaleOrder;

public class SaleOrderCtrl implements SaleOrderCtrlIF{
	private SaleOrder currentOrder;
	
	private CustomerCtrl customerCtrl;
	private ProductCtrl productCtrl;
	
	private SaleOrderDAO saleOrderDAO;
	private CustomerDAO customerDAO;
	private FreightDAO freightDAO;
	private DiscountDAO discountDAO;
	private OrderLineItemDAO orderLineItemDAO;
	
	private DBConnection dbConnection;

	public SaleOrderCtrl() {
		customerCtrl = new CustomerCtrl();
		productCtrl = new ProductCtrl();
		saleOrderDAO = new SaleOrderDB();
		customerDAO = new CustomerDB();
		freightDAO = new FreightDB();
		discountDAO = new DiscountDB();
		
		dbConnection = DBConnection.getInstance();
	}
	
	@Override
	public SaleOrder addCustomerToSaleOrder(int customerId) {
		Customer customer = customerCtrl.findCustomerById(customerId);
		currentOrder.addCustomer(customer);
		return currentOrder;
	}

	@Override
	public SaleOrder addProductToSaleOrder(int productId, int qty) {
		Product product = productController.findById(productId);
		currentOrder.addProductToSaleOrder(product, qty);
		return currentOrder;
	}

	@Override
	public boolean confirmOrder() {
		dbConnection.startTransaction();
		saleOrderDAO.addSaleOrder(currentOrder);
		orderLineItemDAO.insertOrderLineItem(orderLineItem);
		boolean success = productCtrl.removeFromStock(currentOrder);
		
		if (success) {
			dbConnection.commitTransaction();
		} else {
			dbConnection.rollbackTransaction();
		}
		
		return success;
	}

	@Override
	public SaleOrder createSaleOrder() {
		currentOrder = new SaleOrder();
		return currentOrder;
	}

	@Override
	public SaleOrder addFreightToSaleOrder(String method, LocalDate deliveryDate, String address) {
		currentOrder.addFreightToSaleOrder(method, deliveryDate, address);
		return currentOrder;
	}

	@Override
	public void addDiscountToSaleOrder() {
		Discount discount = new Discount();
		currentOrder.addDiscount(discount);
	}

}
