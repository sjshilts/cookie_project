package testingSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import backend.GetData;
import backend.TotalAmounts;
import type.Inflow;
import type.Outflow;

class TestTotalAmounts {
	//stillneedstestsatthebottom
	@Test
	void testGetTotal() throws SQLException, IOException {
		TotalAmounts total = new TotalAmounts();
		assertEquals(431.66, total.getTotal());
	}

	@Test
	void testGetTotalInflow() throws SQLException, IOException {
		TotalAmounts in = new TotalAmounts();
		assertEquals(1166.62, in.getTotalInflow());
	}

	@Test
	void testGetTotalOutflow()  throws SQLException, IOException {
		TotalAmounts out = new TotalAmounts();
		assertEquals(734.96, out.getTotalOutflow());
	}

	@Test
	void testGetTotalBills() throws SQLException, IOException {
		TotalAmounts bills = new TotalAmounts();
		assertEquals(351.73, bills.getTotalBills());
	}
	
	void testGetTotalinitBal() throws SQLException, IOException {
		TotalAmounts bills = new TotalAmounts();
		assertEquals(351.73, bills.getInitBal());
	}
	
	@Test
	void testGetTotalCostOfLiving() throws SQLException, IOException {
		TotalAmounts col = new TotalAmounts();
		assertEquals(94.21,(col.getTotalCostOfLiving()));
	}

	@Test
	void testGetTotalLuxery() throws SQLException, IOException {
		TotalAmounts lux = new TotalAmounts();
		assertEquals(89,lux.getTotalLuxery());
	}

	@Test
	void testGetTotalSavings() throws SQLException, IOException {
		TotalAmounts sav = new TotalAmounts();
		assertEquals(200, sav.getTotalSavings());
	}

	@Test
	void testGetTotalPaychecks() throws SQLException, IOException {
		TotalAmounts paycheck = new TotalAmounts();
		assertEquals(1050,paycheck.getTotalPaychecks());
	}

	@Test
	void testGetTotalOtherIncome() throws SQLException, IOException {
		TotalAmounts other = new TotalAmounts();
		assertEquals(50.62, other.getTotalOtherIncome());
	}

	@Test
	void testGetTotalUnearnedIncome()  throws SQLException, IOException {
		TotalAmounts unearned = new TotalAmounts();
		assertEquals(60, unearned.getTotalUnearnedIncome());
	}

	@Test
	void testGetTotalElectric()  throws SQLException, IOException {
		TotalAmounts elect = new TotalAmounts();
		assertEquals(43.11, elect.getTotalElectric());
	}

	@Test
	void testGetTotal401K() throws SQLException, IOException {
		TotalAmounts fourohonekay = new TotalAmounts();
		assertEquals(100, fourohonekay.getTotal401K());
	}

	@Test
	void testGetTotalGas() throws SQLException, IOException {
		TotalAmounts gas = new TotalAmounts();
		assertEquals(60, gas.getTotalGas());
	}

	@Test
	void testGetTotalGroceries() throws SQLException, IOException {
		TotalAmounts groci = new TotalAmounts();
		assertEquals(34.21, groci.getTotalGroceries());
	}

	@Test
	void testGetTotalHeat()  throws SQLException, IOException {
		TotalAmounts heat = new TotalAmounts();
		assertEquals(87.31, heat.getTotalHeat());
	}

	@Test
	void testGetTotalHousing() throws SQLException, IOException {
		TotalAmounts house = new TotalAmounts();
		assertEquals(56, house.getTotalHousing());
	}

	@Test
	void testGetTotalInternet() throws SQLException, IOException {
		TotalAmounts inter = new TotalAmounts();
		assertEquals(109, inter.getTotalInternet());
	}

	@Test
	void testGetTotalOtherSavings() throws SQLException, IOException {
		TotalAmounts sav = new TotalAmounts();
		assertEquals(100, sav.getTotalOtherSavings());
	}

	@Test
	void testGetTotalWater() throws SQLException, IOException {
		TotalAmounts water = new TotalAmounts();
		assertEquals(56.31, water.getTotalWater());
	}

	@Test
	void testResetData()  throws SQLException, IOException {
		TotalAmounts data1 = new TotalAmounts();
		data1.resetData();
		assertEquals(0, data1.getTotalOutflow());
		assertEquals(0, data1.getTotalInflow());
	}

	@Test
	void testResetInflow() throws SQLException, IOException {
		TotalAmounts in = new TotalAmounts();
		in.resetInflow();
		assertEquals(0, in.getTotalInflow());
	}

	@Test
	void testResetOutflow() throws SQLException, IOException {
		TotalAmounts out = new TotalAmounts();
		out.resetData();
		assertEquals(0, out.getTotalOutflow());
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

	@SuppressWarnings("deprecation")
	@Test
	void testAddInflow() throws SQLException, IOException {
		TotalAmounts in = new TotalAmounts();
		ArrayList<Inflow> newInflow = new ArrayList<>();
		newInflow.add(new Inflow(new Date(2019, 2, 18), 100));
		in.addInflow(newInflow);
		assertEquals(1166.62, in.getTotalInflow());
	}

	@SuppressWarnings("deprecation")
	@Test
	void testAddOutflow() throws SQLException, IOException {
		TotalAmounts out = new TotalAmounts();
		ArrayList<Outflow> newOutflow = new ArrayList<>();
		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
		out.addOutflow(newOutflow);
		assertEquals(634.94, out.getTotalOutflow());
	}

}
