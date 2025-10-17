package db;

import java.sql.SQLException;

import model.Freight;

public interface FreightDAO {
	public void addFreight(Freight freight) throws SQLException;
	public Freight findFreightById(int freightId) throws SQLException;
}
