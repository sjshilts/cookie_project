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
		conn.close();
		return null;
	}
	
	public ArrayList<Inflow> getInflow() {
		return null;
	}
	
	private ArrayList<Bill> getBill() throws SQLException {
		String billsID = "SELECT * FROM Bills WHERE Bills.id = id;";
		PreparedStatement stmnt = conn.prepareStatement( billsID );
		ResultSet rs = stmnt.executeQuery();
		return null;
		
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
