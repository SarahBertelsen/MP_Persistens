package model;

import java.time.LocalDate;
import java.util.List;

public class SaleOrder {

	private List<OrderLineItem> orderLines;
	private int saleOrderId;
	private Freight freight;
	private Discount discount;
	private Customer customer;
	private double amount;
	private LocalDate date;

	public SaleOrder(List<OrderLineItem> orderLines, int saleOrderId, Freight freight, Discount discount,
			Customer customer, LocalDate date, double amount) {
		this.orderLines = orderLines;
		this.saleOrderId = saleOrderId;
		this.freight = freight;
		this.discount = discount;
		this.customer = customer;
		this.date = date;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public List<OrderLineItem> getOrderLines() {
		return orderLines;
	}

	public void addOrderLine(OrderLineItem orderLine) {
		orderLines.add(orderLine);
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

	public void addOrderLines(OrderLineItem ol) {
		orderLines.add(ol);
	}
}
