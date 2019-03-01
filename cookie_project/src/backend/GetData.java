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
	
	private Connection conn;
	
	public GetData( String user, String password ) {
		dbConnect dbC = new dbConnect();
		try {
			conn = dbC.connect( user, password );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Outflow> getOutflow() throws SQLException {
		ArrayList<Outflow> oflow = new ArrayList<>();
		ArrayList<Bill> billOut = getBill();
		
		for ( int i = 0; i < billOut.size(); i++ ) {
			oflow.add( billOut.get( i ) );
		}
		
		conn.close();
		return oflow;
	}
	
	public ArrayList<Inflow> getInflow() {
		return null;
	}
	
	private ArrayList<Bill> getBill() throws SQLException {
		ArrayList<Bill> data = new ArrayList<>();
		PreparedStatement ps = null;
		String stmt = "SELECT * FROM Bills";
		ps = conn.prepareStatement( stmt );
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
	
	private ArrayList<CostOfLiving> getCostOfLiving() throws SQLException {
		ArrayList<CostOfLiving> coL = new ArrayList<>();
		PreparedStatement ps = null;
		String stmt = "SELECT * FROM Cost_Of_Living";
		ps = conn.prepareStatement( stmt );
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

	private ArrayList<Saving> getSaving() throws SQLException {
		ArrayList<Saving> sav = new ArrayList<>();
		PreparedStatement ps = null;
		String stmt = "SELECT * FROM Savings";
		ps = conn.prepareStatement( stmt );
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
	
	private ArrayList<Luxury> getLuxury() throws SQLException {
		ArrayList<Luxury> lux = new ArrayList<>();
		PreparedStatement ps = null;
		String stmt = "SELECT * FROM Luxuries";
		ps = conn.prepareStatement( stmt );
		ResultSet rs = ps.executeQuery();
		while( rs.next() ) {
			Luxury l = new Luxury( rs.getDate( "date" ), rs.getDouble( "amount" ) );
			lux.add( l );
		}
		ps.close();
		rs.close();
		return lux;
	}
	
	private ArrayList<Paycheck> getPaycheck() throws SQLException {
		ArrayList<Paycheck> pay = new ArrayList<>();
		PreparedStatement ps = null;
		String stmt = "SELECT * FROM Paycheck";
		ps = conn.prepareStatement( stmt );
		ResultSet rs = ps.executeQuery();
		while( rs.next() ) {
			Paycheck p = new Paycheck( rs.getDate( "date" ), rs.getDouble( "amount" ) );
			pay.add( p );
		}
		ps.close();
		rs.close();
		return pay;
	}
	
	private ArrayList<OtherIncome> getOtherIncome() throws SQLException {
		ArrayList<OtherIncome> inc = new ArrayList<>();
		PreparedStatement ps = null;
		String stmt = "SELECT * FROM Other";
		ps = conn.prepareStatement( stmt );
		ResultSet rs = ps.executeQuery();
		while( rs.next() ) {
			OtherIncome i = new OtherIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
			inc.add( i );
		}
		ps.close();
		rs.close();
		return inc;
	}
	
	private ArrayList<UnearnedIncome> getUnearnedIncome() throws SQLException {
		ArrayList<UnearnedIncome> un = new ArrayList<>();
		PreparedStatement ps = null;
		String stmt = "SELECT * FROM Unearned_Income";
		ps = conn.prepareStatement( stmt );
		ResultSet rs = ps.executeQuery();
		while( rs.next() ) {
			UnearnedIncome u = new UnearnedIncome( rs.getDate( "date" ), rs.getDouble( "amount" ) );
			un.add( u );
		}
		ps.close();
		rs.close();
		return un;
	}
}
