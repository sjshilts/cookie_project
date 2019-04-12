package testingSuite;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

import backend.dbConnect;

public class TestdbConnect {

	@Test
	public void testDbConnect() {
		
	}

	@Test
	public void testConnect() throws SQLException {
		dbConnect test = new dbConnect();
		String user = "jmperttu";
		String password = "thewitchking";
		assertNotNull(test.connect(user, password));
	}

}