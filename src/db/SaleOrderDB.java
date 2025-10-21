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
	private static final String INSERT_Q = "INSERT INTO SaleOrder (freightId, discountId, customerId, orderDate) VALUES (?, ?, ?, ?)";
	private static final String FIND_BY_ID_Q = "SELECT * FROM SaleOrder WHERE SaleOrderId = ?";

	private PreparedStatement insertPS;
	private PreparedStatement selectByIdPS;

	public SaleOrderDB() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q, Statement.RETURN_GENERATED_KEYS);
		selectByIdPS = connection.prepareStatement(FIND_BY_ID_Q);

	}

	@Override
	public SaleOrder addSaleOrder(SaleOrder saleOrder) throws SQLException {
		int saleOrderId = 0;
		
		new FreightDB().addFreight(saleOrder.getFreight());
		new DiscountDB().addDiscount(saleOrder.getDiscount());
		
		int freightId = saleOrder.getFreight().getFreightId();
		int discountId = saleOrder.getDiscount().getDiscountId();
		int customerId = saleOrder.getCustomer().getCustomerId();
		
		insertPS.setInt(1, freightId);
		insertPS.setInt(2, discountId);
		insertPS.setInt(3, customerId);
		insertPS.setDate(4, Date.valueOf(LocalDate.now()));

		insertPS.executeUpdate();
		
		ResultSet keyRS = insertPS.getGeneratedKeys();
		if (keyRS.next()) {
			saleOrderId = keyRS.getInt(1);
			saleOrder.setSaleOrderId(saleOrderId);
		}
		
		return saleOrder;
		
	}

	public SaleOrder findSaleOrderById(int saleOrderId) throws SQLException {
		SaleOrder saleOrder = null;
		ResultSet resultSet;

		selectByIdPS.setInt(1, saleOrderId);
		
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			saleOrder = buildObject(resultSet);
		}
		return saleOrder;
	}

	private SaleOrder buildObject(ResultSet rs) throws SQLException {
		SaleOrder saleOrder = null;

		int saleOrderId = rs.getInt(1);
		int freightId = rs.getInt(2);
		int discountId = rs.getInt(3);
		int customerId = rs.getInt(4);
		LocalDate date = rs.getDate(5).toLocalDate();
		
		List<OrderLineItem> orderLines = new OrderLineItemDB().getOrderLinesBySaleOrderId(saleOrderId);
		Freight freight = new FreightDB().findFreightById(freightId);
		Discount discount = new DiscountDB().findDiscountById(discountId);
		Customer customer = new CustomerDB().findCustomerById(customerId);
		
		saleOrder = new SaleOrder(orderLines, saleOrderId, freight, discount, customer, date);
		
		return saleOrder;
	}
}
