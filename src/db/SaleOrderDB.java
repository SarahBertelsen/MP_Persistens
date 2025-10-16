package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.Product;
import model.Discount;
import model.Freight;
import model.SaleOrder;

public class SaleOrderDB implements SaleOrderDAO {
	private static final String INSERT_Q = "INSERT INTO SaleOrder VALUES (?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertPS;
	private CustomerDAO cDao;
	private ProductDAO pDao;
	private DiscountDAO dDao;
	private FreightDAO fDao;

	public SaleOrderDB() throws SQLException {
		initPreparedStatement();
	}
	
	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q);
	}

	@Override
	public SaleOrder addSaleOrder(SaleOrder saleOrder) {
		Invoice inVoice = saleOrder.getInVoice();
		Freight freight = saleOrder.getFreight();
		Discount discount = saleOrder.getDiscount();
		Customer customer = saleOrder.getCustomer();
		
		insertPS.setInt(1, inVoice.getInVoiceId());
		insertPS.setInt(2, freight.getFreightId());
		insertPS.setInt(3, discount.getDiscountId());
		insertPS.setInt(4, customer.getCustomerId());
		insertPS.setDate(5, Date.valueOf(LocalDate.now()));
		insertPS.setDouble(6, saleOrder.getAmount());
		
		insertPS.executeUpdate();
	}
}
