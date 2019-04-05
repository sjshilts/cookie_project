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
	
	private Connection getConnection() {
		return conn;
	}
	
	public void closeConn() throws SQLException {
		conn.close();
	}
	
	//gets all the outflow
	public ArrayList<Outflow> getOutflow() throws SQLException, IOException {
		ArrayList<Outflow> oflow = new ArrayList<>();
		Connection connection = null;
		connection = getConnection();
		PreparedStatement ps;
		String stmt = "SELECT * FROM Transaction WHERE Accnum = ?";
		ps = connection.prepareStatement( stmt );
		ps.setInt( 1, getAccNum() );
		ResultSet rs = ps.executeQuery();
		while ( rs.next( ) ) {
			String type = rs.getString( "type" );
			switch( type ) {
			case "electric":
				Electric e = new Electric( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( e );
				break;
			case "water":
				Water w = new Water( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( w );
				break;
			case "gas":
				Gas h = new Gas( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( h );
				break;
			case "housing":
				Housing ho = new Housing( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( ho );
				break;
			case "internet":
				Internet i = new Internet( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
				oflow.add( i );
				break;
			case "transportation":
				Transportation g = new Transportation( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( g );
				break;
			case "groceries":
				Groceries gr = new Groceries( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( gr );
				break;
			case "savings":
				OtherSavings s = new OtherSavings( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( s );
				break;
			case "401k":
				Four01K f = new Four01K( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( f );
				break;
			case "luxuries":
				Luxury l = new Luxury( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				oflow.add( l );
				break;
			}
		}
		return oflow;
	}
	
	//gets all of the inflow
	public ArrayList<Inflow> getInflow() throws SQLException, IOException {
		ArrayList<Inflow> iflow = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement ps;
		String stmt = "SELECT * FROM Transaction WHERE Accnum = ?";
		ps = connection.prepareStatement( stmt );
		ps.setInt( 1, getAccNum( ));
		ResultSet rs = ps.executeQuery();
		while( rs.next( ) ) {
			String type = rs.getString( "type" );
			switch( type ) {
			case "paycheck":
				Paycheck p = new Paycheck( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				iflow.add( p );
				break;
			case "unearned income":
				UnearnedIncome u = new UnearnedIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				iflow.add( u );
				break;
			case "other income":
				OtherIncome i = new OtherIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				iflow.add( i );
				break;
			}
		}
		return iflow;
	}
	
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
