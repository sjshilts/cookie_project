package testingSuite;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import backend.TotalAmounts;
import type.Inflow;
import type.Outflow;

public class TestTotalAmounts {

	@BeforeAll public static void init() throws SQLException, IOException {
		// set account number
		OutputStream targetStream = new FileOutputStream("src/userInterface/AccountNumber.txt");
		String accNum = "3";
		byte[] b = accNum.getBytes();
		targetStream.write(b);
		targetStream.close();
		
	}

	@Test
	public void testTotalAmounts() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(4581.84,Double.parseDouble(String.format("%.2f", total.getTotal()) ));
	}
	@Test
	public void testGetTotal() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(4581.84, Double.parseDouble(String.format("%.2f", total.getTotal())) );
	}

	@Test
	public void testGetInitBal() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(100, Double.parseDouble(String.format("%.2f", total.getInitBal())) );
	}

	@Test
	public void testGetTotalInflow() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(11617.44, Double.parseDouble(String.format("%.2f", total.getTotalInflow())) );
	}
	
	void testGetTotalinitBal() throws SQLException, IOException {
		TotalAmounts bills = new TotalAmounts();
		assertEquals(351.73, bills.getInitBal());
	}
	
	@Test
	public void testGetTotalOutflow() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(7135.6, Double.parseDouble(String.format("%.2f", total.getTotalOutflow())) );
	}

	@Test
	public void testGetTotalBills() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(3567.8, Double.parseDouble(String.format("%.2f", total.getTotalBills())) );
	}

	@Test
	public void testGetTotalCostOfLiving() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(1427.12, Double.parseDouble(String.format("%.2f", total.getTotalCostOfLiving())) );
	}

	@Test
	public void testGetTotalLuxery() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalLuxery())) );
	}

	@Test
	public void testGetTotalSavings() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(1427.12, Double.parseDouble(String.format("%.2f", total.getTotalSavings())) );
	}

	@Test
	public void testGetTotalPaychecks() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(3872.48, Double.parseDouble(String.format("%.2f", total.getTotalPaychecks())) );
	}

	@Test
	public void testGetTotalOtherIncome() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(3872.48, Double.parseDouble(String.format("%.2f", total.getTotalOtherIncome())) );
	}

	@Test
	public void testGetTotalUnearnedIncome() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(3872.48, Double.parseDouble(String.format("%.2f", total.getTotalUnearnedIncome())) );
	}

	@Test
	public void testGetTotalElectric() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalElectric())) );
	}

	@Test
	public void testGetTotal401K() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotal401K())) );
	}

	@Test
	public void testGetTotalTransportation() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalTransportation())) );
	}

	@Test
	public void testGetTotalGroceries() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalGroceries())) );
	}

	@Test
	public void testGetTotalGas() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalGas())) );
	}

	@Test
	public void testGetTotalHousing() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalHousing())) );
	}
	@Test
	public void testGetTotalInternet() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalInternet())) );
	}
	@Test
	public void testGetTotalOtherSavings() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalOtherSavings())) );
	}
	@Test
	public void testGetTotalWater() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalWater())) );
	}

	@SuppressWarnings("deprecation")
	@Test
	void testSetInflow() throws SQLException, IOException {
		TotalAmounts in = new TotalAmounts();
		ArrayList<Inflow> newInflow = new ArrayList<>();
		newInflow.add(new Inflow(new Date(2019, 2, 18), 100));
		in.setInflow(newInflow);
		assertEquals(100, in.getTotalInflow());
	}

	@SuppressWarnings("deprecation")
	@Test 
	void testSetOutflow() throws SQLException, IOException {
		TotalAmounts out = new TotalAmounts();
		ArrayList<Outflow> newOutflow = new ArrayList<>();
		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
		out.setOutflow(newOutflow);
		assertEquals(100, out.getTotalOutflow());
	}

//	@SuppressWarnings("deprecation")
//	@Test
//	void testAddInflow() throws SQLException, IOException {
//		TotalAmounts in = new TotalAmounts();
//		ArrayList<Inflow> newInflow = new ArrayList<>();
//		newInflow.add(new Inflow(new Date(2019, 2, 18), 100));
//		in.addInflow(newInflow);
//		assertEquals(1166.62, in.getTotalInflow());
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test
//	void testAddOutflow() throws SQLException, IOException {
//		TotalAmounts out = new TotalAmounts();
//		ArrayList<Outflow> newOutflow = new ArrayList<>();
//		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
//		out.addOutflow(newOutflow);
//		assertEquals(634.94, out.getTotalOutflow());
//	}
}
