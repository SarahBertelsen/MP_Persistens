package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Freight;

public class FreightDB implements FreightDAO{
	private static final String INSERT_Q = "INSERT INTRO Freight";
	private PreparedStatement insertPS;
	
	public FreightDB() {
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
	
	private Freight buildObject(ResultSet rs) throws SQLException {
		Freight f = new Freight(
				rs.getString("method"),
				rs.getDate("deliveryDate").toLocalDate(),
				rs.getString("address")
				);
		return f;
		}
	
	@Override
	public void addFreight(Freight freight) throws SQLException {
		insertPS.setString(1, freight.getMethod());
		insertPS.setDate(2, java.sql.Date.valueOf(freight.getDeliveryDate()));
		insertPS.setString(3,  freight.getAddress());
		insertPS.executeUpdate();
	}

}
