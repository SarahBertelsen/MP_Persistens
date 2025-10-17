package ctrl;

import java.sql.SQLException;

import model.Product;
import model.SaleOrder;

public interface ProductCtrlIF {

	public Product findProductById(int productId, int warehouseId, int qty);
	public boolean removeFromStock(SaleOrder saleOrder) throws SQLException;
}
