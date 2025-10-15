package db;

import java.sql.SQLException;

import model.Freight;

public interface FreightDAO {

	public void insertFreight(Freight freight) throws SQLException;
}
