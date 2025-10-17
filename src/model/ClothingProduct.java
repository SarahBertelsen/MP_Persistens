package model;

public class ClothingProduct extends Product{
	String size;
	String colour;

	public ClothingProduct(int productId, String name, String productType, double salePrice, Warehouse warehouse, String size, String colour) {
		super(productId, name, productType, salePrice, warehouse);
		this.size = size;
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
