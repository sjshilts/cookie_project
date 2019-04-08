package backend;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import type.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetData {
	
	private Connection conn = null;
	
	/**
	 * Initializes the connection to the database
	 * @param user
	 * @param password
	 */
	public GetData( String user, String password ) {
		dbConnect dbC = new dbConnect();
		if ( conn == null ) {
			try {
				conn = dbC.connect( user, password );
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * finds connection
	 * @return conn: connection to the database
	 */
	private Connection getConnection() {
		return conn;
	}
	
	/**
	 * closes connection
	 * @throws SQLException
	 */
	public void closeConn() throws SQLException {
		conn.close();
	}
	
	/**
	 * 
	 * This method finds all the types that count as outflow
	 * and adds them to an ArrayList<Outflow>
	 * @return oflow: each entry in the database for the specific user that counts as outflow
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<Outflow> getOutflow() throws SQLException, IOException {
		ArrayList<Outflow> oflow = new ArrayList<>();
		Connection connection = null;
		connection = getConnection();
		PreparedStatement ps;
		
		// We find all transactions from the specific user
		String stmt = "SELECT * FROM Transaction WHERE Accnum = ?";
		ps = connection.prepareStatement( stmt );
		ps.setInt( 1, getAccNum() );
		
		// Put the results of the query into a set
		ResultSet rs = ps.executeQuery();
		while ( rs.next( ) ) {
			String type = rs.getString( "type" );
			switch( type ) {
			
			// If type is "electric" add it to the AL
			case "electric":
				Electric e = new Electric( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( e );
				break;
				
			// If type is "water" add it to the AL
			case "water":
				Water w = new Water( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( w );
				break;
			
			// If type is "gas" add it to the AL
			case "gas":
				Gas h = new Gas( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( h );
				break;
				
			// If type is "housing" add it to the AL
			case "housing":
				Housing ho = new Housing( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( ho );
				break;
				
			// If type is "internet" add it to the AL
			case "internet":
				Internet i = new Internet( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( i );
				break;
				
			// If type is "transportation" add it to the AL
			case "transportation":
				Transportation g = new Transportation( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( g );
				break;
				
			// If type is "groceries" add it to the AL
			case "groceries":
				Groceries gr = new Groceries( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( gr );
				break;
				
			// If type is "savings" add it to the AL
			case "savings":
				OtherSavings s = new OtherSavings( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( s );
				break;
				
			// If type is "401k" add it to the AL
			case "401k":
				Four01K f = new Four01K( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( f );
				break;
				
			// If type is "luxuries" add it to the AL
			case "luxuries":
				Luxury l = new Luxury( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( l );
				break;
			}
		}
		return oflow;
	}
	
	/**
	 * 
	 * This method finds all the types that count as inflow
	 * and adds them to an ArrayList<Inflow>
	 * @return iflow: each entry in the database for the specific user that counts as inflow
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<Inflow> getInflow() throws SQLException, IOException {
		ArrayList<Inflow> iflow = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement ps;
		
		// We want to select everything in transaction for specific user
		String stmt = "SELECT * FROM Transaction WHERE Accnum = ?";
		ps = connection.prepareStatement( stmt );
		ps.setInt( 1, getAccNum() );
		
		// Place the results of the query into a set
		ResultSet rs = ps.executeQuery();
		while( rs.next( ) ) {
			String type = rs.getString( "type" );
			switch( type ) {
			
			// Finds the type "paycheck" and adds it to the AL
			case "paycheck":
				Paycheck p = new Paycheck( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				iflow.add( p );
				break;
				
			// Finds the type "unearned income" and adds it to the AL
			case "unearned income":
				UnearnedIncome u = new UnearnedIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				iflow.add( u );
				break;
			
			// Finds the type "other income" and adds it to the AL
			case "other income":
				OtherIncome i = new OtherIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				iflow.add( i );
				break;
			}
		}
		return iflow;
	}
	
	/**
	 * 
	 * This method returns the initial balance of the user
	 * that was specified at the beginning of the creation of the user
	 * @return balance: the specified initial balance of the user
	 * @throws SQLException
	 * @throws IOException
	 */
	public Float getInitBalance() throws SQLException, IOException {
		Connection connection = null;
		Float balance = null;
		if ( connection == null ) {
			connection = getConnection();
			PreparedStatement ps;
			String stmt = "SELECT InitBalance FROM Users WHERE Accnum = ?";
			ps = connection.prepareStatement( stmt );
			ps.setInt( 1, getAccNum( ));
			ResultSet rs = ps.executeQuery();
			rs.next();
			balance = rs.getFloat( "InitBalance" );
		}
		return balance;
	}
	

	
	/**
	 * 
	 * This method finds the user's account number listed in the database
	 * in a file made on the user's computer.
	 * @return accNum: the account number of the user in the database
	 * @throws IOException
	 */
	private static int getAccNum() throws IOException {
		
		File file = new File("src/userInterface/AccountNumber.txt");
		FileReader fileReader = new FileReader(file);
		StringBuffer stringBuffer = new StringBuffer();
		int numCharsRead;
		char[] charArray = new char[1024];
		while ((numCharsRead = fileReader.read(charArray)) > 0) {
			stringBuffer.append(charArray, 0, numCharsRead);
		}
		fileReader.close();
		return Integer.parseInt(stringBuffer.toString());

}
}
