package db;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderLineItemDB implements OrderLineItemDAO{
	private static final String SELECT_BY_SALE_ORDER_ID_Q = "SELECT * FROM OrderLines WHERE SaleOrder = ?";
	private static final String SELECT_BY_ID_Q = "SELECT * FROM OrderLines WHERE OrderLineId = ?";
	private static final String INSERT_Q = "INSERT INTO OrderLines (SaleOrder, ProductId, Quantity) VALUES (?, ?, ?)";
	private PreparedStatement selectBySaleOrderIdPS;
	private PreparedStatement selectByIdPS;
	private PreparedStatement insertPS;
	
	public OrderLineItemDB() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q, Statement.RETURN_GENERATED_KEYS);
		selectBySaleOrderIdPS = connection.prepareStatement(SELECT_BY_SALE_ORDER_ID_Q);
		selectByIdPS = connection.prepareStatement(SELECT_BY_SALE_ORDER_ID_Q);
	}

	@Override
	public OrderLineItem addOrderLineItem(OrderLineItem ol) throws SQLException {
		int olId = 0;
		int saleOrderId = ol.getSaleOrder().getSaleOrderId();
		int productId = ol.getProduct().getProductId();
		int quantity = ol.getQty();
		
		insertPS.setInt(1, saleOrderId);
		insertPS.setInt(2, productId);
		insertPS.setInt(3, quantity);

		insertPS.executeUpdate();
		ResultSet keyRS = insertPS.getGeneratedKeys();
		if (keyRS.next()) {
			olId = keyRS.getInt(1);
			ol.setOrderLineId(olId);
		}
		
		return ol;
	}

	@Override
	public ArrayList<OrderLineItem> getOrderLinesBySaleOrderId(int saleOrderId) throws SQLException {
		ArrayList<OrderLineItem> orderLines = new ArrayList<OrderLineItem>();
		
		
		ResultSet resultSet;
		selectBySaleOrderIdPS.setInt(1, saleOrderId);
		resultSet = selectBySaleOrderIdPS.executeQuery();
		while (resultSet.next()) {
			orderLines.add(buildObject(resultSet));
		}
		
		return orderLines;
	}
	
	private OrderLineItem buildObject(ResultSet rs) throws SQLException {
		OrderLineItem ol = null;

		int olId = rs.getInt(1);
		int saleOrderId = rs.getInt(2);
		int productId = rs.getInt(3);
		int qty = rs.getInt(4);
		
		SaleOrder saleOrder = new SaleOrderDB().findSaleOrderById(saleOrderId);
		Product product = new ProductDB().findProductById(productId);
		
		ol = new OrderLineItem(olId, saleOrder, product, qty);
		return ol;
	}

	@Override
	public OrderLineItem getOrderLineItemById(int orderLineId) throws SQLException {
		OrderLineItem orderLine = null;
		ResultSet resultSet;
		selectByIdPS.setInt(1, orderLineId);
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			orderLine = buildObject(resultSet);
		}
		
		return orderLine;
	}
	
	
	
}
