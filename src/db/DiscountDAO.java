package db;

import java.sql.SQLException;

import model.Discount;

public interface DiscountDAO {
	public Discount addDiscount(Discount discount) throws SQLException;
	public Discount findDiscountById(int discountId) throws SQLException;
}
