package db;

import java.sql.SQLException;

import model.Product;
import model.SaleOrder;

public interface StockDAO {
	public Stock addStock(Stock saleOrder) throws SQLException;
	public int findAvailableQty(Product product, int warehouseId) throws SQLException;
}
