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
		// TODO Auto-generated method stub
		
	}
	
	public void createNewAccount(ActionEvent event) {
		// Check if a field is empty
		
		
		// input data into database
		
		// close scene
		Stage stageClose = (Stage) newAccountBttn.getScene().getWindow();
		stageClose.close();
		
	}

}
