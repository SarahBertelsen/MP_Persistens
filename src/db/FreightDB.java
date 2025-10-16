package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.Freight;
import model.Product;

public class FreightDB implements FreightDAO{
	private static final String FIND_BY_ID_Q = "SELECT * FROM Freight WHERE FreightId = ?";
	private static final String INSERT_Q = "INSERT INTO Freight VALUES (?, ?, ?, ?)";
	
	private PreparedStatement selectByIdPS;
	private PreparedStatement insertPS;
	
	public FreightDB() {
		try {
			initPreparedStatement();
		} catch (DataAccessException e) {
		}
	}
	
	private void initPreparedStatement() throws DataAccessException {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			selectByIdPS = connection.prepareStatement(FIND_BY_ID_Q);
			insertPS = connection.prepareStatement(INSERT_Q, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	private Freight buildObject(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String method = rs.getString(2);
		LocalDate localDate = rs.getDate(3).toLocalDate();
		String address = rs.getString(4);
		Freight f = new Freight(id, method, localDate, address);
		return f;
		}
	
	@Override
	public void addFreight(Freight freight) throws SQLException {
		int freightId = 0;
		insertPS.setString(2, freight.getMethod());
		insertPS.setDate(3, java.sql.Date.valueOf(freight.getDeliveryDate()));
		insertPS.setString(4,  freight.getAddress());
		insertPS.executeUpdate();
		
		ResultSet keyRS = insertPS.getGeneratedKeys();
		if (keyRS.next()) {
			freightId = keyRS.getInt(1);
			freight.setFreightId(freightId);
		}
	}

	@Override
	public Freight findFreightById(int freightId) throws SQLException {
		Freight freight = null;
		ResultSet resultSet;

		selectByIdPS.setInt(1, freightId);
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			freight = buildObject(resultSet);
		}
		return freight;
	}

}
