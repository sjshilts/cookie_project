package backend;

import java.util.ArrayList;

import type.*;

public class TotalAmounts {
	
	private double bills = 0;
	private double col = 0;
	private double electric = 0;
	private double four01k = 0;
	private double gas = 0;
	private double groceries = 0;
	private double heat = 0;
	private double housing = 0;
	private double inflow = 0;
	private double internet = 0;
	private double luxery = 0;
	private double otherIncome = 0;
	private double outflow = 0;
	private double paycheck = 0;
	private double savings = 0;
	private double unearnedIncome = 0;
	private double water = 0;

	// calculates all the total amounts from a given ArrayList of data
	public TotalAmounts(ArrayList<Inflow> in, ArrayList<Outflow> out ){
		
		for( int i = 0; i < in.size(); i ++ ) {
			inflow = inflow + in.get(i).getAmount();
			if( in.get(i) instanceof Paycheck ) {
				paycheck = paycheck + in.get(i).getAmount();
			}
			else if( in.get(i) instanceof UnearnedIncome) {
				unearnedIncome = unearnedIncome + in.get(i).getAmount();
			}
			else if ( in.get(i) instanceof OtherIncome) {
				otherIncome = otherIncome + in.get(i).getAmount();
			}
			
		}
		for( int j = 0; j < out.size(); j++ ) {
			outflow = outflow + out.get(j).getAmount();
			if(out.get(j) instanceof Bill ) {
				bills = bills + out.get(j).getAmount();
			}
			else if( out.get(j) instanceof CostOfLiving) {
				col = col + out.get(j).getAmount();
			}
			else if( out.get(j) instanceof Luxery) {
				luxery = luxery + out.get(j).getAmount();
			}
			else if( out.get(j) instanceof Saving) {
				savings = savings + out.get(j).getAmount();
			}
			
		}
	}
	
	public double getTotalBills() {
		return bills;
	}
	
	public double getTotalCostOfLiving() {
		return col;
	}
	
	public double getTotalLuxery() {
		return luxery;
	}
	
	public double getTotalSavings() {
		return savings;
	}
	
	
	
}
