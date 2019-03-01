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
		rs.close();
		return data;
		
	}
	
	private ArrayList<CostOfLiving> getCostOfLiving() throws SQLException {
		return null;
	}

	private ArrayList<Saving> getSaving() throws SQLException {
		return null;
	}
	
	private ArrayList<Luxery> getLuxery() throws SQLException {
		return null;
	}
	
	private ArrayList<Paycheck> getPaycheck() {
		return null;
	}
	
	private ArrayList<OtherIncome> getOtherIncome() {
		return null;
	}
	
	private ArrayList<UnearnedIncome> getUnearnedIncome() {
		return null;
	}
}
