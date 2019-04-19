package userInterface;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
    @Override
    public void start(Stage primaryStage) throws Exception{
    	File file = new File("src/userInterface/AccountNumber.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        primaryStage.setTitle("My Money Monitor"); 
        primaryStage.setScene(new Scene(root, 485, 612.0000999999975));
        primaryStage.getIcons().add(new Image("/images/cookie_icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show(); 
    }


    /*
     * Launch the program
     */
    public static void main(String[] args) {
        launch(args);
    }
}
