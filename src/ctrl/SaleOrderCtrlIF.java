package ctrl;

import java.time.LocalDate;

import model.Discount;
import model.SaleOrder;

public interface SaleOrderCtrlIF {
	
	public SaleOrder createSaleOrder();
	
	public SaleOrder addCustomerToSaleOrder(int customerID);
	
	public SaleOrder addFreightToSaleOrder(String method, LocalDate deliveryDate, String address);
	
	public void confirmSaleOrder();

	void addDiscountToSaleOrder(Discount discount);

	SaleOrder addProductToSaleOrder(int productId, int qty, int warehouseId);
}
