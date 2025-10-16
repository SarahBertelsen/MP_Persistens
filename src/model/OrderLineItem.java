package model;

public class OrderLineItem {
	private int orderLineId;
	private Product product;
	private int qty;
	private SaleOrder saleOrder;
	
	public OrderLineItem(int orderLineId, SaleOrder saleOrder, Product product, int qty) {
		this.setOrderLineId(orderLineId);
		this.product = product;
		this.qty = qty;
		this.setSaleOrder(saleOrder);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public int getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}
	
	

}
