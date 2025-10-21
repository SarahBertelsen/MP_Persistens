package ctrl;

import java.sql.SQLException;

import db.ProductDAO;
import db.StockDAO;
import db.StockDB;
import model.OrderLineItem;
import model.Product;
import model.SaleOrder;

public class ProductCtrl implements ProductCtrlIF {

	private ProductDAO productDao;
	private StockDAO stockDao;
	
	public ProductCtrl(ProductDAO productDao, StockDAO stockDao) {
		this.productDao = productDao;
		this.stockDao = stockDao;
	}

	@Override
	public Product findProductById(int productId, int qty,  int warehouseId) {
		Product product = null;
		System.out.println("fidnProductById Warehouse Id: " + warehouseId);
		
		try {
			product = productDao.findProductById(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("is product in stock: " + isProductInStock(product, warehouseId, qty));
		
		if (!isProductInStock(product, warehouseId, qty)){
			product = null;
		}
		
		return product;
	}
	
	private boolean isProductInStock(Product product, int warehouseId, int qty) {
		int availableQty = 0;
		System.out.println("product found in isProductInStock: " + product);
		if (product != null) {
			try {
				availableQty = stockDao.findAvailableQty(product, warehouseId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return availableQty >= qty;
	}

	@Override
	public boolean removeFromStock(SaleOrder saleOrder) throws SQLException {
		StockDB stockDb = new StockDB();
		boolean success = false;
		for(OrderLineItem ol : saleOrder.getOrderLines()) {
			Product product = ol.getProduct();
			int warehouseId = product.getWarehouse().getWarehouseId();
			int availableQty = 0;
			int qty = ol.getQty();
			try {
				availableQty = stockDb.findAvailableQty(product, warehouseId);
			} catch (SQLException e) {
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
		}
		
		return success;
	}
}
