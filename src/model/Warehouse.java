package model;

public class Warehouse {
	int warehouseId;
	String name;
	String description;
	
	public Warehouse(int warehouseId, String name, String description) {
		this.warehouseId = warehouseId;
		this.name = name;
		this.description = description;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
