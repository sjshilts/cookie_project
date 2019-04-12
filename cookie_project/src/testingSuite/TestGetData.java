package testingSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import backend.GetData;
import type.Inflow;
import type.Outflow;

class TestGetData {

	@Test
	void testGetData() throws SQLException {
		GetData test = new GetData("jmperttu","thewitchking");
		assertNotNull(test);
		test.closeConn();

	}


	@Test
	void testCloseConn() throws SQLException {
		GetData test = new GetData("jmperttu","thewitchking");
		test.closeConn();
		assertNotNull(test);
	}

	@Test
	void testGetOutflow() throws SQLException, IOException {
		GetData test = new GetData("jmperttu","thewitchking");
		
		ArrayList<Outflow> array = new ArrayList<>();
		double num = 0;
		array = test.getOutflow();
		
		assertNotNull(test.getOutflow());
		assertEquals(240, array.size());
		
		for(int i = 0; i < array.size(); i++) {
			assertTrue( array.get(i) instanceof Outflow);
		}
		
		test.closeConn();
	}

	@Test
	void testGetInflow() throws SQLException, IOException {
		GetData test = new GetData("jmperttu","thewitchking");
		ArrayList<Inflow> array = new ArrayList<>();
		array = test.getInflow();
		double num = 0;
		
		assertNotNull(test.getOutflow());
		assertEquals(48, array.size());
		
		for(int i = 0; i < array.size(); i++) {
			assertTrue( array.get(i) instanceof Inflow);
		}
		
		test.closeConn();
	}

	@Test
	void testGetInitBalance() throws NumberFormatException, SQLException, IOException {
		GetData test = new GetData("jmperttu","thewitchking");
		assertEquals(100.00, Double.parseDouble(String.format("%.2f", test.getInitBalance())) );
	}

}
