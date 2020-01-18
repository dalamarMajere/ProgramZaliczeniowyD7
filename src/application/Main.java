package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	  * STUDENT
	  */

	 private static final String DataStudent = "data/Student.txt";

	 public static void loadStudent(String... information) {

		 Student student = new Student(information);
		 loadObject(DataStudent, student.toString());
		 String facultyFolder = FolderFaculty + "/" + student.getFaculty();
		 loadObject(facultyFolder + "/" + "Student.txt", student.toString());
		 String courseFolder = facultyFolder + "/Courses/" + student.getCourse();
		 loadObject(courseFolder + "/" + "Student.txt", student.toString());
	 }

	 public static ArrayList<String> searchStudent(String criterium) throws IOException{
		ArrayList filter = dataAnalyzer.filterFile(new File(DataStudent),criterium);
		return filter;
	 }

	 /*
	  * TEACHER
	  */

	 private static final String DataTeacher = "data/Teacher.txt";

	 public static void loadTeacher(String... information) {}

	 public static String searchTeacher(String criterium){
		 return null;
	 }

	 /*
	  * FACULTY
	  */

	 private static final String FolderFaculty = "data/Faculties";
	 private static final String DataFaculty = "data/Faculty.txt";

	 public static void loadFaculty(String... information) {

		 Faculty faculty = new Faculty(information);
		 try {
         	File f = new File(DataFaculty);
         	if (f.createNewFile() || f.isFile())
         	{
         		dataAnalyzer.loadUnit(f, faculty.toString().split(";"));
         		createFacultyFolder();
         	}
         	else System.err.println("Error with creating file");
  		}
  		catch (Exception e) {
        	System.err.println(e);
  		}
	 }

	 public static ArrayList<String> getAllFaculties() throws IOException {
		 return getAll(DataFaculty);
	 }

	 private static void createFacultyFolder() throws FileNotFoundException {
		 createFolders(FolderFaculty, DataFaculty);
	 }

	 public static ArrayList<String> searchFaculty(String criterium) throws IOException{
		ArrayList<String> filter = dataAnalyzer.filterFile(new File(DataFaculty),criterium);
		return filter;
	 }

	/*
	 * COURSE
	*/
	 public static void loadCourse(String... inf) {

		 CourseOfStudy course = new CourseOfStudy(inf[0], inf[1]);
		 String faculty = inf[2];

		 String path = FolderFaculty + "/" + faculty + "/" + "Course.txt";

		 try {
	            File f = new File(path);
	            if (f.createNewFile() || f.isFile()) {
	            	dataAnalyzer.loadUnit(f, course.toString().split(";"));
	            	createCourseFolder(faculty);
	            }
	            else System.err.println("Error with creating file");
	     }
	     catch (Exception e) {
	            System.err.println(e);
	     }
	 }

	 public static ArrayList<String> getAllFacultyCourses(String faculty) throws IOException {
		 return getAll(FolderFaculty + "/" + faculty + "/Course.txt");
	 }

	 public static ArrayList<String> getAllCourses(String faculty) throws IOException {

		 ArrayList<String> faculties = getAllFaculties();
		 ArrayList<String> allcourses = new ArrayList<String>();

		 for(int i = 0;i< faculties.size();i++){
			 ArrayList<String> facultyCourses = getAllFacultyCourses(faculties.get(i));
			 allcourses.addAll(facultyCourses);
		 }

		 return faculties;
	 }

	 private static void createCourseFolder(String faculty) throws FileNotFoundException {
		 String path = FolderFaculty + "/" + faculty;
		 createFolders(path + "/Courses", path + "/Course.txt");
	 }

	 public static ArrayList<String> searchCourse(String criterium) throws IOException{
		 ArrayList<String> allFaculties = getAllFaculties();
		 ArrayList<String> filtered= new ArrayList<String>();
		 for(int i=0;i<allFaculties.size();i++){
			 String faculty = allFaculties.get(i);
			 ArrayList<String> courses=dataAnalyzer.filterFile(new File(FolderFaculty+"/"+allFaculties.get(i)+"/Course.txt"),criterium);

			 for(int j = 0; j<courses.size();j++ ){
				 if(!courses.get(j).isEmpty()){
					 courses.set(j,courses.get(j).concat(faculty));
				 }
				 filtered.add(courses.get(j));
			 }
		 }
		return filtered;
	 }

	/*
	* SUBJECT
	*/

	 private static final String DataSubject = "data/Subject.txt";

	 public static void loadSubject(String... information) {
		 Subject subject = new Subject(information);

	 }

	 /*
	  * OTHER METHODS
	  */

	 private static ArrayList<String> getAll(String path) throws IOException {

		 File f = new File(path);
		 String[] dataWithGarbage = dataAnalyzer.readFile(f).split("\r\n");
		 if (f.exists() && dataWithGarbage.length > 0
				 && !dataWithGarbage[0].equals("")) {

			ArrayList<String> data = new ArrayList<>();
			for (String i: dataWithGarbage)
				data.add(i.split(";")[1]);
			return data;
		 }
		 return new ArrayList<>();
	 }

	 private static void createFolders(String folderPath,
			 			String txtPath) throws FileNotFoundException {

		 createFolder(folderPath);

		 File f = new File(txtPath);
		 Scanner in = new Scanner(f);

		 String tmp;

		 while (in.hasNextLine()) {

			 tmp = in.nextLine().split(";")[1];
			 createFolder(folderPath + "/" + tmp);
		 }
		 in.close();
	 }

	 private static void createFolder(String path) throws FileNotFoundException {

		 File f = new File(path);
		 f.mkdir();
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
}
