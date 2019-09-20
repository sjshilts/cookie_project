package userInterface;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.dbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


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
	@FXML private TableColumn<Type, String> Who_Col;
	
	@FXML private Button addItem_btn; 
	
	@FXML private TextField addDate;
	@FXML private TextField addAmount; 
	@FXML private TextField Description;
	
	@FXML private Button closeButton;
	@FXML private Button deleteBttn;
	
	private ObservableList<Type> tableData = FXCollections.observableArrayList();
	
	/*
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb){
		Date_Col.setCellValueFactory(new PropertyValueFactory<Type, LocalDate>("Date"));
		Amount_Col.setCellValueFactory(new PropertyValueFactory<Type, Float>("Amount"));
		Type_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Type"));
		Who_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Who"));
		addDate.setPromptText("MM/DD/YYYY");		
    }
	
	/*
	 * Enter the new entry
	 */
	public void enterEntry(ActionEvent action) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		if(addDate.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a valid date");
			errorAlert.showAndWait();
			return;
		}
		else if(Type_define.getText().equals("Type")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please select a type");
			errorAlert.showAndWait();
			return;
		}
		else if(addAmount.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter an amount");
			errorAlert.showAndWait();
			return;
		}
		LocalDate date;
		try {
			date = LocalDate.parse(addDate.getText(), dateFormat);
		} catch(DateTimeParseException e) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a valid date");
			errorAlert.showAndWait();
			return;
		}
		String type = Type_define.getText();
		String who = Description.getText();
		
		LocalDate currentDate = LocalDate.now();
		if( Date.valueOf(date).after(Date.valueOf(currentDate)) ) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a valid date");
			errorAlert.showAndWait();
			return;
		}
		
		Float amount;
		try{
			amount = Float.valueOf(addAmount.getText());
			} catch(NumberFormatException e) {
				Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setHeaderText("Please enter a valid amount");
				errorAlert.showAndWait();
				return;
			}
		
		Type newEntry = new Type(date, amount, type, who);
		
		tableData.add(newEntry);
		Entry_table.setItems(tableData);
		
		addAmount.setText("");
		addDate.setText("");
		Description.setText("");
		Type_define.setText("Type");
		
	}
	
	/*
	 * Delete the highlighted entry 
	 */
	public void deleteEntry(ActionEvent action) {
		Type selectedItem = Entry_table.getSelectionModel().getSelectedItem();
		Entry_table.getItems().remove(selectedItem);
	}
	
	/*
	 * Upload all of the entered entries into the database
	 */
	public void closeScene(ActionEvent action) throws SQLException, IOException {
		// connect to database
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "sJSdbPass10" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		for( int i = 0; i < tableData.size(); i++ ) {
			// switch statements to add the data to the database
			if( tableData.get(i).getType().equals("Electric Bill") ) {
				enterData( "electric", i );
			}
			else if( tableData.get(i).getType().equals("Water Bill") ) {
				enterData( "water", i );
			}
			else if( tableData.get(i).getType().equals("Paycheck") ) {
				enterData( "paycheck", i );
			}
			else if( tableData.get(i).getType().equals("Unearned Income") ) {
				enterData( "unearned income", i );
			}
			else if( tableData.get(i).getType().equals("Other Income") ) {
				enterData( "other income", i );
			}
			else if( tableData.get(i).getType().equals("Gas Bill") ) {
				enterData( "gas", i );
			}
			else if( tableData.get(i).getType().equals("Groceries") ) {
				enterData( "groceries", i );
			}
			else if( tableData.get(i).getType().equals("Transportation") ) {
				enterData( "transportation", i );
			}
			else if( tableData.get(i).getType().equals("Luxuries") ) {
				enterData( "luxuries", i );
			}
			else if( tableData.get(i).getType().equals("Internet Bill") ) {
				enterData( "internet", i );
			}
			else if( tableData.get(i).getType().equals("401K") ) {
				enterData( "401k", i );
			}
			else if( tableData.get(i).getType().equals("Savings") ) {
				enterData( "savings", i );
			}
			else if( tableData.get(i).getType().equals("Housing Bill") ) {
				enterData( "housing", i );
			}
		}
		
		Parent root = FXMLLoader.load((getClass().getResource("userInterface.fxml")));
		Scene scene = new Scene(root);
		Stage stageNew = new Stage();
		stageNew.setTitle("My Money Monitor");
		stageNew.getIcons().add(new Image("/images/cookie_icon.png"));
		stageNew.setScene(scene);
		stageNew.show();
		
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
		
	}
	
	/*
	 * Set the type to electric
	 */
	public void addElectricType(ActionEvent action) {
		Type_define.setText(electric.getText());
	}
	
	/*
	 * 
	 */
	public void enterData( String input, int i ) throws SQLException, IOException {
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "P@ssw0rd" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date date = Date.valueOf( tableData.get(i).getDate() );
		String stmt = "INSERT INTO Transaction (Accnum, type, date, amount, who) VALUES ( ?, ?, ?, ?, ? )";	//insert data
		ps = conn.prepareStatement( stmt );
		ps.setInt( 1, getAccnum() );													//set account number
		ps.setString( 2, "housing" );													//set type
		ps.setDate( 3, date );															//set date
		ps.setFloat( 4, tableData.get( i ).getAmount() );								//set amount
		ps.setString( 5, tableData.get(i).getWho() );									//set who
		ps.executeUpdate();
	}
	
	/*
	 * Set the type to water
	 */
	public void addWaterType(ActionEvent action) {
		Type_define.setText(water.getText());
	}
	
	/*
	 * Set the type to paycheck
	 */
	public void addPaycheckType(ActionEvent action) {
		Type_define.setText(paycheck.getText());
	}
	
	/*
	 * Set the type to unearned income
	 */
	public void addUnearnedIType(ActionEvent action) {
		Type_define.setText(unearnedI.getText());
	}
	
	/*
	 * Set the type to other income
	 */
	public void addOtherIType(ActionEvent action) {
		Type_define.setText(otherI.getText());
	}
	
	/*
	 * Set the type to gas
	 */
	public void addGasType(ActionEvent action) {
		Type_define.setText(gas.getText());
	}
	
	/*
	 * Set the type to groceries
	 */
	public void addGroceriesType(ActionEvent action) {
		Type_define.setText(groceries.getText());
	}
	
	/*
	 * Set the type to transportation
	 */
	public void addTransportType(ActionEvent action) {
		Type_define.setText(transportation.getText());
	}
	
	/*
	 * Set the type to luxury
	 */
	public void addLuxuryType(ActionEvent action) {
		Type_define.setText(luxuries.getText());
	}
	
	/*
	 * Set the type to Internet
	 */
	public void addInternetType(ActionEvent action) {
		Type_define.setText(internet.getText());
	}
	
	/*
	 * Set the type to 401k
	 */
	public void add401kType(ActionEvent action) {
		Type_define.setText(four01k.getText());
	}
	
	/*
	 * Set the type to savings
	 */
	public void addSavingsType(ActionEvent action) {
		Type_define.setText(savings.getText());
	}
	
	/*
	 * Set the type to housing
	 */
	public void addHousingType(ActionEvent action) {
		Type_define.setText(housing.getText());
	}
	
	/*
	 * Gets the account number
	 */
	private int getAccnum() throws IOException {
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
