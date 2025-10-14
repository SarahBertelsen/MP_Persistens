package ctrl;

import java.time.LocalDate;

import model.SaleOrder;

public interface SaleOrderCtrlIF {
	
	public SaleOrder createOrder();
	
	public SaleOrder addCustomerToSaleOrder();
	
	public SaleOrder addProductToSaleOrder();
	
	public SaleOrder addDeliveryDetails(String method, LocalDate deliveryDate, String address);
	
	public void confirmOrder(SaleOrder saleOrder);
}
