	package backend;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import type.*;

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
	public ArrayList<Outflow> getOutflow() throws SQLException {
		ArrayList<Outflow> oflow = new ArrayList<>();
		ArrayList<Bill> billOut = getBill();
		ArrayList<CostOfLiving> coF = getCostOfLiving();
		ArrayList<Saving> sav = getSaving();
		ArrayList<Luxury> lux = getLuxury();
		
		for ( int i = 0; i < billOut.size(); i++ ) {
			oflow.add( billOut.get( i ) );
		}
		for ( int i = 0; i < coF.size(); i++ ) {
			oflow.add( coF.get( i ) );
		}
		for ( int i = 0; i < sav.size(); i++ ) {
			oflow.add( sav.get( i ) );
		}
		for ( int i = 0; i < lux.size(); i++ ) {
			oflow.add( lux.get( i ) );
		}
		
		return oflow;
	}
	
	//gets all of the inflow
	public ArrayList<Inflow> getInflow() throws SQLException {
		ArrayList<Inflow> iflow = new ArrayList<>();
		ArrayList<Paycheck> pay = getPaycheck();
		ArrayList<OtherIncome> oinc = getOtherIncome();
		ArrayList<UnearnedIncome> uninc = getUnearnedIncome();
		
		for ( int i = 0; i < pay.size(); i++ ) {
			iflow.add( pay.get( i ) );
		}
		for ( int i = 0; i < oinc.size(); i++ ) {
			iflow.add( oinc.get( i ) );
		}
		for ( int i = 0; i < uninc.size(); i++ ) {
			iflow.add( uninc.get( i ) );
		}
		
		return iflow;
	}
	
	//gets the data from the Bills table
	private ArrayList<Bill> getBill() throws SQLException {
		Connection connection = null;
		if ( connection == null ) {
			connection = getConnection();
			ArrayList<Bill> data = new ArrayList<>();
			PreparedStatement ps;
			String stmt = "SELECT * FROM Bills";
			ps = connection.prepareStatement( stmt );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				String type = rs.getString( "subtype" );
				switch( type ) {
				case "electric":
					Electric e = new Electric( rs.getDate( "date" ), rs.getDouble( "amount" ) );
					data.add( e );
					break;
				case "water":
					Water w = new Water( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
					data.add( w );
					break;
				case "heat":
					Heat h = new Heat( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
					data.add( h );
					break;
				case "housing":
					Housing ho = new Housing( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
					data.add( ho );
					break;
				case "internet":
					Internet i = new Internet( rs.getDate( "Date" ), rs.getDouble( "amount" ) );
					data.add( i );
					break;
				}
			}
			ps.close();
			rs.close();
			return data;
		}
		return null;
	}
	
	//gets all of the cost of living
	private ArrayList<CostOfLiving> getCostOfLiving() throws SQLException {
		Connection connection = null;
		if ( connection == null ) {
			ArrayList<CostOfLiving> coL = new ArrayList<>();
			connection = getConnection();
			PreparedStatement ps;
			String stmt = "SELECT * FROM Cost_Of_Living";
			ps = connection.prepareStatement( stmt );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				String type = rs.getString( "subtype" );
				switch ( type ) {
				case "gas":
					Gas g = new Gas( rs.getDate( "date" ), rs.getDouble( "amount" ) );
					coL.add( g );
					break;
				case "groceries":
					Groceries gr = new Groceries( rs.getDate( "date" ), rs.getDouble( "amount" ) );
					coL.add( gr );
					break;
				}
			}
			ps.close();
			rs.close();
			return coL;
		}
		return null;
	}

	//gets all Savings
	private ArrayList<Saving> getSaving() throws SQLException {
		Connection connection = null;
		if ( connection == null ) {
			ArrayList<Saving> sav = new ArrayList<>();
			connection = getConnection();
			PreparedStatement ps;
			String stmt = "SELECT * FROM Savings";
			ps = connection.prepareStatement( stmt );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				String type = rs.getString( "subtype" );
				switch ( type ) {
				case "savings":
					OtherSavings s = new OtherSavings( rs.getDate( "date" ), rs.getDouble( "amount" ) );
					sav.add( s );
					break;
				case "401k":
					Four01K f = new Four01K( rs.getDate( "date" ), rs.getDouble( "amount" ) );
					sav.add( f );
					break;
				}
			}
			ps.close();
			rs.close();
			return sav;
		}
		return null;
	}
	
	//yadda
	private ArrayList<Luxury> getLuxury() throws SQLException {
		Connection connection = null;
		if ( connection == null ) {
			ArrayList<Luxury> lux = new ArrayList<>();
			connection = getConnection();
			PreparedStatement ps;
			String stmt = "SELECT * FROM Luxuries";
			ps = connection.prepareStatement( stmt );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Luxury l = new Luxury( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				lux.add( l );
			}
			ps.close();
			rs.close();
			return lux;
		}
		return null;
	}
	
	//yadda
	private ArrayList<Paycheck> getPaycheck() throws SQLException {
		Connection connection = null;
		if ( connection == null ) {
			ArrayList<Paycheck> pay = new ArrayList<>();
			connection = getConnection();
			PreparedStatement ps;
			String stmt = "SELECT * FROM Paycheck";
			ps = connection.prepareStatement( stmt );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Paycheck p = new Paycheck( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				pay.add( p );
			}
			ps.close();
			rs.close();
			return pay;
		}
		return null;
	}
	
	//yadda
	private ArrayList<OtherIncome> getOtherIncome() throws SQLException {
		Connection connection = null;
		if ( connection == null ) {
			ArrayList<OtherIncome> inc = new ArrayList<>();
			connection = getConnection();
			PreparedStatement ps;
			String stmt = "SELECT * FROM Other";
			ps = connection.prepareStatement( stmt );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				OtherIncome i = new OtherIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				inc.add( i );
			}
			ps.close();
			rs.close();
			return inc;
		}
		return null;
	}
	
	//yadda
	private ArrayList<UnearnedIncome> getUnearnedIncome() throws SQLException {
		Connection connection = null;
		if ( connection == null ) {
			ArrayList<UnearnedIncome> un = new ArrayList<>();
			connection = getConnection();
			PreparedStatement ps;
			String stmt = "SELECT * FROM Unearned_Income";
			ps = connection.prepareStatement( stmt );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				UnearnedIncome u = new UnearnedIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
				un.add( u );
			}
			ps.close();
			rs.close();
			return un;
		}
		return null;
	}
}
