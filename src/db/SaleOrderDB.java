package db;

import java.sql.PreparedStatement;

import model.Product;
import model.Discount;
import model.Freight;
import model.SaleOrder;

public class SaleOrderDB implements SaleOrderDAO {
	private static final String INSERT_SALEORDER_Q = "";
	private PreparedStatement insertSaleOrderPS;
	
	private CustomerDAO cDao;
	private ProductDAO pDao;
	private DiscountDAO dDao;
	private FreightDAO fDao;
	
	public SaleOrderDB() {
		
	}

	@Override
	public void addSaleOrder(SaleOrder saleOrder) {
		// TODO Auto-generated method stub
		
	}
	
}
