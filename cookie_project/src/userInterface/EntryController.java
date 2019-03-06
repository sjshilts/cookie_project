package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import backend.dbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import type.*;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class EntryController implements Initializable {
	
	@FXML private MenuButton Type_define;
	@FXML private MenuItem electric;
	@FXML private MenuItem water;
	@FXML private MenuItem paycheck;
	@FXML private MenuItem unearnedI;
	@FXML private MenuItem otherI;
	@FXML private MenuItem gas;
	@FXML private MenuItem groceries;
	@FXML private MenuItem transportation;
	@FXML private MenuItem luxuries;
	@FXML private MenuItem internet;
	@FXML private MenuItem four01k;
	@FXML private MenuItem savings;
	@FXML private MenuItem housing;
	
	@FXML private TableView<Type> Entry_table;
	@FXML private TableColumn<Type, LocalDate> Date_Col;
	@FXML private TableColumn<Type, String> Amount_Col;
	@FXML private TableColumn<Type, String> Type_Col;
	
	@FXML private Button addItem_btn;
	
	@FXML private TextField addDate;
	@FXML private TextField addAmount;
	
	@FXML private Button closeButton;
	
	private ObservableList<Type> tableData = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		Date_Col.setCellValueFactory(new PropertyValueFactory<Type, LocalDate>("Date"));
		Amount_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Amount"));
		Type_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Type"));
		
    }
	
	public void enterEntry(ActionEvent action) {
		
		Float amount = addAmount.getText();
		LocalDate date = stringToDate(addDate.getText());
		String type = Type_define.getText();
		
		Type newEntry = new Type(date, amount, type);
		
		tableData.add(newEntry);
		Entry_table.setItems(tableData);
		
		addAmount.setText(" ");
		addDate.setText(" ");
		Type_define.setText("Type");
		
	}
	
	public void closeScene(ActionEvent action) throws SQLException {
		// connect to database
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "", "" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		for( int i = 0; i < tableData.size(); i++) {
			// switch statements to add the data to the database
			if( tableData.get(i).getType().equals("Electric Bill") ) {
				// Enter the data into the database for tableData.get(i)
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				int j = rs.getInt( "id" );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Electric Company" );
				ps.setString( 5, "electric" );
			}
			else if( tableData.get(i).getType().equals("Water Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				int j = rs.getInt( "id" );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Water Company" );
				ps.setString( 5, "water" );
			}
			else if( tableData.get(i).getType().equals("Paycheck") ) {
				
			}
			else if( tableData.get(i).getType().equals("Unearned Income") ) {
				
			}
			else if( tableData.get(i).getType().equals("Other Income") ) {
				
			}
			else if( tableData.get(i).getType().equals("Gas Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				int j = rs.getInt( "id" );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Gas Company" );
				ps.setString( 5, "gas" );
			}
			else if( tableData.get(i).getType().equals("Groceries") ) {
				
			}
			else if( tableData.get(i).getType().equals("Transportation") ) {
				
			}
			else if( tableData.get(i).getType().equals("Luxuries") ) {
				
			}
			else if( tableData.get(i).getType().equals("Internet Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				int j = rs.getInt( "id" );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Internet Company" );
				ps.setString( 5, "internet" );
			}
			else if( tableData.get(i).getType().equals("401K") ) {
				
			}
			else if( tableData.get(i).getType().equals("Savings") ) {
				
			}
			else if( tableData.get(i).getType().equals("Housing Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				int j = rs.getInt( "id" );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Housing Company" );
				ps.setString( 5, "housing" );
			}
		}
		
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
		
	}
	
	private LocalDate stringToDate(String userInput) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/MM/yyyy");
		return LocalDate.parse(userInput, dateFormat);
	}
	
	public void addElectricType(ActionEvent action) {
		Type_define.setText(electric.getText());
	}
	
	public void addWaterType(ActionEvent action) {
		Type_define.setText(water.getText());
	}
	
	public void addPaycheckType(ActionEvent action) {
		Type_define.setText(paycheck.getText());
	}
	
	public void addUnearnedIType(ActionEvent action) {
		Type_define.setText(unearnedI.getText());
	}
	
	public void addOtherIType(ActionEvent action) {
		Type_define.setText(otherI.getText());
	}
	
	public void addGasType(ActionEvent action) {
		Type_define.setText(gas.getText());
	}
	
	public void addGroceriesType(ActionEvent action) {
		Type_define.setText(groceries.getText());
	}
	
	public void addTransportType(ActionEvent action) {
		Type_define.setText(transportation.getText());
	}
	
	public void addLuxuryType(ActionEvent action) {
		Type_define.setText(luxuries.getText());
	}
	
	public void addInternetType(ActionEvent action) {
		Type_define.setText(internet.getText());
	}
	
	public void add401kType(ActionEvent action) {
		Type_define.setText(four01k.getText());
	}
	
	public void addSavingsType(ActionEvent action) {
		Type_define.setText(savings.getText());
	}
	
	public void addHousingType(ActionEvent action) {
		Type_define.setText(housing.getText());
	}
}
