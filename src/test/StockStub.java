package test;

import java.sql.SQLException;
import java.util.ArrayList;

import db.StockDAO;
import model.Product;
import model.Stock;

public class StockStub implements StockDAO {
	ArrayList<Stock> stocks = new ArrayList<Stock>();
	
	@Override
	public Stock addStock(Stock stock) throws SQLException {
		stocks.add(stock);
		return stock;
	}

	@Override
	public int findAvailableQty(Product product, int warehouseId) throws SQLException {
		int availableQty = 0;
		Stock stock = findStockByProductAndWarehouseId(product, warehouseId);
		if (stock != null) {
			availableQty = stock.getAvailableQty();
		}
		return availableQty;
	}
	
	private Stock findStockByProductAndWarehouseId(Product product, int warehouseId) {
		Stock matchStock = null;
		int i = 0;
		while (matchStock != null || i >= stocks.size()) {
			Stock stock = stocks.get(i);
			Product stockProduct = stock.getProduct();
			int stockWarehouseId = stock.getWarehouse().getWarehouseId();
			if (stockProduct == product && stockWarehouseId == warehouseId);
				matchStock = stock;
			i++;
		}
		return matchStock;
	}

	@Override
	public void setAvailableQty(Product product, int qty, int warehouseId) throws SQLException {
		Stock stock = findStockByProductAndWarehouseId(product, warehouseId);
		if (stock != null) {
			stock.setAvailableQty(qty);
		}
	}
}
