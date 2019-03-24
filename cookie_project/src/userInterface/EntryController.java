package userInterface;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import backend.dbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	@FXML private TableColumn<Type, Float> Amount_Col;
	@FXML private TableColumn<Type, String> Type_Col;
	
	@FXML private Button addItem_btn; 
	
	@FXML private TextField addDate;
	@FXML private TextField addAmount;
	
	@FXML private Button closeButton;
	
	private ObservableList<Type> tableData = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		Date_Col.setCellValueFactory(new PropertyValueFactory<Type, LocalDate>("Date"));
		Amount_Col.setCellValueFactory(new PropertyValueFactory<Type, Float>("Amount"));
		Type_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Type"));
		
    }
	
	public void enterEntry(ActionEvent action) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		Float amount = Float.valueOf(addAmount.getText());
		LocalDate date = LocalDate.parse(addDate.getText(), dateFormat);
		String type = Type_define.getText();
		
		Type newEntry = new Type(date, amount, type);
		
		tableData.add(newEntry);
		Entry_table.setItems(tableData);
		
		addAmount.setText("");
		addDate.setText("");
		Type_define.setText("Type");
		
	}
	
	public void closeScene(ActionEvent action) throws SQLException {
		// connect to database
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "sJSdbPass10" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		for( int i = 0; i < tableData.size(); i++) {
			System.out.println(i);
			// switch statements to add the data to the database
			if( tableData.get(i).getType().equals("Electric Bill") ) {
				// Enter the data into the database for tableData.get(i)
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";		//pull account amount from database
				ps = conn.prepareStatement( bal );													//prepare statement
				rs = ps.executeQuery();																//execute statement and move into a result set
				rs.next();
				Float f = rs.getFloat( "balance" );													//move the result into a variable
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );																//set date
				ps.setFloat( 2, tableData.get( i ).getAmount() );									//set amount
				ps.setString( 3, "out" );															//set in/out to out
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );								//set balance
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";			//select the id from our latest entry
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );															//get id
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";			//insert data into bill
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
				rs.next();
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
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Water Company" );
				ps.setString( 5, "water" );
			}
			else if( tableData.get(i).getType().equals("Paycheck") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "in" );
				ps.setDouble( 4, f + tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Paycheck ( id, date, amount, who ) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Water Company" );
			}
			else if( tableData.get(i).getType().equals("Unearned Income") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "in" );
				ps.setFloat( 4, f + tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Unearned_Income ( id, date, amount, who ) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Water Company" );
			}
			else if( tableData.get(i).getType().equals("Other Income") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "in" );
				ps.setFloat( 4, f + tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Other ( id, date, amount, who ) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Water Company" );
			}
			else if( tableData.get(i).getType().equals("Gas Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Gas Company" );
				ps.setString( 5, "gas" );
			}
			else if( tableData.get(i).getType().equals("Groceries") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Internet Company" );
				ps.setString( 5, "internet" );
			}
			else if( tableData.get(i).getType().equals("Transportation") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Cost_Of_Living ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Speedway" );
				ps.setString( 5, "gas" );
			}
			else if( tableData.get(i).getType().equals("Luxuries") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Luxury ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Luxurious Company" );
				ps.setString( 5, "corn" );
			}
			else if( tableData.get(i).getType().equals("Internet Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Bills ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Internet Company" );
				ps.setString( 5, "internet" );
			}
			else if( tableData.get(i).getType().equals("401K") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Savings ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "401k Company" );
				ps.setString( 5, "401k" );
			}
			else if( tableData.get(i).getType().equals("Savings") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
				String stmt2 = "INSERT INTO Savings ( id, date, amount, who, subtype ) VALUES ( ?, ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt2 );
				ps.setInt( 1,  j );
				ps.setDate( 2, date );
				ps.setFloat( 3, tableData.get( i ).getAmount() );
				ps.setString( 4, "Savings Account" );
				ps.setString( 5, "savings" );
			}
			else if( tableData.get(i).getType().equals("Housing Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String bal = "SELECT balance FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( bal );
				rs = ps.executeQuery();
				rs.next();
				Float f = rs.getFloat( "balance" );
				System.out.println( "The balance is: " + f );
				String stmt = "INSERT INTO Account_Main_Table (date, amount, in_out, balance) VALUES ( ?, ?, ?, ? )";
				ps = conn.prepareStatement( stmt );
				ps.setDate( 1, date );
				ps.setFloat( 2, tableData.get( i ).getAmount() );
				ps.setString( 3, "out" );
				ps.setFloat( 4, f - tableData.get( i ).getAmount() );
				String id = "SELECT id FROM Account_Main_Table ORDER BY id DESC LIMIT 1";
				ps = conn.prepareStatement( id );
				rs = ps.executeQuery();
				rs.next();
				int j = rs.getInt( "id" );
				System.out.println( "The ID is: " + j );
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
