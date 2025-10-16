package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import model.Product;
import model.Customer;
import model.Discount;
import model.Freight;
import model.OrderLineItem;
import model.SaleOrder;

public class SaleOrderDB implements SaleOrderDAO {
	private static final String INSERT_Q = "INSERT INTO SaleOrder VALUES (?, ?, ?, ?, ?, ?)";
	private static final String FIND_BY_ID_Q = "SELECT * FROM SaleOrder WHERE saleOrderId = ?";

	private PreparedStatement insertPS;
	private CustomerDAO cDao;
	private ProductDAO pDao;
	private DiscountDAO dDao;
	private FreightDAO fDao;

	private PreparedStatement selectByIdPS;

	public SaleOrderDB() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q);
		selectByIdPS = connection.prepareStatement(FIND_BY_ID_Q);

	}

	@Override
	public SaleOrder addSaleOrder(SaleOrder saleOrder) {
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

	public Product findSaleOrderById(int saleOrderId) throws SQLException {
		Product product = null;
		ResultSet resultSet;

		selectByIdPS.setInt(1, saleOrderId);
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			product = buildObject(resultSet);
		}
		return product;
	}

	private SaleOrder buildObject(ResultSet rs) throws SQLException {
		List<OrderLineItem> orderLines;
		OrderLineDB orderlineDB = new orderLineDB();

		int saleOrderId;
		Freight freight;
		Discount discount;
		Customer customer;
		LocalDate date;
		Double amount;
		return new SaleOrder(orderLines, saleOrderId, freight, discount, customer, date, amount);
	}
}
