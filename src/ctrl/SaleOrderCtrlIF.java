package ctrl;

import java.time.LocalDate;

import model.SaleOrder;

public interface SaleOrderCtrlIF {
	
	public SaleOrder createSaleOrder();
	
	public SaleOrder addCustomerToSaleOrder(int customerID);
	
	public SaleOrder addProductToSaleOrder(int productID, int qty);
	
	public SaleOrder addFreightToSaleOrder(String method, LocalDate deliveryDate, String address);
	
	public void addDiscountToSaleOrder();
	
	public void confirmOrder(SaleOrder saleOrder);
}
