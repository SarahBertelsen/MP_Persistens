package db;

import model.SaleOrder;

public interface SaleOrderDAO {
	public SaleOrder findSaleOrderById(SaleOrder saleOrder);
}
