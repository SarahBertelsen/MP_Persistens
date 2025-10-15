package model;

import java.time.LocalDate;
import java.util.List;

public class SaleOrder {
	
	private List<OrderLineItem> orderLines;
	private Invoice invoice;
	private Freight freight;
	private Discount discount;
	private Customer customer;
	private double amount;
	
	public List<OrderLineItem> getOrderLines() {
		return orderLines;
	}

	public void addOrderLine(List<OrderLineItem> orderLines) {
		orderLines.add(orderLines);
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Freight getFreight() {
		return freight;
	}

	public void setFreight(Freight freight) {
		this.freight = freight;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	private void insertCustomer(Customer customer) {
		
	}
	
	private void insertProduct(Product product, int qty) {
		
	}
	
	private void insertFreight(String method, LocalDate deliveryDate, String address) {
		
	}
}
