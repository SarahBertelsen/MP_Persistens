package ctrl;

import java.time.LocalDate;

import db.SaleOrderDAO;
import model.SaleOrder;

public class SaleOrderCtrl implements SaleOrderCtrlIF{

	private SaleOrderDAO saleOrderDao;
	
	@Override
	public SaleOrder createOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleOrder addCustomerToSaleOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleOrder addProductToSaleOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleOrder addDeliveryDetails(String method, LocalDate deliveryDate, String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmOrder() {
		// TODO Auto-generated method stub
		
	}

}
