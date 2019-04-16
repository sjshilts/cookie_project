package type;
import java.sql.Date;

public class CostOfLiving extends Outflow{

	/**
	 * 
	 * Constructor for the CostOfLiving
	 * @param dataEntry, amountEntry
	 */
	public CostOfLiving( Date dateEntry, double amountEntry){
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
