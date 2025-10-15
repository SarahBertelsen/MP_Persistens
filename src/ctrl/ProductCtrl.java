package ctrl;

import db.ProductDAO;
import model.Product;

public class ProductCtrl implements ProductCtrlIF {

	private ProductDAO productDao;


	@Override
	public Product findProductById(int productId) {
		//return productDao.findProductById(productId);
		return null;
	}
	
	
}
