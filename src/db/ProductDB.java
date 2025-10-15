package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Product;

public class ProductDB {
	private static final String INSERT_Q = "INSERT INTO Product VALUES (?, ?, ?)";
	private static final String FIND_BY_ID_Q = "SELECT * FROM Product WHERE ProductId = ?";

	private PreparedStatement insertPS;
	private PreparedStatement selectByIdPS;

	public ProductDB() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q, Statement.RETURN_GENERATED_KEYS);
		selectByIdPS = connection.prepareStatement(FIND_BY_ID_Q);
	}

	public Product findProductById(int productId) throws SQLException {
		Product product = null;
		ResultSet resultSet;

		selectByIdPS.setInt(1, productId);
		resultSet = selectByIdPS.executeQuery();
		if (resultSet.next()) {
			product = buildObject(resultSet);
		}
		return product;
	}

	public Product insert(Product product) throws SQLException {
		int productId = 0;
		insertPS.setString(1, product.getName());
		insertPS.setString(2, product.getProductType());

		insertPS.executeUpdate();
		ResultSet keyRS = insertPS.getGeneratedKeys();
		if (keyRS.next()) {
			productId = keyRS.getInt(1);
			product.setProductId(productId);
		}
		return product;
	}

	private Product buildObject(ResultSet rs) throws SQLException {

		Product product = null;
		int productId = rs.getInt(1);
		String name = rs.getString(2);
		String productType = rs.getString(3);

		return new Product(productId, name, productType);
	}
}
