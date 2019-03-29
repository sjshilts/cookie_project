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
//testingcomment  
	@Test
	void testGetData() {
		fail("Not yet implemented");
	}

	@Test
	void testNullGetOutflow() throws SQLException, IOException {
		GetData test = new GetData("jmperttu","thewitchking");
		assertNotNull(test.getOutflow());
		test.closeConn();
	}
	@Test
	void testEqualsGetOutflow() throws SQLException, IOException {
		GetData test = new GetData("jmperttu","thewitchking");
		ArrayList<Outflow> array = new ArrayList<>();
		double num = 0;
		array = test.getOutflow();
		assertEquals(11, array.size());
		assertEquals(56.31,array.get(1).getAmount());
		for(int i = 0; i < array.size(); i++) {
			num += array.get(i).getAmount();
		}
		assertEquals(734.96,num);
		test.closeConn();
	}

	@Test
	void testEqualsGetInflow() throws SQLException, IOException {
		GetData test = new GetData("jmperttu","thewitchking");
		ArrayList<Inflow> array = new ArrayList<>();
		array = test.getInflow();
		double num = 0;
		assertEquals(8, array.size());
		assertEquals(1,array.get(1).getAmount());
		for(int i = 0; i < array.size(); i++) {
			num += array.get(i).getAmount();
		}
		assertEquals(1166.62, num);
		test.closeConn();
	}

}
