package db;

import java.sql.SQLException;

import model.SaleOrder;

public interface SaleOrderDAO {
	public SaleOrder findSaleOrderById(int saleOrderId) throws SQLException;
	public SaleOrder addSaleOrder(SaleOrder saleOrder) throws SQLException;
}
