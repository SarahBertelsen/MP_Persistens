package ctrl;

import java.sql.SQLException;

import db.ProductDAO;
import db.StockDAO;
import model.Product;

public class ProductCtrl implements ProductCtrlIF {

	private ProductDAO productDao;
	private StockDAO stockDao;
	
	public ProductCtrl(ProductDAO productDao, StockDAO stockDao) {
		this.productDao = productDao;
		this.stockDao = stockDao;
	}

	@Override
	public Product findProductById(int productId, int warehouseId, int qty) {
		Product product = null;
		try {
			product = productDao.findProductById(productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (! isProductInStock(product, warehouseId, qty)){
			product = null;
		}
		
		return product;
	}
	
	private boolean isProductInStock(Product product, int warehouseId, int qty) {
		int availableQty = 0;
		if (product != null) {
			try {
				availableQty = stockDao.findAvailableQty(product, warehouseId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return availableQty >= qty;
	}

	@Override
	public boolean removeFromStock(Product product, int warehouseId, int qty) {
		boolean success = false;
		int availableQty = 0;
		try {
			availableQty = stockDao.findAvailableQty(product, warehouseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (availableQty >= qty) {
			int postRemoveStock = availableQty - qty;
			success = true;
			try {
				stockDao.setAvailableQty(product, postRemoveStock, warehouseId);
			} catch (SQLException e) {
				success = false;
				e.printStackTrace();
			}
		}
		
		return success;
	}
}
