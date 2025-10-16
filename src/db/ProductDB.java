package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ClothingProduct;
import model.EquipmentProduct;
import model.GunReplicaProduct;
import model.MusicProduct;
import model.Product;

public class ProductDB implements ProductDAO{

	private static final String INSERT_Q = "INSERT INTO Product VALUES (?, ?)";
	private static final String FIND_BY_ID_Q = "SELECT * FROM Product WHERE ProductId = ?";
	private static final String FIND_MUSIC_BY_ID_Q = "SELECT * FROM MusicProduct WHERE ProductId = ?";
	private static final String FIND_CLOTHING_BY_ID_Q = "SELECT * FROM ClothingProduct WHERE ProductId = ?";
	private static final String FIND_EQUIPMENT_BY_ID_Q = "SELECT * FROM EquipmentProduct WHERE ProductId = ?";
	private static final String FIND_GUN_REPLICA_BY_ID_Q = "SELECT * FROM GunReplicaProduct WHERE ProductId = ?";
	
	private PreparedStatement insertPS;
	private PreparedStatement selectByIdPS;
	private PreparedStatement selectMusicByIdPS;
	private PreparedStatement selectClothingByIdPS;
	private PreparedStatement selectEquipmentByIdPS;
	private PreparedStatement selectGunReplicaByIdPS;
	

	public ProductDB() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		insertPS = connection.prepareStatement(INSERT_Q, Statement.RETURN_GENERATED_KEYS);
		selectByIdPS = connection.prepareStatement(FIND_BY_ID_Q);
		selectMusicByIdPS = connection.prepareStatement(FIND_MUSIC_BY_ID_Q);
		selectClothingByIdPS = connection.prepareStatement(FIND_CLOTHING_BY_ID_Q);
		selectEquipmentByIdPS = connection.prepareStatement(FIND_EQUIPMENT_BY_ID_Q);
		selectGunReplicaByIdPS = connection.prepareStatement(FIND_GUN_REPLICA_BY_ID_Q);
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

	public Product addProduct(Product product) throws SQLException {
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
		double salePrice = rs.getDouble(4);
		
		switch(productType) {
		case "music":
			product = buildMusicProduct(productId, name, productType, salePrice);
			break;
		case "clothing":
			product = buildClothingProduct(productId, name, productType, salePrice);
			break;
		case "equipment":
			product = buildEquipmentProduct(productId, name, productType, salePrice);
			break;
		case "gunReplica":
			product = buildGunReplicaProduct(productId, name, productType, salePrice);
			break;
		default:
			product = new Product(productId, name, productType, salePrice);
			break;
		}
		
		return product;
	}
	
	private MusicProduct buildMusicProduct(int productId, String name, String productType, double salePrice) throws SQLException {
		MusicProduct musicProduct = null;
		ResultSet resultSet;

		selectMusicByIdPS.setInt(1, productId);
		resultSet = selectMusicByIdPS.executeQuery();
		
		String format = resultSet.getString(2);
		String artist = resultSet.getString(3);
		
		musicProduct = new MusicProduct(productId, name, productType, salePrice, format, artist);
		
		return musicProduct;
	}

	private ClothingProduct buildClothingProduct(int productId, String name, String productType, double salePrice) throws SQLException {
		ClothingProduct clothingProduct = null;
		ResultSet resultSet;

		selectClothingByIdPS.setInt(1, productId);
		resultSet = selectClothingByIdPS.executeQuery();
		
		String size = resultSet.getString(2);
		String colour = resultSet.getString(3);
		
		clothingProduct = new ClothingProduct(productId, name, productType, salePrice, size, colour);
		
		return clothingProduct;
	}

	private EquipmentProduct buildEquipmentProduct(int productId, String name, String productType, double salePrice) throws SQLException {
		EquipmentProduct equipmentProduct = null;
		ResultSet resultSet;

		selectEquipmentByIdPS.setInt(1, productId);
		resultSet = selectEquipmentByIdPS.executeQuery();
		
		String material = resultSet.getString(2);
		String style = resultSet.getString(3);
		
		equipmentProduct = new EquipmentProduct(productId, name, productType, salePrice, material, style);
		
		return equipmentProduct;
	}

	private GunReplicaProduct buildGunReplicaProduct(int productId, String name, String productType, double salePrice) throws SQLException {
		GunReplicaProduct gunReplicaProduct = null;
		ResultSet resultSet;

		selectGunReplicaByIdPS.setInt(1, productId);
		resultSet = selectGunReplicaByIdPS.executeQuery();
		
		String calibre = resultSet.getString(2);
		String material = resultSet.getString(3);
		
		gunReplicaProduct = new GunReplicaProduct(productId, name, productType, salePrice, calibre, material);
		
		return gunReplicaProduct;
	}
	
}