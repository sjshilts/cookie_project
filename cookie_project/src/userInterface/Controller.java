package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import backend.GetData;
import backend.TotalAmounts;
import backend.dbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;

public class Controller implements Initializable{
	
	@FXML PieChart outflowPieChart;
	
	@FXML PieChart inflowPieChart;
	
	@FXML Label account_amount;
	@FXML Button Entry;
	@FXML Button logOutBttn;
	@FXML Button userSettingsBttn;
	
	@FXML TextField new_user;
	@FXML TextField new_email;
	@FXML TextField new_initBal;
	
	@FXML PasswordField old_pass;
	@FXML PasswordField new_pass;
	
	@FXML ImageView MoneyIcon;
	
	@FXML Label personalMessage;
	
	@FXML private AreaChart<?,?> costSpending;
	@FXML private CategoryAxis time;
	@FXML private NumberAxis amounts;
	
	@FXML private TableView<Table> spending_table;
	@FXML private TableColumn<Table, Integer> percent_col_s;
	@FXML private TableColumn<Table, Double> amount_col_s;
	@FXML private TableColumn<Table, String> type_col_s;
	
	@FXML private TableView<Table> income_table;
	@FXML private TableColumn<Table, Integer> percent_col_i;
	@FXML private TableColumn<Table, Double> amount_col_i;
	@FXML private TableColumn<Table, String> type_col_i;
	
	/*
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public void initialize(URL url, ResourceBundle rb){
		
		 ObservableList<PieChart.Data> in = FXCollections.observableArrayList();
		 ObservableList<PieChart.Data> out = FXCollections.observableArrayList();
		 String numberAsString = null;
		 
		 percent_col_s.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Percent"));
		 amount_col_s.setCellValueFactory(new PropertyValueFactory<Table, Double>("Amount"));
		 type_col_s.setCellValueFactory(new PropertyValueFactory<Table, String>("Type"));
		 
		 percent_col_i.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Percent"));
		 amount_col_i.setCellValueFactory(new PropertyValueFactory<Table, Double>("Amount"));
		 type_col_i.setCellValueFactory(new PropertyValueFactory<Table, String>("Type"));
			
		 XYChart.Series dataIncome = null;
		 XYChart.Series dataSpending = null;
		 TotalAmounts total = null;
		 
		 // Display a personalized message to users
		 dbConnect dab = new dbConnect( );
		 String username = "";
			Connection conn;
			try {
				conn = dab.connect( "sjshilts", "sJSdbPass10" );
				PreparedStatement ps = null;
				ResultSet rs = null;
				String stmt = "SELECT firstname FROM Users WHERE Accnum = ?";
				ps = conn.prepareStatement( stmt );
				ps.setString( 1, Integer.toString( getAccNum() ) );
				rs = ps.executeQuery();
				rs.next();
				username = rs.getString("firstname");
				conn.close();
			} catch (SQLException | IOException e1) {
				e1.printStackTrace();
			}
			personalMessage.setText("Welcome "+ username);
		 
		// Import the users data into the graphics
		 try{
			total = new TotalAmounts();
			in = DataInterface.InflowPieChartData(total);
			out = DataInterface.OutflowPieChartData(total);
			
			GetData db = new GetData("sjshilts","sJSdbPass10");
			dataIncome = DataInterface.setInflowChartData(db.getInflow(), total, LocalDate.now() );
			dataSpending = DataInterface.setOutflowChartData(db.getOutflow(), total, LocalDate.now());
			db.closeConn();
			
			spending_table.setItems( DataInterface.tableDataOutflow( total ));
			income_table.setItems( DataInterface.tableDataInflow( total ));
			
			numberAsString = String.format ("%.2f", total.getTotal());
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		 // Set the users data in the GUI
        costSpending.getData().add(dataIncome);
        costSpending.getData().add(dataSpending);
        outflowPieChart.setData(out);
        inflowPieChart.setData(in);
        account_amount.setText(numberAsString);
        

    }
	
	/*
	 * Opens the window for the user to enter past transactions
	 * @param event - button click ActionEvent
	 */
	public void newEntry(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("dataEntry.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Data Entry");
		stage.getIcons().add(new Image("/images/cookie_icon.png"));
		stage.setScene(scene);
		stage.show();
		Stage stageClose = (Stage) Entry.getScene().getWindow();
		stageClose.close();
		
		stage.setOnCloseRequest(e -> stageClose.show() );
	}
	
	public void logOut(ActionEvent event) throws IOException {
		
		Stage stageClose = (Stage) logOutBttn.getScene().getWindow();
		stageClose.close();
		File file = new File("src/userInterface/AccountNumber.txt");
		file.delete();
		
		Parent root = FXMLLoader.load((getClass().getResource("loginScreen.fxml")));
		Scene scene = new Scene(root);
		Stage stageNew = new Stage();
		stageNew.setTitle("My Money Monitor");
		stageNew.getIcons().add(new Image("/images/cookie_icon.png"));
		stageNew.setScene(scene);
		stageNew.show();
		
	}

	/*
	 * Implementation of user settings. Allows the user to change their username, password,
	 * email, and initial balance.
	 * @param event - button click ActionEvent
	 * 
	 */
	public void userSettingsChanges(ActionEvent event) throws IOException, SQLException {
		
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "sJSdbPass10" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		String stmt;
		int accNum = getAccNum();
		
		// new username
		if( !new_user.getText().equals("") ) {
			stmt ="UPDATE Users SET username = ? WHERE Accnum = ?";
			ps = conn.prepareStatement( stmt );
			
			ps.setString( 1, new_user.getText() );
			ps.setString( 2, Integer.toString( accNum ) );
			ps.executeUpdate();
			
			stmt ="UPDATE Users SET password = ? WHERE Accnum = ?";
			ps = conn.prepareStatement( stmt );
			
			ps.setString( 1, hashFunction( new_user.getText(), new_pass.getText() ) );
			ps.setString( 2, Integer.toString( accNum ) );
			ps.executeUpdate();
			new_user.setText("");
		}
		
		// get username
		stmt ="SELECT username FROM Users WHERE Accnum = ?";
		ps = conn.prepareStatement( stmt );
		ps.setString( 1, Integer.toString( accNum ) );
		rs = ps.executeQuery();
		rs.next();
		String username = rs.getString("username");
		
		//new password
		if( !new_pass.getText().equals("") ) {
			stmt ="UPDATE Users SET password = ? WHERE Accnum = ?";
			ps = conn.prepareStatement( stmt );
			
			ps.setString( 1, hashFunction( username, new_pass.getText() ) );
			ps.setString( 2, Integer.toString( accNum ) );
			ps.executeUpdate();
			new_pass.setText("");
		}
		
		// new email
		if( !new_email.getText().equals("") ) {
			stmt ="UPDATE Users SET email = ? WHERE accnum = ?";
			ps = conn.prepareStatement( stmt );
			
			ps.setString( 1, new_email.getText() );
			ps.setString( 2, Integer.toString( accNum ) );
			ps.executeUpdate();
			new_email.setText("");
		}

		// new initial balance
		if (!new_initBal.getText().equals("")) {
			
			// Attempt to make the balance from text to a float
			try {
				float bal = Float.parseFloat(new_initBal.getText());
				
				stmt = "UPDATE Users SET InitBalance = ? WHERE accnum = ?";
				ps = conn.prepareStatement(stmt);
				ps.setString(1, Float.toString(bal));
				ps.setString(2, Integer.toString(accNum));
				ps.executeUpdate();
				new_initBal.setText("");
				
			} catch (NumberFormatException e) {
				Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setHeaderText("Please enter a balance");
				errorAlert.showAndWait();
				return;
			}
			
		}
		conn.close();
	}
	
	/*
	 * Allows the users to delete their account. Logs the user out once the action is complete
	 * @param event - button click ActionEvent
	 */
	public void deleteAcc(ActionEvent event) throws IOException, SQLException {
		
		// display a popup asking if the user is sure they want to delete their account
		Alert checkAlert = new Alert(AlertType.CONFIRMATION);
		checkAlert.setHeaderText("Are you sure you want to delete your account?");
		
		
		Optional<ButtonType> result = checkAlert.showAndWait();
		// delete account of Ok is pressed
		if ( result.isPresent() && result.get() == ButtonType.OK ) {
			dbConnect db = new dbConnect();
			Connection conn = db.connect("sjshilts", "sJSdbPass10");
			PreparedStatement ps = null;
			ResultSet rs = null;
			String stmt;

			stmt = "DELETE FROM Users WHERE Accnum = ?";
			ps = conn.prepareStatement(stmt);
			ps.setString(1, Integer.toString(getAccNum()));
			ps.executeUpdate();
			
			conn.close();
			
			Stage stageClose = (Stage) logOutBttn.getScene().getWindow();
			stageClose.close();
			File file = new File("src/userInterface/AccountNumber.txt");
			file.delete();
			
			Parent root = FXMLLoader.load((getClass().getResource("loginScreen.fxml")));
			Scene scene = new Scene(root);
			Stage stageNew = new Stage();
			stageNew.setTitle("My Money Monitor");
			stageNew.getIcons().add(new Image("/images/cookie_icon.png"));
			stageNew.setScene(scene);
			stageNew.show();
			
		} else {
			return;
		}
		
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
	
	/**
	 * 
	 * Takes a string and encrypts it
	 * @param user
	 * @param pass
	 * @return encrypted string
	 */
	private String hashFunction( String user, String pass ) {
		String salty = salt( user, pass );
		String hash = null;
		try {
			
			// Construct using SHA-256
			MessageDigest md = MessageDigest.getInstance( "SHA-256" );
			
			// Puts the string into bytes
			byte[] digestedMessage = md.digest( salty.getBytes() );
			BigInteger bi = new BigInteger( 1, digestedMessage );
			
			// badda boom badda bing, make it a string
			hash = bi.toString( 16 );
			while ( hash.length() < 32 ) {
				hash = "0" + hash;
			}
		} catch ( NoSuchAlgorithmException e ){
			e.printStackTrace();
		}
		return hash;
	}
	
	/**
	 * 
	 * salts a string with another string
	 * @param s1
	 * @param s2
	 * @return salted string
	 */
	private String salt( String s1, String s2 ) {
		String newString = null;
		// if the strings are of same size, put them together
		if ( s2.length() == s1.length() ) {
			for ( int i = 0; i < s1.length(); i++ ) {
				newString = newString + s2.substring( i, i+1 ) + s1.substring( i, i+1 );
			}
		// otherwise we gotta pad either of the strings with a's and z's
		} else {
			int diff = 0;
			if ( s2.length() > s1.length() ) {
				diff = s2.length() - s1.length();
				for ( int i = 0; i < diff; i++ ) {
					s1 = s1 + "z";
				}
			} else {
				diff = s1.length() - s2.length();
				for ( int i = 0; i < diff; i++ ) {
					s2 = s2 + "a";
				}
			}
			// put the padded string and regular string together
			for ( int i = 0; i < s1.length(); i++ ) {
				newString = newString + s2.substring( i, i+1 ) + s1.substring( i, i+1 );
			}
		}
		return newString;
	}

}
