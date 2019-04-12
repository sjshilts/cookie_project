package testingSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import backend.GetData;
import type.*;

class TestTypes {

	@Test
	void testIneritance() throws SQLException, IOException {
		Date date = new Date(2019, 1, 12);
		Outflow electric = new Electric(date, 12.1);
		Outflow water = new Water(date, 12.1);
		Outflow four01K = new Four01K(date, 12.1);
		Outflow gas = new Gas(date, 12.1);
		
		Inflow paycheck = new Paycheck(date, 43.3);
		
		assertTrue(electric instanceof Bill);
		assertTrue(water instanceof Bill);
		assertTrue(gas instanceof Bill);
		
		
	}
	
	@Test
	void testGetters() throws SQLException, IOException {
		Date date = new Date(2019, 1, 12);
		Outflow electric = new Electric(date, 12.1);
		Outflow water = new Water(date, 12.1);
		Outflow four01K = new Four01K(date, 12.1);
		Outflow gas = new Gas(date, 12.1);
		
		Inflow paycheck = new Paycheck(date, 43.3);
		
		assertEquals(12.1, electric.getAmount() );
		assertEquals(12.1, water.getAmount());
		assertEquals(12.1, four01K.getAmount());
		assertEquals(12.1, gas.getAmount());
		
		assertEquals(43.3, paycheck.getAmount());
	}

}
