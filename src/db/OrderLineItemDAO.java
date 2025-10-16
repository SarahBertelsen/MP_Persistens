package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.OrderLineItem;

public interface OrderLineItemDAO {
	public OrderLineItem addOrderLineItem(OrderLineItem ol) throws SQLException;
	public OrderLineItem getOrderLineItemById(int saleOrderId) throws SQLException;
	public ArrayList<OrderLineItem> getOrderLinesBySaleOrderId(int saleOrderId) throws SQLException;
}
