package userInterface;

public class Table {

	private String type;
	private double amount;
	private int percent;
	
	public Table(String typeEntry, double amountEntry, int percentEntry) {
		type = typeEntry;
		amount = amountEntry;
		percent = percentEntry;
	}
	
	public void setType( String typeEntry) {
		type = typeEntry;
	}
	
	public void setAmount( double amountEntry ) {
		amount = amountEntry;
	}
	
	public void setPercent( int percentEntry ) {
		percent = percentEntry;
	}
	
	public String getType() {
		return type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public int getPercent() {
		return percent;
	}
} 
