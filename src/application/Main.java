package application;

import java.io.File;

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

	 public static void loadStudent(String... information) {
		 //directory
		 String DataStudent = "data/Student.txt";
		 try {
			 //create new file
	            File f = new File(DataStudent);
	         //if file exists
	            if (f.createNewFile() || f.isFile()) {
	            	//get object student
	            	Student student = new Student(information);
	            	//write this student on the file (in lex. order)
	            	dataAnalyzer.loadStudent(f, student);
	            }
	            else System.err.println("Error with creating file");
	     }
	     catch (Exception e) {
	            System.err.println(e);
	     }

	 }

	 public static void loadTeacher(String... information) {

	 }
}
