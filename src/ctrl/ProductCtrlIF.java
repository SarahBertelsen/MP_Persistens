package ctrl;

import model.Product;

public interface ProductCtrlIF {

	public Product findProductById(int productId);
	public boolean removeFromStock(Product product, int qty, int warehouseId);
}
