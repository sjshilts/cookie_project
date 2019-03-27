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
		else if(password.getText().equals("")) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Please enter a password");
			errorAlert.showAndWait();
			return;
		}
		else if(!passwordVerify.getText().equals(password.getText())) {
			Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Password does not match verified password");
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
		try{
			bal = Float.parseFloat(initBal.getText()) - 1;
			} catch(NumberFormatException e) {
				Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setHeaderText("Please enter a balance");
				errorAlert.showAndWait();
				return;
			}
		
		// input data into database
		stmt = "INSERT INTO Users (username, password, firstname, lastname, InitBalance) VALUES ( ?, ?, ?, ?, ? )";
		ps = conn.prepareStatement( stmt );
		ps.setString( 1, username.getText() );									//set username
		ps.setString( 2, passwordVerify.getText() );							//set password
		ps.setString( 3, firstName.getText());									//set first name
		ps.setString( 4, lastName.getText() );									//set last name
		ps.setFloat( 5, bal );													// set initial balance
		ps.executeUpdate();
		
		// close scene
		conn.close();
		Stage stageClose = (Stage) newAccountBttn.getScene().getWindow();
		stageClose.close();
		
	}

}
