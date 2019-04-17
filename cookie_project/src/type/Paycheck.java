package type;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.Date;

public class Paycheck extends Inflow{
	
	/**
	 * 
	 * Initializing variables
	 */
	private double socSecDeduct;
	private double medicareDeduct;
	private double stateInTax;
	private double fedInTax;
	
	/**
	 * 
	 * Constructor for the Paycheck
	 * @param dataEntry, amountEntry
	 */
	public Paycheck( Date date, double amountEntry ) {
		super(date, amountEntry);
	}
	
	/**
	 * 
	 * Constructor for the Paycheck
	 * @param dataEntry, amountEntry, sosSecDeductEntry, medicareDeductEntry, stateInTaxEntry
	 */
	public Paycheck( Date dateEntry, double amountEntry, double socSecDeductEntry, double medicareDeductEntry, double stateInTaxEntry ) {
		super(dateEntry, amountEntry);
		socSecDeduct = socSecDeductEntry;
		medicareDeduct = medicareDeductEntry;
		stateInTax = stateInTaxEntry;
		
	}
	
	/**
	 * 
	 * Calls amountEntry and sets values for setAmount
	 * @param amountEntry
	 */
	public void setAmount( double amountEntry ) {
		super.setAmount(amountEntry);
	}
	
	/**
	 * 
	 * Calls setSocialSecurityDeduction and sets values for socSecDeduct
	 * @param socSecDeductEntry
	 */
	public void setSocialSecurityDeduction( double socSecDeductEntry ) {
		socSecDeduct = socSecDeductEntry;
	}
	
	/**
	 * 
	 * Calls setMedicareDeduction and sets values for medicareDeduct
	 * @param medicareDeductEntry
	 */
	public void setMedicareDeduction( double medicareDeductEntry ) {
		medicareDeduct = medicareDeductEntry;
	}
	
	/**
	 * 
	 * Calls setStateIncomeTax and sets values for stateInTax
	 * @param stateInTaxEntry
	 */
	public void setStateIncomeTax( double stateInTaxEntry ) {
		stateInTax = stateInTaxEntry;
	}
	
	/**
	 * 
	 * Calls setFederalIncomeTax and sets values for fedInTax
	 * @param fedInTaxEntry
	 */
	public void setFederalIncomeTax( double fedInTaxEntry ) {
		fedInTax = fedInTaxEntry;
	}
	
	/**
	 * 
	 * Retrieves an amount
	 */
	public double getAmount() {
		return super.getAmount();
	}
	
	/**
	 * 
	 * Retrieves socSecDeduct
	 */
	public double getSocialSecurityDeduction() {
		return socSecDeduct;
	}
	
	/**
	 * 
	 * Retrieves medicareDeduct
	 */
	public double getMedicareDeduction() {
		return medicareDeduct;
	}
	
	/**
	 * 
	 * Retrieves stateInTax
	 */
	public double getStateIncomeTax() {
		return stateInTax;
	}
	
	/**
	 * 
	 * Retrieves fedInTax
	 */
	public double getFederalIncomeTax() {
		return fedInTax;
	}
	
//	public boolean upload( String user, String password ) {
//		dbConnect conn = new dbConnect();
//		PreparedStatement smnt = null;
//		String test1 = "INSERT INTO jmperttu.accountNAME (date, amount, type, whom, balance, subtype) VALUES (?,?,?,?,?,?)";
//		try {
//			Connection c = conn.connect( user, password );
//			smnt = c.prepareStatement( test1 );
//			smnt.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
}
