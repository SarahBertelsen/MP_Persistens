package ctrl;

import java.time.LocalDate;

import db.*;


import model.Customer;
import model.Discount;
import model.Freight;
import model.OrderLineItem;
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
	private ProductDAO productDao;
	
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
		currentOrder.setCustomer(customer);
		return currentOrder;
	}

	@Override
	public SaleOrder addProductToSaleOrder(int productId, int qty, int warehouseId) {
		Product product = productCtrl.findProductById(productId, qty, warehouseId);
		OrderLineItem ol = new OrderLineItem(currentOrder, product, qty);
		return currentOrder;
	}
	
	@Override
	public boolean confirmSaleOrder() {
		dbConnection.startTransaction();
		saleOrderDAO.addSaleOrder(currentOrder);
		
		for(OrderLineItem ol : currentOrder.getOrderLines()) {
			orderLineItemDAO.addOrderLineItem(ol);
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
		Freight freight = new Freight(method, deliveryDate, address);
		currentOrder.setFreight(freight);
		return currentOrder;
	}

	@Override
	public void addDiscountToSaleOrder(Discount discount) {
		currentOrder.setDiscount(discount);
	}

}
