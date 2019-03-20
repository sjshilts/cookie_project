package backend;

import java.util.ArrayList;

import type.*;
/* This class will calculate the totals for each of the types of inflow and outflow.
 * Each instance can only be used on one users data.
 */
public class TotalAmounts {
	
	// each type of inflow and outflow totals
	private double bills;
	private double col;
	private double electric;
	private double four01k;
	private double gas;
	private double groceries;
	private double heat;
	private double housing;
	private double inflow;
	private double internet;
	private double luxury;
	private double otherIncome;
	private double outflow;
	private double paycheck;
	private double savings;
	private double unearnedIncome;
	private double water;
	private double otherSavings;

/*
 * Constructor that will calculate the totals.
 */
	public TotalAmounts( ArrayList<Inflow> in, ArrayList<Outflow> out ){
		setInflow(in);
		setOutflow(out);
	}
	
	/*
	 * Constructor with no data inputs initializes all the variables as 0
	 */
	public TotalAmounts( ){
		resetData();
	}
	
	public double getTotal() {
		return inflow - outflow;
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
	
	public double getTotalGas() {
		return gas;
	}
	
	public double getTotalGroceries() {
		return groceries;
	}
	
	public double getTotalHeat() {
		return heat;
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
	
	public void resetData() {
		bills = 0;
		col = 0;
		electric = 0;
		four01k = 0;
		gas = 0;
		groceries = 0;
		heat = 0;
		housing = 0;
		inflow = 0;
		internet = 0;
		luxury = 0;
		otherIncome = 0;
		outflow = 0;
		paycheck = 0;
		savings = 0;
		unearnedIncome = 0;
		water = 0;
		otherSavings = 0;
	}
	
	public void resetInflow() {
		inflow = 0;
		otherIncome = 0;
		unearnedIncome = 0;
	}
	
	public void resetOutflow() {
		bills = 0;
		col = 0;
		electric = 0;
		four01k = 0;
		gas = 0;
		groceries = 0;
		heat = 0;
		housing = 0;
		internet = 0;
		luxury = 0;
		outflow = 0;
		paycheck = 0;
		savings = 0;
		water = 0;
		otherSavings = 0;
	}
	
	public void setInflow(ArrayList<Inflow> in) {
		resetInflow();
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
	
	public void setOutflow(ArrayList<Outflow> out) {
		resetOutflow();
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
			if( out.get(j) instanceof Gas) {
				gas = gas + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Groceries) {
				groceries = groceries + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Heat) {
				heat = heat + out.get(j).getAmount();
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
	
	public void addInflow(ArrayList<Inflow> in) {
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
	
	public void addOutflow(ArrayList<Outflow> out) {
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
			if( out.get(j) instanceof Gas) {
				gas = gas + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Groceries) {
				groceries = groceries + out.get(j).getAmount();
			}
			if( out.get(j) instanceof Heat) {
				heat = heat + out.get(j).getAmount();
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

}
