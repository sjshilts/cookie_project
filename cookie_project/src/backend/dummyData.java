package backend;

import java.sql.Date;
import java.util.ArrayList;

public class dummyData {
	public static void main(String [] args) {
		
		//Initializing lists
		ArrayList<Integer> Accnum = new ArrayList<>();  
		Accnum.add( 1 );
		Accnum.add( 2 );
		Accnum.add( 3 );
		Accnum.add( 4 );
		
		ArrayList<String> type = new ArrayList<>();
		//Inflows
		type.add("paycheck");
		type.add("unearned");
		type.add("other income");
		
		//Outflows
		type.add("electric");
		type.add("housing");
		type.add("water");
		type.add("gas");
		type.add("internet");
		type.add("luxury");
		type.add("groceries");
		type.add("transportation");
		type.add("401k");
		type.add("savings");
		
		
		ArrayList<Date> date = new ArrayList<>();
		
		ArrayList<Integer> amount = new ArrayList<>();
		
		ArrayList<String> who = new ArrayList<>();
		who.add("Lowes");
		who.add("Your mom");
		who.add("Tim Hortons");
		who.add("City of Portage");
		who.add("Kroger");
		who.add("Kohler");
		who.add("Steam");
		who.add("Cafe");
		who.add("Walmart");
		who.add("Gucci");
		
		
		int memes = 1 ;
		if ( memes == 1 ) {  // database connection
		}
		
	}

}
