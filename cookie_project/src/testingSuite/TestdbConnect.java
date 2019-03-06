package testingSuite;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import backend.dbConnect;

class TestdbConnect {

	@Test
	void testDbConnect() throws SQLException {
		fail("not implemented");
	}

	@Test
	void testConnect() throws SQLException {
		dbConnect test = new dbConnect();
		String user = "jmperttu";
		String password = "rQJ!EAA3";
		assertNotNull(test.connect(user, password));
	}

}
