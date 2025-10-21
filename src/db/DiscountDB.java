package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;
import model.Discount;

public class DiscountDB implements DiscountDAO {

	private static final String INSERT_Q = "INSERT INTO Discount (Type, Amount, Treshold) VALUES (?, ?, ?)";
	private static final String SELECT_BY_ID_Q = "SELECT * FROM Discount WHERE DiscountId = ?";
	private PreparedStatement insertPS;
	private PreparedStatement selectByIdPS;
	
	public DiscountDB() {
		try {
			initPreparedStatement();
		} catch (DataAccessException e) {
		}
	}
	
	private void initPreparedStatement() throws DataAccessException {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			insertPS = connection.prepareStatement(INSERT_Q, Statement.RETURN_GENERATED_KEYS);
			selectByIdPS = connection.prepareStatement(SELECT_BY_ID_Q);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	private Discount buildObject(ResultSet rs) throws SQLException { 
		Discount discount = null;
		
		int discountId = rs.getInt(1);
		String type = rs.getString(2);
		double amount = rs.getDouble(3);
		double threshold = rs.getDouble(4);
		
		discount = new Discount(discountId, type, amount, threshold);
		
		return discount;
	}
	
	@Override
	public Discount addDiscount(Discount discount) throws SQLException{
		int discountId = 0;
		insertPS.setString(1, discount.getType());
		insertPS.setDouble(2, discount.getAmount());
		insertPS.setDouble(3, discount.getTreshold());
		insertPS.executeUpdate();
		
		ResultSet keyRS = insertPS.getGeneratedKeys();
		if (keyRS.next()) {
			discountId = keyRS.getInt(1);
			discount.setDiscountId(discountId);
		}
		
		return discount;
	}

	@Override
	public Discount findDiscountById(int discountId) throws SQLException {
		Discount discount = null;
		ResultSet resultSet;

		selectByIdPS.setInt(1, discountId);
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			discount = buildObject(resultSet);
		}
		return discount;
	}

}
