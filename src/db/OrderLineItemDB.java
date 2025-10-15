package db;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Product;

public class OrderLineItemDB implements {
	private static final String PS_INSERT_ORDERLINE = "INSERT INTO OrderlineItem (OrderLineId, SaleOrder, ProductId, Quantity)";
	private PreparedStatement psInsertOrderLine;
	
	public OrderLineItemDB() throws DataAccessException {
		initPreparedStatement();
	}
	private void initPreparedStatement() throws DataAccessException {
		Connection connection = DBConnection.getInstance().getConnection();
		try {
		psInsertOrderline = connection.prepareStatement(PS_INSERT_ORDERLINE, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}
}
