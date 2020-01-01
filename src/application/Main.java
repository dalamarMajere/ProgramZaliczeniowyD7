package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	 public void start(Stage primaryStage) throws Exception{
	        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
	        primaryStage.setTitle("USOSWEB Editor");
	        primaryStage.setScene(new Scene(root, 1000, 800));
	        primaryStage.show();
	    }
}
