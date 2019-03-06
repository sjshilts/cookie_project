package testingSuite;

import static org.junit.jupiter.api.Assertions.*;

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
	void testGetOutflow() throws SQLException {
		GetData test = new GetData("jmperttu","rQJ!EAA3");
		ArrayList<Outflow> array = new ArrayList<>();
		assertNotNull(test.getOutflow());
		array = test.getOutflow();
		assertEquals(3, array.size());
		assertEquals(56.31,array.get(1).getAmount());
//		fail("Not yet implemented");
	}

	@Test
	void testGetInflow() throws SQLException {
		GetData test = new GetData("jmperttu","rQJ!EAA3");
		ArrayList<Inflow> array = new ArrayList<>();
		assertNotNull(test.getInflow());
		array = test.getInflow();
		assertEquals(3, array.size());
		assertEquals(56.31,array.get(1).getAmount());
	}

}
