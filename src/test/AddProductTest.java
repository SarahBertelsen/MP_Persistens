package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import db.DataAccessException;
import test.TestUtilitiesGenerateData;

class addProductTest {
	
	TestUtilitiesGenerateData tugd;
	
	@BeforeEach
	 void setUp() throws SQLException, IOException, DataAccessException {
		tugd = new TestUtilitiesGenerateData();
		tugd.cleanDB();
		tugd.generateDB();
	}
	
	@Test
	void findProductByIdUnittest() {
		ProductDAO productStub = new ProductDAO();
		StockDAO stockStub = new StockDAO();
		ProductCtrl pctrl = new ProductCtrl();
		
		
		ArrayList<Product> products = tugd.getProducts();
		Product existingProduct = products.get(0);
		
		
		fail("Not yet implemented");
	}

}
