package model;

public class EquipmentProduct extends Product{

	String material;
	String style;
	
	public EquipmentProduct(int productId, String name, String productType, double salePrice, String material, String style) {
		super(productId, name, productType, salePrice);
		this.material = material;
		this.style = style;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
