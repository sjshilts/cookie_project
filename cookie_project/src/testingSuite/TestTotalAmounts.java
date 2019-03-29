package testingSuite;

import static org.junit.jupiter.api.Assertions.*;

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
	void testGetTotal() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts total = new TotalAmounts(inflow, outflow);
		assertEquals(431.66, total.getTotal());
	}

	@Test
	void testGetTotalInflow() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts in = new TotalAmounts(inflow, outflow);
		assertEquals(1166.62, in.getTotalInflow());
	}

	@Test
	void testGetTotalOutflow()  throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts out = new TotalAmounts(inflow, outflow);
		assertEquals(734.96, out.getTotalOutflow());
	}

	@Test
	void testGetTotalBills() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts bills = new TotalAmounts(inflow, outflow);
		assertEquals(351.73, bills.getTotalBills());
	}

	@Test
	void testGetTotalCostOfLiving() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts col = new TotalAmounts(inflow, outflow);
		assertEquals(94.21,(col.getTotalCostOfLiving()));
	}

	@Test
	void testGetTotalLuxery() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts lux = new TotalAmounts(inflow, outflow);
		assertEquals(89,lux.getTotalLuxery());
	}

	@Test
	void testGetTotalSavings() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts sav = new TotalAmounts(inflow, outflow);
		assertEquals(200, sav.getTotalSavings());
	}

	@Test
	void testGetTotalPaychecks() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts paycheck = new TotalAmounts(inflow, outflow);
		assertEquals(1050,paycheck.getTotalPaychecks());
	}

	@Test
	void testGetTotalOtherIncome() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts other = new TotalAmounts(inflow, outflow);
		assertEquals(50.62, other.getTotalOtherIncome());
	}

	@Test
	void testGetTotalUnearnedIncome()  throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts unearned = new TotalAmounts(inflow, outflow);
		assertEquals(60, unearned.getTotalUnearnedIncome());
	}

	@Test
	void testGetTotalElectric()  throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts elect = new TotalAmounts(inflow, outflow);
		assertEquals(43.11, elect.getTotalElectric());
	}

	@Test
	void testGetTotal401K() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts fourohonekay = new TotalAmounts(inflow, outflow);
		assertEquals(100, fourohonekay.getTotal401K());
	}

	@Test
	void testGetTotalGas() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts gas = new TotalAmounts(inflow, outflow);
		assertEquals(60, gas.getTotalGas());
	}

	@Test
	void testGetTotalGroceries() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts groci = new TotalAmounts(inflow, outflow);
		assertEquals(34.21, groci.getTotalGroceries());
	}

	@Test
	void testGetTotalHeat()  throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts heat = new TotalAmounts(inflow, outflow);
		assertEquals(87.31, heat.getTotalHeat());
	}

	@Test
	void testGetTotalHousing() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts house = new TotalAmounts(inflow, outflow);
		assertEquals(56, house.getTotalHousing());
	}

	@Test
	void testGetTotalInternet() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts inter = new TotalAmounts(inflow, outflow);
		assertEquals(109, inter.getTotalInternet());
	}

	@Test
	void testGetTotalOtherSavings() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts sav = new TotalAmounts(inflow, outflow);
		assertEquals(100, sav.getTotalOtherSavings());
	}

	@Test
	void testGetTotalWater() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts water = new TotalAmounts(inflow, outflow);
		assertEquals(56.31, water.getTotalWater());
	}

	@Test
	void testResetData()  throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow(); 
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts data1 = new TotalAmounts(inflow, outflow);
		data1.resetData();
		assertEquals(0, data1.getTotalOutflow());
		assertEquals(0, data1.getTotalInflow());
	}

	@Test
	void testResetInflow() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts in = new TotalAmounts(inflow, outflow);
		in.resetInflow();
		assertEquals(0, in.getTotalInflow());
	}

	@Test
	void testResetOutflow() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts out = new TotalAmounts(inflow, outflow);
		out.resetData();
		assertEquals(0, out.getTotalOutflow());
	}

	@SuppressWarnings("deprecation")
	@Test
	void testSetInflow() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts in = new TotalAmounts(inflow, outflow);
		ArrayList<Inflow> newInflow = new ArrayList<>();
		newInflow.add(new Inflow(new Date(2019, 2, 18), 100));
		in.setInflow(newInflow);
		assertEquals(100, in.getTotalInflow());
	}

	@SuppressWarnings("deprecation")
	@Test 
	void testSetOutflow() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts out = new TotalAmounts(inflow, outflow);
		ArrayList<Outflow> newOutflow = new ArrayList<>();
		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
		out.setOutflow(newOutflow);
		assertEquals(100, out.getTotalOutflow());
	}

	@SuppressWarnings("deprecation")
	@Test
	void testAddInflow() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts in = new TotalAmounts(inflow, outflow);
		ArrayList<Inflow> newInflow = new ArrayList<>();
		newInflow.add(new Inflow(new Date(2019, 2, 18), 100));
		in.addInflow(newInflow);
		assertEquals(1166.62, in.getTotalInflow());
	}

	@SuppressWarnings("deprecation")
	@Test
	void testAddOutflow() throws SQLException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts out = new TotalAmounts(inflow, outflow);
		ArrayList<Outflow> newOutflow = new ArrayList<>();
		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
		out.addOutflow(newOutflow);
		assertEquals(634.94, out.getTotalOutflow());
	}

}
