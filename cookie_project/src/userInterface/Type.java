package userInterface;
// A type that is for the data displayed in the table in newEntry
import java.time.LocalDate;

public class Type {
		
	private	LocalDate date;
	private	Float amount;
	private	String type;
	private String who;
	
	public Type( LocalDate dateEntry, Float amountEntry, String typeEntry, String whoEntry) {
		date = dateEntry;
		amount = amountEntry;
		type = typeEntry;
		who = whoEntry;
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
	
	public String getWho() {
		return who;
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
	
	public void setWho(String whoEntry) {
		who = whoEntry;
	}
}
