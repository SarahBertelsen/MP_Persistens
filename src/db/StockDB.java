package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Product;

public class StockDB implements StockDAO{

	private static final String SELECT_BY_ID_Q = "SELECT * FROM Stock WHERE productId = ? AND qarehouseId = ?";
	private static final String UPDATE_STOCK_Q = "UPDATE Stock SET availableQty WHERE productId = ? AND warehouseId = ?";
	
	private PreparedStatement selectByIdPS;
	private PreparedStatement updatePS;
	
	public StockDB() throws SQLException {
		initPreparedStatement();
	}
	
	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		updatePS = connection.prepareStatement(UPDATE_STOCK_Q);
		selectByIdPS = connection.prepareStatement(SELECT_BY_ID_Q);
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

	private void setAvailableQty(Product product, int qty, int warehouseId) throws SQLException {
		updatePS.setInt(1, qty); //sæt ny mængde
		updatePS.setInt(2,  product.getProductId()); //sæt productId
		updatePS.setInt(3, warehouseId); //sæt warehouseId
		updatePS.executeUpdate(); //udfør opdatering
	}
}
