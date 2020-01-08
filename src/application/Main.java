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
	        primaryStage.setScene(new Scene(root, 1000, 850));
	        primaryStage.show();
	 }

	 public static void loadObject(String path, String information) {

		 try {
	            File f = new File(path);
	            if (f.createNewFile() || f.isFile())
	            	dataAnalyzer.loadObject(f, information);
	            else System.err.println("Error with creating file");
	     }
	     catch (Exception e) {
	            System.err.println(e);
	     }
	 }

	 public static void loadStudent(String... information) {

		 Student student = new Student(information);
		 loadObject(DataStudent, student.toString());
	 }

	 public static void loadTeacher(String... information) {

		 //Teacher teacher = new Teacher(information);
		 //loadObject(DataTeacher, teacher.toString())
	 }

	 private static final String DataStudent = "data/Student.txt";
	 private static final String DataFaculty = "data/Faculty.txt";
	 private static final String DataTeacher = "data/Teacher.txt";


}
