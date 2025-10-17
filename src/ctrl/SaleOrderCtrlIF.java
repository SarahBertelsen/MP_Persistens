package ctrl;

import java.sql.SQLException;
import java.time.LocalDate;

import model.Discount;
import model.SaleOrder;

public interface SaleOrderCtrlIF {
	
	public SaleOrder createSaleOrder();
	
	public SaleOrder addCustomerToSaleOrder(int customerID);
	
	public SaleOrder addFreightToSaleOrder(String method, LocalDate deliveryDate, String address);
	
	public boolean confirmSaleOrder() throws SQLException;

	public void addDiscountToSaleOrder(Discount discount);

	public SaleOrder addProductToSaleOrder(int productId, int qty, int warehouseId);
}
