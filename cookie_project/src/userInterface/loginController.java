package userInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import backend.dbConnect;

import java.io.File;
import java.io.FileOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class loginController implements Initializable {
	
	@FXML Button log_in;
	@FXML TextField username;
	@FXML PasswordField password;
	@FXML Button new_acc;
	
	public void initialize(URL url, ResourceBundle rb){
		username.setPromptText("Username");
		password.setPromptText("Password");
	}
	
	public void logIn(ActionEvent event) throws IOException, SQLException {
		
		// authenticate user and password
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "sJSdbPass10" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		String stmt;
		String dbPassword = "";
		String passWord1 = password.getText();
		String passWord = hashFunction( username.getText(), passWord1 );
		try {
		stmt = "SELECT password FROM Users WHERE username ='" + username.getText() + "'";
		ps = conn.prepareStatement( stmt );
		rs = ps.executeQuery();
		rs.next();
		dbPassword = rs.getString("password");
		}
		catch (SQLException e) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Incorrect username, password combination");
			errorAlert.showAndWait();
			return;
		}
		
		if(!passWord.equals(dbPassword)){
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Incorrect username, password combination");
			errorAlert.showAndWait();
			return;
		}
		
		// save account number
		stmt = "SELECT Accnum FROM Users WHERE username ='" + username.getText() + "'";
		ps = conn.prepareStatement( stmt );
		rs = ps.executeQuery();
		rs.next();
		String accNum = rs.getString("Accnum");
		OutputStream targetStream = new FileOutputStream("src/userInterface/AccountNumber.txt");
		byte[] b = accNum.getBytes();
		targetStream.write(b);
		targetStream.close();
		
		// open new scene
		Parent root = FXMLLoader.load((getClass().getResource("userInterface.fxml")));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("My Money Monitoring");
		stage.getIcons().add(new Image("/images/cookie_icon.png"));
		stage.setScene(scene);
		stage.show();
		File file = new File("src/userInterface/AccountNumber.txt");
		stage.setOnCloseRequest(e -> file.delete());
		
	    // close login screen and close database connection
		Stage stageClose = (Stage) log_in.getScene().getWindow();
		stageClose.close();
		conn.close();
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
	
	public void newAccount(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("NewAccount.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("New Account");
		stage.getIcons().add(new Image("/images/cookie_icon.png"));
		stage.setScene(scene);
		stage.show();
	}
	
	public void logIn2(KeyEvent event) throws IOException, SQLException {

		if (event.getCode() == KeyCode.ENTER) {
			// authenticate user and password
			dbConnect db = new dbConnect();
			Connection conn = db.connect("sjshilts", "sJSdbPass10");
			PreparedStatement ps = null;
			ResultSet rs = null;
			String stmt;
			String dbPassword = "";
			String passWord1 = password.getText();
			String passWord = hashFunction(username.getText(), passWord1);
			try {
				stmt = "SELECT password FROM Users WHERE username ='" + username.getText() + "'";
				ps = conn.prepareStatement(stmt);
				rs = ps.executeQuery();
				rs.next();
				dbPassword = rs.getString("password");
			} catch (SQLException e) {
				Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setHeaderText("Incorrect username, password combination");
				errorAlert.showAndWait();
				return;
			}

			if (!passWord.equals(dbPassword)) {
				Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setHeaderText("Incorrect username, password combination");
				errorAlert.showAndWait();
				return;
			}

			// save account number
			stmt = "SELECT Accnum FROM Users WHERE username ='" + username.getText() + "'";
			ps = conn.prepareStatement(stmt);
			rs = ps.executeQuery();
			rs.next();
			String accNum = rs.getString("Accnum");
			OutputStream targetStream = new FileOutputStream("src/userInterface/AccountNumber.txt");
			byte[] b = accNum.getBytes();
			targetStream.write(b);
			targetStream.close();

			// open new scene
			Parent root = FXMLLoader.load((getClass().getResource("userInterface.fxml")));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("My Money Monitor");
			stage.getIcons().add(new Image("/images/cookie_icon.png"));
			stage.setScene(scene);
			stage.show();
			File file = new File("src/userInterface/AccountNumber.txt");
			stage.setOnCloseRequest(e -> file.delete());

			// close login screen and close database connection
			Stage stageClose = (Stage) log_in.getScene().getWindow();
			stageClose.close();
			conn.close();
		} else {
			return;
		}
	}

}
