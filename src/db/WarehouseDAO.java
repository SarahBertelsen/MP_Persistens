package db;

import java.sql.SQLException;

import model.Warehouse;

public interface WarehouseDAO {
	public Warehouse addWarehouse(Warehouse warehouse) throws SQLException;
	public Warehouse findWarehouseById(int warehouseId) throws SQLException;
}
