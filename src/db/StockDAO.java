package db;

import model.Product;

public interface StockDAO {

	public boolean isAvailable(Product product, int qty);
}
