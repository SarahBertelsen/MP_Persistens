package db;

import java.sql.SQLException;

import model.Discount;

public interface DiscountDAO {

	public void insertDiscount(Discount discount) throws SQLException;
}
