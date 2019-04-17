package userInterface;
// A type for the data that is displayed in the tables
public class Table {

	private String type;
	private String amount;
	private String percent;
	
	public Table(String typeEntry, String amountEntry, String percentEntry) {
		type = typeEntry;
		amount = amountEntry;
		percent = percentEntry;
	}
	
	public void setType( String typeEntry) {
		type = typeEntry;
	}
	
	public void setAmount( String amountEntry ) {
		amount = amountEntry;
	}
	
	public void setPercent( String percentEntry ) {
		percent = percentEntry;
	}
	
	public String getType() {
		return type;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public String getPercent() {
		return percent;
	}
} 
