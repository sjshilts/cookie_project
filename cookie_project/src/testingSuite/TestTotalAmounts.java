//package testingSuite;
//
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.sql.SQLException;
//
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
//
//import backend.TotalAmounts;
//
//public class TestTotalAmounts {
//
//	@BeforeAll public static void init() throws SQLException, IOException {
//		// set account number
//		OutputStream targetStream = new FileOutputStream("src/userInterface/AccountNumber.txt");
//		String accNum = "3";
//		byte[] b = accNum.getBytes();
//		targetStream.write(b);
//		targetStream.close();
//		
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotal() throws SQLException, IOException {
//=======
//	public void testTotalAmounts() throws SQLException, IOException {
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(4581.84,Double.parseDouble(String.format("%.2f", total.getTotal()) ));
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalInflow() throws SQLException, IOException {
//		TotalAmounts in = new TotalAmounts();
//		assertEquals(1166.62, in.getTotalInflow());
//=======
//	public void testGetTotal() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(4581.84, Double.parseDouble(String.format("%.2f", total.getTotal())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalOutflow()  throws SQLException, IOException {
//		TotalAmounts out = new TotalAmounts();
//		assertEquals(734.96, out.getTotalOutflow());
//=======
//	public void testGetInitBal() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(100, Double.parseDouble(String.format("%.2f", total.getInitBal())) );
//		
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalBills() throws SQLException, IOException {
//		TotalAmounts bills = new TotalAmounts();
//		assertEquals(351.73, bills.getTotalBills());
//=======
//	public void testGetTotalInflow() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(11617.44, Double.parseDouble(String.format("%.2f", total.getTotalInflow())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//	
//	void testGetTotalinitBal() throws SQLException, IOException {
//		TotalAmounts bills = new TotalAmounts();
//		assertEquals(351.73, bills.getInitBal());
//	}
//	
//	@Test
//<<<<<<< HEAD
//	void testGetTotalCostOfLiving() throws SQLException, IOException {
//		TotalAmounts col = new TotalAmounts();
//		assertEquals(94.21,(col.getTotalCostOfLiving()));
//=======
//	public void testGetTotalOutflow() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(7135.6, Double.parseDouble(String.format("%.2f", total.getTotalOutflow())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalLuxery() throws SQLException, IOException {
//		TotalAmounts lux = new TotalAmounts();
//		assertEquals(89,lux.getTotalLuxery());
//=======
//	public void testGetTotalBills() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(3567.8, Double.parseDouble(String.format("%.2f", total.getTotalBills())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalSavings() throws SQLException, IOException {
//		TotalAmounts sav = new TotalAmounts();
//		assertEquals(200, sav.getTotalSavings());
//=======
//	public void testGetTotalCostOfLiving() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(1427.12, Double.parseDouble(String.format("%.2f", total.getTotalCostOfLiving())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalPaychecks() throws SQLException, IOException {
//		TotalAmounts paycheck = new TotalAmounts();
//		assertEquals(1050,paycheck.getTotalPaychecks());
//=======
//	public void testGetTotalLuxery() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalLuxery())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalOtherIncome() throws SQLException, IOException {
//		TotalAmounts other = new TotalAmounts();
//		assertEquals(50.62, other.getTotalOtherIncome());
//=======
//	public void testGetTotalSavings() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(1427.12, Double.parseDouble(String.format("%.2f", total.getTotalSavings())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalUnearnedIncome()  throws SQLException, IOException {
//		TotalAmounts unearned = new TotalAmounts();
//		assertEquals(60, unearned.getTotalUnearnedIncome());
//=======
//	public void testGetTotalPaychecks() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(3872.48, Double.parseDouble(String.format("%.2f", total.getTotalPaychecks())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalElectric()  throws SQLException, IOException {
//		TotalAmounts elect = new TotalAmounts();
//		assertEquals(43.11, elect.getTotalElectric());
//=======
//	public void testGetTotalOtherIncome() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(3872.48, Double.parseDouble(String.format("%.2f", total.getTotalOtherIncome())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotal401K() throws SQLException, IOException {
//		TotalAmounts fourohonekay = new TotalAmounts();
//		assertEquals(100, fourohonekay.getTotal401K());
//=======
//	public void testGetTotalUnearnedIncome() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(3872.48, Double.parseDouble(String.format("%.2f", total.getTotalUnearnedIncome())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalGas() throws SQLException, IOException {
//		TotalAmounts gas = new TotalAmounts();
//		assertEquals(60, gas.getTotalGas());
//=======
//	public void testGetTotalElectric() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalElectric())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalGroceries() throws SQLException, IOException {
//		TotalAmounts groci = new TotalAmounts();
//		assertEquals(34.21, groci.getTotalGroceries());
//=======
//	public void testGetTotal401K() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotal401K())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalHeat()  throws SQLException, IOException {
//		TotalAmounts heat = new TotalAmounts();
//		assertEquals(87.31, heat.getTotalHeat());
//=======
//	public void testGetTotalTransportation() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalTransportation())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalHousing() throws SQLException, IOException {
//		TotalAmounts house = new TotalAmounts();
//		assertEquals(56, house.getTotalHousing());
//=======
//	public void testGetTotalGroceries() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalGroceries())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalInternet() throws SQLException, IOException {
//		TotalAmounts inter = new TotalAmounts();
//		assertEquals(109, inter.getTotalInternet());
//=======
//	public void testGetTotalGas() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalGas())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalOtherSavings() throws SQLException, IOException {
//		TotalAmounts sav = new TotalAmounts();
//		assertEquals(100, sav.getTotalOtherSavings());
//=======
//	public void testGetTotalHousing() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalHousing())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testGetTotalWater() throws SQLException, IOException {
//		TotalAmounts water = new TotalAmounts();
//		assertEquals(56.31, water.getTotalWater());
//=======
//	public void testGetTotalInternet() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalInternet())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testResetData()  throws SQLException, IOException {
//		TotalAmounts data1 = new TotalAmounts();
//		data1.resetData();
//		assertEquals(0, data1.getTotalOutflow());
//		assertEquals(0, data1.getTotalInflow());
//=======
//	public void testGetTotalOtherSavings() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalOtherSavings())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//	@Test
//<<<<<<< HEAD
//	void testResetInflow() throws SQLException, IOException {
//		TotalAmounts in = new TotalAmounts();
//		in.resetInflow();
//		assertEquals(0, in.getTotalInflow());
//=======
//	public void testGetTotalWater() throws SQLException, IOException {
//		TotalAmounts total = new TotalAmounts();
//		assertEquals(713.56, Double.parseDouble(String.format("%.2f", total.getTotalWater())) );
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//	}
//
//<<<<<<< HEAD
//	@Test
//	void testResetOutflow() throws SQLException, IOException {
//		TotalAmounts out = new TotalAmounts();
//		out.resetData();
//		assertEquals(0, out.getTotalOutflow());
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test
//	void testSetInflow() throws SQLException, IOException {
//		TotalAmounts in = new TotalAmounts();
//		ArrayList<Inflow> newInflow = new ArrayList<>();
//		newInflow.add(new Inflow(new Date(2019, 2, 18), 100));
//		in.setInflow(newInflow);
//		assertEquals(100, in.getTotalInflow());
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test 
//	void testSetOutflow() throws SQLException, IOException {
//		TotalAmounts out = new TotalAmounts();
//		ArrayList<Outflow> newOutflow = new ArrayList<>();
//		newOutflow.add(new Outflow(new Date(2019, 2, 18), 100));
//		out.setOutflow(newOutflow);
//		assertEquals(100, out.getTotalOutflow());
//	}
//
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
//
//=======
//>>>>>>> branch 'master' of https://github.com/sjshilts/cookie_project.git
//}
