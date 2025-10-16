package db;

import java.sql.SQLException;

import model.Freight;

public interface FreightDAO {
	public Freight addFreight(Freight freight) throws SQLException;
	public Freight findFreightById(int freightId) throws SQLException;
}
