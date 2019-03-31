package backend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		//date.add("2019-02-01".toDate());

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
		
		
		dbConnect dbC = new dbConnect( );
		Connection conn = null;
		try {
			conn = dbC.connect( "jkdeyonk", "1112235jjb" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //database connection
		PreparedStatement ps;
		String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";
		try {
			ps = conn.prepareStatement(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//setting up, for loops go here
		
		
		
		//inside end of for loops
		//ps.setInt(1, Accnum.get(0));
		//ps.setString(2, Accnum.get(0));
		//ps.setDate(3, Accnum.get(0));
		//ps.setFloat(4, Accnum.get(0));
		//ps.setString(5, Accnum.get(""));
		
		//after all just this one line this one time
		//ps.executeUpdate();
		}

}
