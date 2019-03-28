package userInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
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
import javafx.stage.Stage;

public class loginController implements Initializable {
	
	@FXML Button log_in;
	@FXML TextField username;
	@FXML PasswordField password;
	@FXML Button new_acc;
	
	public void initialize(URL url, ResourceBundle rb){
		username.setPromptText("Username");
		password.setPromptText("Password");
		File file = new File("src/userInterface/AccountNumber.txt");
	}
	
	public void logIn(ActionEvent event) throws IOException, SQLException {
		
		// authenticate user and password
		dbConnect db = new dbConnect( );
		Connection conn = db.connect( "sjshilts", "sJSdbPass10" );
		PreparedStatement ps = null;
		ResultSet rs = null;
		String stmt;
		String dbPassword = "";
		String passWord = password.getText();
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
		
		// open new scene
		Parent root = FXMLLoader.load((getClass().getResource("userInterface.fxml")));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("My Money Management...");
		stage.getIcons().add(new Image("/images/cookie_icon.png"));
		stage.setScene(scene);
		stage.show();
		
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
		
	    // close login screen and close database connection
		Stage stageClose = (Stage) log_in.getScene().getWindow();
		stageClose.close();
		conn.close();
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

}
