package userInterface;

import javafx.event.ActionEvent;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import backend.dbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
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

public class NewAccountController implements Initializable{

	@FXML TextField username;
	@FXML PasswordField password;
	@FXML PasswordField passwordVerify;
	@FXML TextField email;
	@FXML TextField firstName;
	@FXML TextField lastName;
	@FXML TextField initBal;
	@FXML Button newAccountBttn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void createNewAccount(ActionEvent event) throws SQLException {
		
		// create db connection
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "sJSdbPass10" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		String stmt;
		float bal;
		
		// Check if a field is empty
		if(username.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a username");
			errorAlert.showAndWait();
			return;
		}
		else if(username.getText().length() > 8 ) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Username must be less than 8 characters");
			errorAlert.showAndWait();
			return;
		}
		else if(password.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a password");
			errorAlert.showAndWait();
			return;
		}
		else if(password.getText().length() > 20 ) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Password must be less than 20 characters");
			errorAlert.showAndWait();
			return;
		}
		else if(!passwordVerify.getText().equals(password.getText())) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Password does not match verified password");
			errorAlert.showAndWait();
			return;
		}
		else if(email.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter an email");
			errorAlert.showAndWait();
			return;
		}
		else if(firstName.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a first name");
			errorAlert.showAndWait();
			return;
		}
		else if(lastName.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a last name");
			errorAlert.showAndWait();
			return;
		}
		else if(initBal.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a balance");
			errorAlert.showAndWait();
			return;
		}
		
		stmt = "SELECT username FROM Users";
		ps = conn.prepareStatement( stmt );
		rs = ps.executeQuery();
		while ( rs.next() ) {
			if(rs.getString("username").equals(username.getText())) {
				Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setHeaderText("Username already taken");
				errorAlert.showAndWait();
				return;
			}
		}
		
		try{
			bal = Float.parseFloat(initBal.getText());
			} catch(NumberFormatException e) {
				Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setHeaderText("Please enter a balance");
				errorAlert.showAndWait();
				return;
			}
		
		// input data into database
		stmt = "INSERT INTO Users (username, password, firstname, lastname, InitBalance, email) VALUES ( ?, ?, ?, ?, ?, ? )";
		ps = conn.prepareStatement( stmt );
		ps.setString( 1, username.getText() );									//set username
		ps.setString( 2, hashFunction( username.getText(), password.getText() ) );		//set password
		ps.setString( 3, firstName.getText());									//set first name
		ps.setString( 4, lastName.getText() );									//set last name
		ps.setFloat( 5, bal );													// set initial balance
		ps.setString( 6, email.getText() );
		ps.executeUpdate();
		
		// close scene
		conn.close();
		Stage stageClose = (Stage) newAccountBttn.getScene().getWindow();
		stageClose.close();
		
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
