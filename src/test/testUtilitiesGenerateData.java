package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import db.CustomerDB;
import db.DBConnection;
import db.ProductDB;
import db.StockDB;
import model.Customer;
import model.Product;

public class TestUtilitiesGenerateData {
	private static final String DELETE_CUSTOMERS_Q = "DELETE FROM Customer";
	private PreparedStatement deleteCustomersPS;
	private PreparedStatement deleteProductsPS;
	private PreparedStatement deleteStockPS;
	private PreparedStatement deleteWarehousePS;
	
	private ArrayList<Product> products; 
	private ArrayList<Customer> customers;
	
	public TestUtilitiesGenerateData() throws SQLException {
		initPreparedStatement();
		products = new ArrayList<>();
		customers = new ArrayList<>();
	}
	
	public void initPreparedStatement() throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		deleteCustomersPS = connection.prepareStatement(DELETE_CUSTOMERS_Q);
	}
	
	public void generateCustomers() throws SQLException {
		CustomerDB customerDB = new CustomerDB();
		Customer customer = new Customer(0, "Thomas", "Murray", "Aalborg", 9000, "53537923");
		customerDB.addCustomer(customer);
	}
	
	public void deleteCustomers() throws SQLException {
		deleteCustomersPS.executeUpdate();
	}
	
	public void generateProducts() throws SQLException {
		ProductDB pdb = new ProductDB();
		Product product = new Product(0, "banana", "Fruit");
		Product product1 = new Product(1, "strawberry", "Fruit");
		Product product2 = new Product(2, "orange", "Fruit");
		product = pdb.addProduct(product);
		product1 = pdb.addProduct(product1);
		product2 = pdb.addProduct(product2);
		products.add(product);
		products.add(product1);
		products.add(product2);
	}
	
	public void deleteProducts() throws SQLException {
		deleteProductsPS.executeUpdate();
	}
	
	public void cleanDB() throws SQLException {
		deleteCustomers();
	}
	
	public void generateStock() {
		StockDB sdb = new StockDB();
		Product product = new ProductDB().findProductById(1);
		Warehouse warehouse = new WarehouseDB().findWarehouseById(1);
		int availableQty = 5;
		int reservedQty = 5;
		int minStock = 5;
		Stock stock = new Stock(product, warehouse, availableQty, reservedQty, minStock);
		sdb.addStock(stock);
	}
	
	public void deleteStock() throws SQLException {
		deleteStockPS.executeUpdate();
	}
	
	public void generateWarehouse() {
		WarehouseDB wdb = new Warehouse();
		Warehouse warehouse = new Warehouse(1, "Main warehouse", "massive warehouse");
		wdb.addWarehouse(warehouse);
	}
	
	public void deleteWarehouse() throws SQLException {
		deleteWarehousePS.executeUpdate();
	}
	
	public void generateDB() throws SQLException {
		generateCustomers();
		generateProducts();
		generateStock();
		generateWarehouse();
	}
}
