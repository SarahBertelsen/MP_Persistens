package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Product;
import model.Stock;

public class StockDB implements StockDAO{

	private static final String SELECT_BY_ID_Q = "SELECT * FROM Stock WHERE ProductId = ? AND WarehouseId = ?";
	private static final String UPDATE_STOCK_Q = "UPDATE Stock SET AvailableQty = ? WHERE ProductId = ? AND WarehouseId = ?";
	private static final String INSERT_Q = "INSERT INTO Stock VALUES (?, ?, ?, ?, ?)";
	
	private PreparedStatement selectByIdPS;
	private PreparedStatement updatePS;
	private PreparedStatement insertPS;
	
	public StockDB() throws SQLException {
		initPreparedStatement();
	}
	
	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		updatePS = connection.prepareStatement(UPDATE_STOCK_Q);
		selectByIdPS = connection.prepareStatement(SELECT_BY_ID_Q);
		insertPS = connection.prepareStatement(INSERT_Q);
	}
	
	@Override
	public int findAvailableQty(Product product, int warehouseId) throws SQLException {
		int availableQty = 0;
		ResultSet rs;
		selectByIdPS.setInt(1, product.getProductId()); //sæt productId
		selectByIdPS.setInt(2, warehouseId); //sæt warehouseId
		rs = selectByIdPS.executeQuery(); //udfør transaktion
		
		if(rs.next()) {
			availableQty = rs.getInt("availableQty");
		}
		return availableQty;
	}

	public void setAvailableQty(Product product, int qty, int warehouseId) throws SQLException {
		updatePS.setInt(1, qty); //sæt ny mængde
		updatePS.setInt(2,  product.getProductId()); //sæt productId
		updatePS.setInt(3, warehouseId); //sæt warehouseId
		updatePS.executeUpdate(); //udfør opdatering
	}

	@Override
	public Stock addStock(Stock stock) throws SQLException {
		int productId = stock.getProduct().getProductId();
		int warehouseId = stock.getWarehouse().getWarehouseId();
		int availableQty = stock.getAvailableQty();
		int reservedQty = stock.getReservedQty();
		int minStock = stock.getMinStock();
		
		insertPS.setInt(1, productId);
		insertPS.setInt(2, warehouseId);
		insertPS.setInt(3, availableQty);
		insertPS.setInt(4, reservedQty);
		insertPS.setInt(5, minStock);
		insertPS.executeUpdate();
		
		return stock;
	}
}
