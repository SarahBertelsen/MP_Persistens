package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Product;

public class StockDB implements StockDAO{

	private static final String SELECT_BY_ID_Q = "SELECT * FROM Stock WHERE ProductId = ?";
	private static final String UPDATE_STOCK_Q = " ";
	
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
	public boolean isAvailable(Product product, int qty) {
		// TODO Auto-generated method stub
		return false;
	}

}
