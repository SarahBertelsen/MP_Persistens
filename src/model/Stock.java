package model;

public class Stock {
	Product product;
	Warehouse warehouse;
	int availableQty;
	int reservedQty;
	int minStock;
	public Stock(Product product, Warehouse warehouse, int availableQty, int reservedQty, int minStock) {
		super();
		this.product = product;
		this.warehouse = warehouse;
		this.availableQty = availableQty;
		this.reservedQty = reservedQty;
		this.minStock = minStock;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public int getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}
	public int getReservedQty() {
		return reservedQty;
	}
	public void setReservedQty(int reservedQty) {
		this.reservedQty = reservedQty;
	}
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
}
