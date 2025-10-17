package ctrl;

import java.sql.SQLException;
import java.time.LocalDate;

import model.Discount;
import model.SaleOrder;

public interface SaleOrderCtrlIF {
	
	public SaleOrder createSaleOrder();
	
	
	public SaleOrder addFreight(String method, LocalDate deliveryDate, String address);
	
	public boolean confirmSaleOrder() throws SQLException;

	public void addDiscount(Discount discount);

	public SaleOrder addProduct(int productId, int qty, int warehouseId);

	public SaleOrder addCustomer(int customerId);
}
