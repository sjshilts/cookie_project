package userInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.File;
import java.io.FileOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	String accNum;
	
	public void initialize(URL url, ResourceBundle rb){
		username.setPromptText("Username");
		password.setPromptText("Password");
		accNum = "12345";
		
	}
	
	public void logIn(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load((getClass().getResource("userInterface.fxml")));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("My Money Management...");
		stage.getIcons().add(new Image("/images/cookie_icon.png"));
		stage.setScene(scene);
		stage.show();	
		
	    OutputStream targetStream = new FileOutputStream("src/userInterface/AccountNumber.txt");
	    byte[] b = accNum.getBytes();
	    targetStream.write(b);
	    targetStream.close();
		
		Stage stageClose = (Stage) log_in.getScene().getWindow();
		stageClose.close();
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
