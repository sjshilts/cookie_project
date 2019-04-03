package backend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class dummyData {
	@SuppressWarnings("deprecation")
	public static void main(String [] args) throws SQLException {
		
		//Initializing lists
		ArrayList<Integer> Accnum = new ArrayList<>();  
		Accnum.add( 3 );
		
		ArrayList<String> type_outflow = new ArrayList<>();
		type_outflow.add("electric");
		type_outflow.add("housing");
		type_outflow.add("water");
		type_outflow.add("gas");
		type_outflow.add("internet");
		type_outflow.add("luxury");
		type_outflow.add("groceries");
		type_outflow.add("transportation");
		type_outflow.add("401k");
		type_outflow.add("savings");
		
		ArrayList<String> type_inflow = new ArrayList<>();
		type_inflow.add("paycheck");
		type_inflow.add("unearned");
		type_inflow.add("other income");
		
		
		ArrayList<Date> date = new ArrayList<>();
		date.add(new Date(2019, 2, 1));
		date.add(new Date(2019, 3, 19));
		date.add(new Date(2019, 6, 2));
		date.add(new Date(2019, 7, 12));


		ArrayList<Double> amount_out = new ArrayList<>();
		amount_out.add(25.36);
		amount_out.add(10.17);
		amount_out.add(69.69);
		amount_out.add(4.20);
		amount_out.add(18.79);
		amount_out.add(50.18);
		
		ArrayList<Double> amount_in = new ArrayList<>();
		amount_in.add(200.12);
		amount_in.add(507.25);
		amount_in.add(50.63);
		amount_in.add(210.12);
	
		
		
		ArrayList<String> who = new ArrayList<>();
		who.add("Walmart");
		
		
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
		
		ps = conn.prepareStatement(stmt);
		
		//setting up, for loops go here
		
		for ( int j = 0; j < Accnum.size(); j++ ) {
			for ( int k = 0; k < type_outflow.size(); k++ ) {
				for ( int l = 0; l < date.size(); l++ ) {
					for ( int m = 0; m < amount_out.size(); m++ ) {
						for ( int n = 0; n < who.size(); n++ ) {
							ps.setInt( 1, Accnum.get( j ) );
							ps.setString( 2, type_outflow.get( k ) );
							ps.setDate( 3, date.get( l ) );
							ps.setDouble( 4, amount_out.get( m ) );
							ps.setString( 5, who.get( n ) );
							ps.executeUpdate();
						}
					}
				}
			}
			
			for ( int o = 0; o < Accnum.size(); o++ ) {
				for ( int p = 0; p < type_inflow.size(); p++ ) {
					for ( int q = 0; q < date.size(); q++ ) {
						for ( int r = 0; r < amount_in.size(); r++ ) {
							for ( int s = 0; s < who.size(); s++ ) {
								ps.setInt( 1, Accnum.get( o ) );
								ps.setString( 2, type_inflow.get( p ) );
								ps.setDate( 3, date.get( q ) );
								ps.setDouble( 4, amount_in.get( r ) );
								ps.setString( 5, who.get( s ) );
								ps.executeUpdate();
							}
						}
					}
				}
			}
		}
	}

}
