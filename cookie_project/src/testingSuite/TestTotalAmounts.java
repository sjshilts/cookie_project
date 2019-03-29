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
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts total = new TotalAmounts();
		assertEquals(431.66, total.getTotal());
	}

	@Test
	void testGetTotalInflow() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts in = new TotalAmounts();
		assertEquals(1166.62, in.getTotalInflow());
	}

	@Test
	void testGetTotalOutflow()  throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts out = new TotalAmounts();
		assertEquals(734.96, out.getTotalOutflow());
	}

	@Test
	void testGetTotalBills() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts bills = new TotalAmounts();
		assertEquals(351.73, bills.getTotalBills());
	}

	@Test
	void testGetTotalCostOfLiving() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts col = new TotalAmounts();
		assertEquals(94.21,(col.getTotalCostOfLiving()));
	}

	@Test
	void testGetTotalLuxery() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts lux = new TotalAmounts();
		assertEquals(89,lux.getTotalLuxery());
	}

	@Test
	void testGetTotalSavings() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts sav = new TotalAmounts();
		assertEquals(200, sav.getTotalSavings());
	}

	@Test
	void testGetTotalPaychecks() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts paycheck = new TotalAmounts();
		assertEquals(1050,paycheck.getTotalPaychecks());
	}

	@Test
	void testGetTotalOtherIncome() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts other = new TotalAmounts();
		assertEquals(50.62, other.getTotalOtherIncome());
	}

	@Test
	void testGetTotalUnearnedIncome()  throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts unearned = new TotalAmounts();
		assertEquals(60, unearned.getTotalUnearnedIncome());
	}

	@Test
	void testGetTotalElectric()  throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts elect = new TotalAmounts();
		assertEquals(43.11, elect.getTotalElectric());
	}

	@Test
	void testGetTotal401K() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts fourohonekay = new TotalAmounts();
		assertEquals(100, fourohonekay.getTotal401K());
	}

	@Test
	void testGetTotalGas() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts gas = new TotalAmounts();
		assertEquals(60, gas.getTotalGas());
	}

	@Test
	void testGetTotalGroceries() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts groci = new TotalAmounts();
		assertEquals(34.21, groci.getTotalGroceries());
	}

	@Test
	void testGetTotalHeat()  throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts heat = new TotalAmounts();
		assertEquals(87.31, heat.getTotalHeat());
	}

	@Test
	void testGetTotalHousing() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts house = new TotalAmounts();
		assertEquals(56, house.getTotalHousing());
	}

	@Test
	void testGetTotalInternet() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts inter = new TotalAmounts();
		assertEquals(109, inter.getTotalInternet());
	}

	@Test
	void testGetTotalOtherSavings() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts sav = new TotalAmounts();
		assertEquals(100, sav.getTotalOtherSavings());
	}

	@Test
	void testGetTotalWater() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts water = new TotalAmounts();
		assertEquals(56.31, water.getTotalWater());
	}

	@Test
	void testResetData()  throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow(); 
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts data1 = new TotalAmounts();
		data1.resetData();
		assertEquals(0, data1.getTotalOutflow());
		assertEquals(0, data1.getTotalInflow());
	}

	@Test
	void testResetInflow() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts in = new TotalAmounts();
		in.resetInflow();
		assertEquals(0, in.getTotalInflow());
	}

	@Test
	void testResetOutflow() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts out = new TotalAmounts();
		out.resetData();
		assertEquals(0, out.getTotalOutflow());
	}

	@SuppressWarnings("deprecation")
	@Test
	void testSetInflow() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		ArrayList<Inflow> inflow = data.getInflow();
		TotalAmounts in = new TotalAmounts();
		ArrayList<Inflow> newInflow = new ArrayList<>();
		newInflow.add(new Inflow(new Date(2019, 2, 18), 100));
		in.setInflow(newInflow);
		assertEquals(100, in.getTotalInflow());
	}

//	@SuppressWarnings("deprecation")
//	@Test 
//	void testSetOutflow() throws SQLException, IOException {
//		GetData data = new GetData("jmperttu", "thewitchking");
//		ArrayList<Outflow> outflow = data.getOutflow();
//		ArrayList<Inflow> inflow = data.getInflow();
//<<<<<<< HEAD
//		TotalAmounts out = new TotalAmounts(inflow, outflow);
//		ArrayList<Outflow> newOutflow = new ArrayList<>();
//		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
//		out.setOutflow(newOutflow);
//=======
//		TotalAmounts out = new TotalAmounts();
//		ArrayList<Inflow> newOutflow = new ArrayList<>();
//		newOutflow.add(new Inflow(new Date(2019, 2, 18), 100));
//		out.addInflow(newOutflow);
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//		assertEquals(100, out.getTotalOutflow());
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test
//	void testAddInflow() throws SQLException, IOException {
//		GetData data = new GetData("jmperttu", "thewitchking");
//		ArrayList<Outflow> outflow = data.getOutflow();
//		ArrayList<Inflow> inflow = data.getInflow();
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
//		GetData data = new GetData("jmperttu", "thewitchking");
//		ArrayList<Outflow> outflow = data.getOutflow();
//		ArrayList<Inflow> inflow = data.getInflow();
//		TotalAmounts out = new TotalAmounts(inflow, outflow);
//		ArrayList<Outflow> newOutflow = new ArrayList<>();
//		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
//		out.addOutflow(newOutflow);
//=======
//		TotalAmounts out = new TotalAmounts();
//		ArrayList<Inflow> newOutflow = new ArrayList<>();
//		newOutflow.add(new Inflow(new Date(2019, 2, 18), 100));
//		out.addInflow(newOutflow);
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//		assertEquals(634.94, out.getTotalOutflow());
//	}

}
