package userInterface;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class Type {
		
	private	LocalDate date;
	private	String amount;
	private	String type;
	
	public Type( LocalDate dateEntry, String amountEntry, String typeEntry) {
		date = dateEntry;
		amount = amountEntry;
		type = typeEntry;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setDate(LocalDate dateEntry) {
		date = dateEntry;
	}
	
	public void setAmount( String amountEntry ) {
		amount = amountEntry;
	}
	
	public void setType( String typeEntry ) {
		type = typeEntry;
	}
}
