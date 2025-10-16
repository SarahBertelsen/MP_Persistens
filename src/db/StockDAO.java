package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
import model.SaleOrder;
import model.Stock;

public interface StockDAO {
	public Stock addStock(Stock stock) throws SQLException;
	public int findAvailableQty(Product product, int warehouseId) throws SQLException;
	public void setAvailableQty(Product product, int qty, int warehouseId) throws SQLException;
	
}
