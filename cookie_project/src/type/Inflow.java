package type;
import java.util.*;
import java.sql.Date;

public class Inflow {
	
	private Date date;
	private double amount;
	
	/**
	 * 
	 * Constructor for the Inflow
	 * @param dataEntry, amountEntry
	 */
	public Inflow(Date dateEntry, double amountEntry ) {
		date = dateEntry;
		amount = amountEntry;
	}
	
	/**
	 * 
	 * Calls dataEntry and sets values for setDate
	 * @param dataEntry
	 */
	public void setDate( Date dateEntry ) {
		date = dateEntry;
	}
	
	/**
	 * 
	 * Calls amountEntry and sets values for setAmount
	 * @param amountEntry
	 */
	public void setAmount( double amountEntry ) {
		amount = amountEntry;
	}
	
	/**
	 * 
	 * Retrieves an amount
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 
	 * Retrieves a date
	 */
	public double getAmount() {
		return amount;
	}

}
