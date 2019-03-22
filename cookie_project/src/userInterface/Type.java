package userInterface;

import java.time.LocalDate;

public class Type {
		
	private	LocalDate date;
	private	Float amount;
	private	String type;
	
	public Type( LocalDate dateEntry, Float amountEntry, String typeEntry) {
		date = dateEntry;
		amount = amountEntry;
		type = typeEntry;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public Float getAmount() {
		return amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setDate(LocalDate dateEntry) {
		date = dateEntry;
	}
	
	public void setAmount( Float amountEntry ) {
		amount = amountEntry;
	}
	
	public void setType( String typeEntry ) {
		type = typeEntry;
	}
}
