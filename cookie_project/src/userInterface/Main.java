package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("userInterface.fxml"));
        primaryStage.setTitle("MMM...");
        primaryStage.setScene(new Scene(root, 1025.0000999999975, 768.0000999999975));
        primaryStage.getIcons().add(new Image("/images/cookie_icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
