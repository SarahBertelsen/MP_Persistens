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
	
	private CustomerDAO customerDao;
	private SaleOrderDAO saleOrderDao;
	private OrderLineItemDAO orderLineItemDao;
	private ProductDAO productDao;
	private StockDAO stockDao;
	
	private DBConnection dbConnection;

	public SaleOrderCtrl(CustomerDAO customerDao, ProductDAO productDao, StockDAO stockDao, SaleOrderDAO saleOrderDao, OrderLineItemDAO orderLineItemDao) throws SQLException {
		this.customerDao = customerDao;
		this.productDao = productDao;
		this.stockDao = stockDao;
		this.saleOrderDao = saleOrderDao;
		this.orderLineItemDao = orderLineItemDao;
		
		this.customerCtrl = new CustomerCtrl(customerDao);
		this.productCtrl = new ProductCtrl(productDao, stockDao);
		
		dbConnection = DBConnection.getInstance();
	}
	
	@Override
	public SaleOrder createSaleOrder() {
		currentOrder = new SaleOrder();
		return currentOrder;
	}
	
	@Override
	public SaleOrder addCustomer(int customerId) {
		System.out.println("We got to addCustomer");
		Customer customer = customerCtrl.findCustomerById(customerId);
		System.out.println("This is the found customer: " + customer);
		currentOrder.setCustomer(customer);
		return currentOrder;
	}

	@Override
	public SaleOrder addProduct(int productId, int qty, int warehouseId) {
		System.out.println("this is the warehouse id: " + warehouseId);
		Product product = productCtrl.findProductById(productId, qty, warehouseId);
		OrderLineItem ol = new OrderLineItem(currentOrder, product, qty);
		System.out.println("this is the product added to the orderline " + ol.getProduct());
		currentOrder.addOrderLine(ol);
		return currentOrder;
	}
	
	@Override
	public boolean confirmSaleOrder() throws SQLException {
		dbConnection.startTransaction();
		
		saleOrderDao.addSaleOrder(currentOrder);
		boolean success = false;
		
		for(OrderLineItem ol : currentOrder.getOrderLines()) {
			orderLineItemDao.addOrderLineItem(ol);
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
	public SaleOrder addFreight(String method, LocalDate deliveryDate, String address) {
		Freight freight = new Freight(method, deliveryDate, address);
		currentOrder.setFreight(freight);
		return currentOrder;
	}

	@Override
	public void addDiscount(Discount discount) {
		currentOrder.setDiscount(discount);
	}
	
	public SaleOrder getCurrentOrder() {
		return currentOrder;
	}

}
