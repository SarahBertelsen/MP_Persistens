package ctrl;

import model.Product;

public interface ProductCtrlIF {

	public Product findProductById(int productId, int warehouseId, int qty);
	public boolean removeFromStock(Product product, int warehouseId, int qty);
}
