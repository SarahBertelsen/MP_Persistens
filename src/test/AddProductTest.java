package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import db.DataAccessException;

class addProductTest {
	@BeforeEach
	 void setUp() throws SQLException, IOException, DataAccessException {
		TestUtilitiesGenerateData tugd = new TestUtilitiesGenerateData();
		tugd.cleanDB();
		tugd.generateDB();
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
