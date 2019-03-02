package userInterface;

public class Type {
		
	private	String date;
	private	Double amount;
	private	String type;
	
	public Type( String dateEntry, Double amountEntry, String typeEntry) {
		date = dateEntry;
		amount = amountEntry;
		type = typeEntry;
	}
	
	public String getDate() {
		return date;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setDate(String dateEntry) {
		date = dateEntry;
	}
	
	public void setAmount( Double amountEntry ) {
		amount = amountEntry;
	}
	
	public void setType( String typeEntry ) {
		type = typeEntry;
	}
}
