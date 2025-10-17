package ctrl;

import java.sql.SQLException;
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
	private OrderLineItemDAO orderLineItemDAO;
	private ProductDAO productDao;
	private StockDAO stockDao;
	
	private DBConnection dbConnection;

	public SaleOrderCtrl() throws SQLException {
		customerCtrl = new CustomerCtrl();
		productCtrl = new ProductCtrl(productDao, stockDao);
		saleOrderDAO = new SaleOrderDB();
		new CustomerDB();
		new FreightDB();
		new DiscountDB();
		
		dbConnection = DBConnection.getInstance();
	}
	
	@Override
	public SaleOrder createSaleOrder() {
		currentOrder = new SaleOrder();
		return currentOrder;
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
	public boolean confirmSaleOrder() throws SQLException {
		dbConnection.startTransaction();
		saleOrderDAO.addSaleOrder(currentOrder);
		boolean success = false;
		
		for(OrderLineItem ol : currentOrder.getOrderLines()) {
			orderLineItemDAO.addOrderLineItem(ol);
		success = productCtrl.removeFromStock(currentOrder);
		
			if (success){
				dbConnection.commitTransaction();
			} else {
				dbConnection.rollbackTransaction();
			}
		}
		return success;
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
