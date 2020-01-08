package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


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

	 /*
	  * PERSON, STUDENT, TEACHER
	  */
	 private static final String DataStudent = "data/Student.txt";
	 private static final String DataFaculty = "data/Faculty.txt";
	 private static final String DataTeacher = "data/Teacher.txt";

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

	 public static String searchStudent(String criterium) throws IOException{
		String filter = dataAnalyzer.filterFile(new File(DataStudent),criterium);

		return filter;
	 }

	 public static void loadTeacher(String... information) {

		 //Teacher teacher = new Teacher(information);
		 //loadObject(DataTeacher, teacher.toString())
	 }

<<<<<<< HEAD
	 public static void searchTeacher(String criterium){

	 }

	 private static void createFacultyFolder() throws FileNotFoundException {

		 createFolder(FolderFaculty);

		 File f = new File(DataFaculty);
		 Scanner in = new Scanner(f);

		 String tmp;

		 while (in.hasNextLine()) {
=======
	 /*
	  * FACULTY, COURSE, SUBJECT
	  */
>>>>>>> a4a70a69f7f9c4f80811af6769540b622ee7319e

	 private static final String FolderFaculty = "data/Faculties";

	 public static void loadFaculty(String... information) {

		 Faculty faculty = new Faculty(information);
		 try {
         	File f = new File(DataFaculty);
         	if (f.createNewFile() || f.isFile())
         	{
         		dataAnalyzer.loadFaculty(f, faculty.toString().split(";"));
         		createFacultyFolder();
         	}
         	else System.err.println("Error with creating file");
  		}
  		catch (Exception e) {
        	System.err.println(e);
  		}
	 }
	 public static void searchFaculty(String criterium){

	 }

	 public static void loadCourse() {

	 }

<<<<<<< HEAD
	 public static void searchCourse(String criterium){

	 }


	 private static final String DataStudent = "data/Student.txt";
	 private static final String DataFaculty = "data/Faculty.txt";
	 private static final String DataTeacher = "data/Teacher.txt";
=======
	 public static void loadSubject(String... inf) {
>>>>>>> a4a70a69f7f9c4f80811af6769540b622ee7319e

		 CourseOfStudy course = new CourseOfStudy(inf[0], inf[1]);
	 }

	 private static void createFacultyFolder() throws FileNotFoundException {

		 createFolder(FolderFaculty);

		 File f = new File(DataFaculty);
		 Scanner in = new Scanner(f);

		 String tmp;

		 while (in.hasNextLine()) {

			 tmp = in.nextLine().split(";")[1];
			 createFolder(FolderFaculty + "\\" + tmp);
		 }
		 in.close();
	 }

	 private static void createFolder(String path) throws FileNotFoundException {

		 File f = new File(path);
		 f.mkdir();
	 }
}
