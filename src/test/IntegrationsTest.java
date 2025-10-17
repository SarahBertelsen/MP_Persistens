
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import db.DBConnection;
import db.ProductDB;
import model.Product;
import test.TestUtilitiesGenerateData;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationsTest {

	private TestUtilitiesGenerateData testUtil;
	private ProductDB productDB;
	
	
	@BeforeEach
	public void setUp() throws SQLException {
		
		DBConnection.getInstance().startTransaction();
		testUtil = new TestUtilitiesGenerateData();
		productDB = new ProductDB();
		
		testUtil.cleanDB();
	}
	
	//@Test
	void testAddProduct() {
		//Arrange
		testUtil.generateProducts();
        ArrayList<Product> generatedProducts = getGeneratedProducts(testUtil);
		
		//Act
        List<Product> retrievedProducts = new ArrayList<>();
        for (Product p : generatedProducts) {
        	Product fromDb = productDB.findProductById(p.getProductId());
        	retrievedProducts.add(fromDb);
        }
		
        //Assert
        assertEquals(generatedProducts.size(), retrievedProducts.size(), 
        "Does amount of products match output");
        
        
        for (int i = 0; i < generatedProducts.size(); i++) {
        	Product expected = generatedProducts.get(i);
        	Product actual = retrievedProducts.get(i);
        	
        	assertEquals(Banana.getName(), actual.getName(), "Product name should match");
            assertEquals(expected.getProductType(), actual.getProductType(), "Product category should match");
        }
	}

	private ArrayList<Product> getGeneratedProducts(TestUtilitiesGenerateData testUtil2) {
		java.lang.reflect.Field f = testUtil.getClass().getDeclaredField("products");
        f.setAccessible(true);
        return (ArrayList<Product>) f.get(testUtil);
	}

}
