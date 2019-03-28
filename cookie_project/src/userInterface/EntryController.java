package userInterface;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import backend.dbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
	@FXML private Button deleteBttn;
	
	private ObservableList<Type> tableData = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		Date_Col.setCellValueFactory(new PropertyValueFactory<Type, LocalDate>("Date"));
		Amount_Col.setCellValueFactory(new PropertyValueFactory<Type, Float>("Amount"));
		Type_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Type"));
		addAmount.requestFocus();
		addDate.setPromptText("DD/MM/YYYY");
		
		//System.out.println( getAccnum() );
		
		
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
	public void deleteEntry(ActionEvent action) {
		Type selectedItem = Entry_table.getSelectionModel().getSelectedItem();
		Entry_table.getItems().remove(selectedItem);
	}
	
	public void closeScene(ActionEvent action) throws SQLException {
		// connect to database
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "sJSdbPass10" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		for( int i = 0; i < tableData.size(); i++ ) {
			System.out.println(i);
			// switch statements to add the data to the database
			if( tableData.get(i).getType().equals("Electric Bill") ) {
				// Enter the data into the database for tableData.get(i)
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "electric" );													//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Electric Company" );											//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Water Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "water" );														//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Water Company" );												//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Paycheck") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "paycheck" );													//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Lowe's" );													//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Unearned Income") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "unearned income" );											//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Governemt" );													//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Other Income") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "other income" );												//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "EBay" );														//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Gas Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "gas" )			;											//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "UPPCO" );														//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Groceries") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "groceries" );													//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Meijer's" );													//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Transportation") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "transportation" );											//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Electric Company" );											//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Luxuries") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "luxuries" );													//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Yacht" );														//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Internet Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "internet" );													//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Internet Company" );											//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("401K") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "401k" );														//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "BANK NAME" );													//set who
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Savings") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "Savings" );													//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "BANK NAME SAVINGS" );											//set who 
				ps.executeUpdate();
			}
			else if( tableData.get(i).getType().equals("Housing Bill") ) {
				Date date = Date.valueOf( tableData.get(i).getDate() );
				String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
				ps = conn.prepareStatement( stmt );
				ps.setInt( 1, getAccnum() );													//set account number
				ps.setString( 2, "housing" );													//set type
				ps.setDate( 3, date );															//set date
				ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
				ps.setString( 5, "Housing Company" );											//set who
				ps.executeUpdate();
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
	
	private int getAccnum() {
		Stage sc = (Stage)Entry_table.getScene().getWindow();
		return Integer.parseInt(sc.getTitle());
	}
}
