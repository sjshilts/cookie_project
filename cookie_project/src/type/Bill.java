package type;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Bill extends Outflow{

	/**
	 * 
	 * Constructor for the Bill
	 * @param dataEntry, amountEntry
	 */
	public Bill ( Date dateEntry, double amountEntry){
		super( dateEntry, amountEntry );
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
	 * Calls dataEntry and sets values for setDate
	 * @param dataEntry
	 */
	public void setDate( Date dateEntry ) {
		super.setDate(dateEntry);
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
	 * Retrieves a date
	 */
	public Date getDate() {
		return super.getDate();
	}
	
	
}
