package type;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.Date;

public class Paycheck extends Inflow{
	
	private double socSecDeduct;
	private double medicareDeduct;
	private double stateInTax;
	private double fedInTax;
	
	public Paycheck( Date dateEntry, double amountEntry ) {
		super(dateEntry, amountEntry);
	}
	public Paycheck( Date dateEntry, double amountEntry, double socSecDeductEntry, double medicareDeductEntry, double stateInTaxEntry ) {
		super(dateEntry, amountEntry);
		socSecDeduct = socSecDeductEntry;
		medicareDeduct = medicareDeductEntry;
		stateInTax = stateInTaxEntry;
		
	}
	
	public void setAmount( double amountEntry ) {
		super.setAmount(amountEntry);
	}
	
	public void setSocialSecurityDeduction( double socSecDeductEntry ) {
		socSecDeduct = socSecDeductEntry;
	}
	
	public void setMedicareDeduction( double medicareDeductEntry ) {
		medicareDeduct = medicareDeductEntry;
	}
	
	public void setStateIncomeTax( double stateInTaxEntry ) {
		stateInTax = stateInTaxEntry;
	}
	
	public void setFederalIncomeTax( double fedInTaxEntry ) {
		fedInTax = fedInTaxEntry;
	}
	
	public double getAmount() {
		return super.getAmount();
	}
	
	public double getSocialSecurityDeduction() {
		return socSecDeduct;
	}
	
	public double getMedicareDeduction() {
		return medicareDeduct;
	}
	
	public double getStateIncomeTax() {
		return stateInTax;
	}
	
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
