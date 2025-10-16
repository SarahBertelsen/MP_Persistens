package test;

import java.sql.SQLException;

import db.ProductDAO;
import model.Product;

public class ProductStub implements ProductDAO {

	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById(int productId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
