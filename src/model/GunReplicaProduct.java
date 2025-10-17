package model;

public class GunReplicaProduct extends Product{

	String calibre;
	String material;
	
	public GunReplicaProduct(int productId, String name, String productType, double salePrice, Warehouse warehouse, String calibre, String material) {
		super(productId, name, productType, salePrice, warehouse);
		this.calibre = calibre;
		this.material = material;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
