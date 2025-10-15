package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Discount;

public class DiscountDB implements DiscountDAO {

	private static final String INSERT_Q = " ";
	private PreparedStatement insertPS;
	
	public DiscountDB() {
		try {
			initPreparedStatement();
		} catch (DataAccessException e) {
		}
	}
	
	private void initPreparedStatement() throws DataAccessException {
		try {
			insertPS = DBConnection.getInstance().getConnection().prepareStatement(INSERT_Q);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	private Discount buildObject(ResultSet rs) throws SQLException { 
		Discount d = new Discount(
				rs.getString("type"),
				rs.getInt("amount"),
				rs.getInt("treshold")
				);
		return d;
	}
	
	@Override
	public void addDiscount(Discount discount) throws SQLException{
		insertPS.setString(1, discount.getType());
		insertPS.setInt(2, discount.getAmount());
		insertPS.setInt(3, discount.getTreshold());
		insertPS.executeUpdate();
	}

}
