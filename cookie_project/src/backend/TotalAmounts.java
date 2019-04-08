package backend;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import type.*;
/* This class will calculate the totals for each of the types of inflow and outflow.
 * Each instance can only be used on one users data.
 */
public class TotalAmounts {
	
	// each type of inflow and outflow totals
	private double bills = 0;
	private double col = 0;
	private double electric = 0;
	private double four01k = 0;
	private double transportation = 0;
	private double groceries = 0;
	private double gas = 0;
	private double housing = 0;
	private double inflow = 0;
	private double internet = 0;
	private double luxury = 0;
	private double otherIncome = 0;
	private double outflow = 0;
	private double paycheck = 0;
	private double savings = 0;
	private double unearnedIncome = 0;
	private double water = 0;
	private double otherSavings = 0;
	private double initBal = 0;
	
	/*
	 * Constructor with no data inputs initializes all the variables as 0
	 */
	public TotalAmounts( ) throws SQLException, IOException{
		
		GetData db = new GetData("sjshilts","sJSdbPass10");
		initBal = db.getInitBalance();
		
		setInflow(db.getInflow());
		setOutflow(db.getOutflow());
		db.closeConn();
	}
	
	public double getTotal() {
		return inflow - outflow + initBal;
	}
	
	public double getInitBal() {
		return initBal;
	}
	
	public double getTotalInflow() {
		return inflow;
	}
	
	public double getTotalOutflow() {
		return outflow;
	}
	
	public double getTotalBills() {
		return bills;
	}
	
	public double getTotalCostOfLiving() {
		return col;
	}
	
	public double getTotalLuxery() {
		return luxury;
	}
	
	public double getTotalSavings() {
		return savings;
	}
	
	public double getTotalPaychecks() {
		return paycheck;
	}
	
	public double getTotalOtherIncome() {
		return otherIncome;
	}
	
	public double getTotalUnearnedIncome() {
		return unearnedIncome;
	}
	
	public double getTotalElectric() {
		return electric;
	}
	
	public double getTotal401K() {
		return four01k;
	}
	
	public double getTotalTransportation() {
		return transportation;
	}
	
	public double getTotalGroceries() {
		return groceries;
	}
	
	public double getTotalGas() {
		return gas;
	}
	
	public double getTotalHousing() {
		return housing;
	}
	
	public double getTotalInternet() {
		return internet;
	}
	
	public double getTotalOtherSavings() {
		return otherSavings;
	}
	
	public double getTotalWater() {
		return water;
	}
	
	private void setInflow(ArrayList<Inflow> in) {
		for( int i = 0; i < in.size(); i ++ ) {
			inflow = inflow + in.get(i).getAmount();
			if( in.get(i) instanceof Paycheck ) {
				paycheck = paycheck + in.get(i).getAmount();
			}
			if( in.get(i) instanceof UnearnedIncome) {
				unearnedIncome = unearnedIncome + in.get(i).getAmount();
			}
			if ( in.get(i) instanceof OtherIncome) {
				otherIncome = otherIncome + in.get(i).getAmount();
			}
		}
	}
	
	private void setOutflow(ArrayList<Outflow> out) {
		for( int j = 0; j < out.size(); j++ ) {
			outflow = outflow + out.get(j).getAmount();
			if(out.get(j) instanceof Bill ) {
				bills = bills + out.get(j).getAmount();
			}
			if( out.get(j) instanceof CostOfLiving) {
				col = col + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Luxury) {
				luxury = luxury + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Saving) {
				savings = savings + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Electric) {
				electric = electric + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Four01K) {
				four01k = four01k + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Transportation) {
				transportation = transportation + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Groceries) {
				groceries = groceries + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Gas) {
				gas = gas + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Housing) {
				housing = housing + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Internet) {
				internet = internet + out.get(j).getAmount();
			}
			if( out.get(j) instanceof OtherSavings) {
				otherSavings = otherSavings + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Water) {
				water = water + out.get(j).getAmount();
			}
		}
	}
	
//	public void addInflow(ArrayList<Inflow> in) {
//		for( int i = 0; i < in.size(); i ++ ) {
//			inflow = inflow + in.get(i).getAmount();
//			if( in.get(i) instanceof Paycheck ) {
//				paycheck = paycheck + in.get(i).getAmount();
//			}
//			if( in.get(i) instanceof UnearnedIncome) {
//				unearnedIncome = unearnedIncome + in.get(i).getAmount();
//			}
//			if ( in.get(i) instanceof OtherIncome) {
//				otherIncome = otherIncome + in.get(i).getAmount();
//			}
//		}
//	}
//	
//	public void addOutflow(ArrayList<Outflow> out) {
//		for( int j = 0; j < out.size(); j++ ) {
//			outflow = outflow + out.get(j).getAmount();
//			if(out.get(j) instanceof Bill ) {
//				bills = bills + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof CostOfLiving) {
//				col = col + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Luxury) {
//				luxury = luxury + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Saving) {
//				savings = savings + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Electric) {
//				electric = electric + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Four01K) {
//				four01k = four01k + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Transportation) {
//				transportation = transportation + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Groceries) {
//				groceries = groceries + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Gas) {
//				gas = gas + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Housing) {
//				housing = housing + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Internet) {
//				internet = internet + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof OtherSavings) {
//				otherSavings = otherSavings + out.get(j).getAmount();
//			}
//			if( out.get(j) instanceof Water) {
//				water = water + out.get(j).getAmount();
//			}
//		}
//	}
	
//	private int getAccnum() throws IOException {
//		File file = new File("src/userInterface/AccountNumber.txt");
//		FileReader fileReader = new FileReader(file);
//		StringBuffer stringBuffer = new StringBuffer();
//		int numCharsRead;
//		char[] charArray = new char[1024];
//		while ((numCharsRead = fileReader.read(charArray)) > 0) {
//			stringBuffer.append(charArray, 0, numCharsRead);
//		}
//		fileReader.close();
//		return Integer.parseInt(stringBuffer.toString());
//	}
}
