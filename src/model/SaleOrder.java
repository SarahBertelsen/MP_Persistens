package model;

import java.util.List;

public class SaleOrder {
	
	private List<OrderLineItem> orderLines;
	private Invoice invoice;
	private int freight;
	private Discount discount;
	private Customer customer;
	
	public SaleOrder() {
		
	}
	
	private void addCustomer(Customer customer) {
		
	}
	
	private void addProductToSaleOrder(Product product, int qty) {
		
	}
	
	private void addDeliveryDetails(String method, LocalDate deliveryDate, String address) {
		
	}
}
