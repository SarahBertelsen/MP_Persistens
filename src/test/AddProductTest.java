package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ctrl.ProductCtrl;
import db.DataAccessException;
import db.ProductDAO;
import db.StockDAO;
import model.MusicProduct;
import model.Product;
import model.Stock;
import model.Warehouse;
import test.TestUtilitiesGenerateData;

class addProductTest {
	
	TestUtilitiesGenerateData tugd;
	
	@Test
	void findProductByIdUnittest() {
		ProductDAO productStub = new ProductStub();
		StockDAO stockStub = new StockStub();
		
		int existingProductId = 1;
		String existingProductName = "The Real Thing";
		String existingProductType = "music";
		double existingProductPrice = 2.99;
		String existingProductFormat = "mp3";
		String existingProductArtist = "Them";
		
		Product existingProduct = new MusicProduct(
				existingProductId,
				existingProductName,
				existingProductType,
				existingProductPrice,
				existingProductFormat,
				existingProductArtist
				);
		
		int nonExistingProductId = 9000;
		String nonExistingProductName = "Self Titled";
		String nonExistingProductType = "music";
		double nonExistingProductPrice = 910324.009;
		String nonExistingProductFormat = "Obelisk";
		String nonExistingProductArtist = "???";
		
		Product nonExistingProduct = new MusicProduct(
				nonExistingProductId,
				nonExistingProductName,
				nonExistingProductType,
				nonExistingProductPrice,
				nonExistingProductFormat,
				nonExistingProductArtist
				);
		
		try {
			productStub.addProduct(existingProduct);
		} catch (SQLException e) {
			fail("failed to add existing product.");
			e.printStackTrace();
		}
		
		int validWarehouseId = 1;
		int invalidWarehouseId = 124;
		Warehouse warehouse = new Warehouse(validWarehouseId, "warehouse", "is a warehouse");
		int availableQty = 10;
		int reservedQty = 5;
		int minStock = 5;
		
		Stock existingStock = new Stock(existingProduct, warehouse, availableQty, reservedQty, minStock);
		try {
			stockStub.addStock(existingStock);
		} catch (SQLException e) {
			fail("failed to add existing stock.");
			e.printStackTrace();
		}
		
		ProductCtrl pctrl = new ProductCtrl(productStub, stockStub);
		
		int validQty = 5;
		int invalidQty = 100;
		int negativeQty = -5;
		
		Product validFoundProduct = pctrl.findProductById(existingProductId, validWarehouseId, validQty);
		Product invalidFoundProduct = pctrl.findProductById(existingProductId, validWarehouseId, invalidQty);
		Product negativeFoundProduct = pctrl.findProductById(existingProductId, validWarehouseId, negativeQty);
		Product wrongWarehouseFoundProduct = pctrl.findProductById(existingProductId, invalidWarehouseId, validQty);
		Product nonExistingFoundproduct = pctrl.findProductById(nonExistingProductId, invalidWarehouseId, validQty);
		
		assertNotNull(validFoundProduct, "Didn't find valid product");
		assertNull(invalidFoundProduct, "Found invalid product");
		assertNull(negativeFoundProduct, "Found invalid product");
		assertNull(wrongWarehouseFoundProduct, "Found invalid product");
		assertNull(nonExistingFoundproduct, "Found invalid product");
		
	}

}
