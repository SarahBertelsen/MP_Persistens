package model;

public class Product {
	
	private int productId;
	private String name;
	private String productType;
	private Double salePrice;
	
	public Product(int productId, String name, String productType, double salePrice) {
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.setSalePrice(salePrice);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	
}
