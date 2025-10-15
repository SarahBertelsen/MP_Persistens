package db;

import java.sql.SQLException;

import model.Product;

public interface StockDAO {

	public int findAvailableQty(Product product, int warehouseId) throws SQLException;
}
