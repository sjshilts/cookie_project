package backend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class dummyData {
	@SuppressWarnings("deprecation")
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
		date.add(new Date(2019, 2, 1));
		date.add(new Date(2019, 2, 21));
		date.add(new Date(2019, 3, 5));
		date.add(new Date(2019, 3, 19));
		date.add(new Date(2019, 6, 2));
		date.add(new Date(2019, 7, 12));
		date.add(new Date(2019, 8, 6));
		date.add(new Date(2019, 9, 10));
		date.add(new Date(2019, 11, 19));
		date.add(new Date(2019, 12, 25));

		ArrayList<Integer> amount = new ArrayList<>();
		amount.add(400);
		amount.add(20);
		amount.add(650);
		amount.add(210);
		amount.add(100);
		amount.add(40);
		
		
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
		}  
		//database connection
		PreparedStatement ps;
		String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";
		try {
			ps = conn.prepareStatement(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//setting up, for loops go here
		
		for ( int i = 1; i <= 10; i++ ) {
			for ( int j = 0; j <= Accnum.size() - 1; j++ ) {
				
				
				//ps.setInt(1, Accnum.get(0));
			}
			
			for ( int k = 0; k <= type.size() - 1; k++ ) {
			
				//ps.setString(2, Accnum.get(0));
			}
			
			for ( int l = 0; l <= date.size() - 1; l++ ) {
			
				//ps.setDate(3, Accnum.get(0));
			}
			
			for ( int m = 0; m <= amount.size() - 1; m++ ) {
	
				//ps.setFloat(4, Accnum.get(0))
			}
			
			for ( int n = 0; n <= who.size() - 1; n++ ) {
				
				//ps.setString(5, Accnum.get(""));
			}
			
		}
	
		
		//ps.executeUpdate();
		}

}
