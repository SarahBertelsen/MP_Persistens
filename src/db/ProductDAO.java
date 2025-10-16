package db;

import java.sql.SQLException;

import model.Product;

public interface ProductDAO {
	public Product addProduct(Product product) throws SQLException;
	public Product findProductById(int productId) throws SQLException;
}
