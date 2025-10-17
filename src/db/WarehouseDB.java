package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Warehouse;

public class WarehouseDB implements WarehouseDAO{
	private static final String SELECT_BY_ID_Q = "SELECT * FROM WareHouse WHERE WareHouseId = ?";
	private static final String INSERT_Q = "INSERT INTO Customer VALUES (?, ? ?)";
	private PreparedStatement selectByIdPS;
	private PreparedStatement insertPS;

	public WarehouseDB() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q);
		selectByIdPS = connection.prepareStatement(SELECT_BY_ID_Q, Statement.RETURN_GENERATED_KEYS);
	}

	public Warehouse findWarehouseById(int warehouseId) throws SQLException {
		Warehouse warehouse = null;
		ResultSet resultSet;

		selectByIdPS.setInt(1, warehouseId);
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			warehouse = buildObject(resultSet);
		}
		return warehouse;
	}

	private Warehouse buildObject(ResultSet rs) throws SQLException {
		Warehouse customer = null;

		int warehouseId = rs.getInt(1);
		String name = rs.getString(2);
		String description = rs.getString(3);
		
		customer = new Warehouse(warehouseId, name, description);
		return customer;
	}

	public Warehouse addWarehouse(Warehouse warehouse) throws SQLException {
		int warehouseId = 0;
		
		String name = warehouse.getName();
		String description = warehouse.getDescription();
		
		insertPS.setString(2, name);
		insertPS.setString(3, description);

		insertPS.executeUpdate();
		ResultSet keyRS = insertPS.getGeneratedKeys();
		if (keyRS.next()) {
			warehouseId = keyRS.getInt(1);
			warehouse.setWarehouseId(warehouseId);
		}
		
		return warehouse;
	}
}
