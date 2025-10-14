package db;

import model.Product;

public interface ProductDAO {
	public Product findProductById(Product product);
}
