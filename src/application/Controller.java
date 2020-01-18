package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

	 /*
	 * Initialize is the method that runs right when when window shows up. Sort of like a constructor.
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */

	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("View is now loaded!");
		loadChoiceBox();
	}

	private void loadChoiceBox() {
		ObservableList<String> list = getFaculty();

		studentFacultyChoiceBox.setItems(list);
		courseFacultyChoiceBox.setItems(list);
		subjectFacultyChoiceBox.setItems(list);

		studentFacultyChoiceBox.getSelectionModel().selectedItemProperty().
			addListener(new ChangeListener<String>() {
				public void changed(ObservableValue<? extends String> observable,
	                    String oldValue, String newValue) {
	                if (newValue != null) {
	                    studentCourseChoiceBox.setItems(
	                    		getCourse(studentFacultyChoiceBox.getValue()));
	                }
	            }
	        });

		subjectFacultyChoiceBox.getSelectionModel().selectedItemProperty().
			addListener(new ChangeListener<String>() {
				public void changed(ObservableValue<? extends String> observable,
	                    String oldValue, String newValue) {
	                if (newValue != null) {
	                    subjectCourseChoiceBox.setItems(
	                    		getCourse(subjectFacultyChoiceBox.getValue()));
	                }
	            }
        });
	}


	private ObservableList<String> getCourse(String faculty) {
		try {
				ArrayList<String> list = Main.getAllCourses(faculty);
				if (!list.isEmpty()) return FXCollections.observableList(list);
		}
		catch (IOException e) {e.printStackTrace();}
		return FXCollections.observableArrayList();
	 }

	private ObservableList<String> getFaculty() {
		try {
			ArrayList<String> list = Main.getAllFaculties();
			if (!list.isEmpty()) return FXCollections.observableList(list);
		}
		catch (IOException e) {e.printStackTrace();}
		return FXCollections.observableArrayList();
	 }

	/*
	* STUDENT
	*/

	public TextField studentCryteriumLabel;
	public TextArea studentTextArea;
	public TextField studentIdLabel;
	public TextField studentSurnameLabel;
	public TextField studentNameLabel;
	public TextField studentSecondNameLabel;
	public TextField studentBirthDateLabel;
	public ChoiceBox<String> studentFacultyChoiceBox;
	public ChoiceBox<String> studentCourseChoiceBox;
	public TextField studentSemesterLabel;

	/*
	* ADD STUDENT
	*/

	public void studentAddButtonAction() {
		String id = studentIdLabel.getText();
		String surname = studentSurnameLabel.getText();
		String name = studentNameLabel.getText();
		String secondName = studentSecondNameLabel.getText();
		String birthDate = studentBirthDateLabel.getText();
		String faculty = studentFacultyChoiceBox.getValue();
		String course = studentCourseChoiceBox.getValue();
		String semester = studentSemesterLabel.getText();

		Main.loadStudent(id, surname, name, secondName, birthDate,
					faculty, course, semester);
	}

	public void studentFacultyChosen() {
		System.out.println("Here");
		studentCourseChoiceBox.setItems(getCourse(
				 			studentFacultyChoiceBox.getValue()));
	 }

	/*
	* STUDENT SEARCH
	*/

	public void studentSearchButtonAction() throws IOException {
		System.out.println("Searching students with criterium: "+
									studentCryteriumLabel.getText());

		ArrayList<String> filteredStudents = Main.searchStudent(studentCryteriumLabel.getText());
		String filter="";
		for(int i = 0 ; i < filteredStudents.size() ; i++ ){
    		filter = filter.concat(filteredStudents.get(i))+"\n";
    	}
		studentTextArea.setText(filter);
	}

	/*
	 * TEACHER
	*/

	public TextField employeeCryteriumLabel;
	public TextArea employeeTextArea;
	public TextField employeeIdLabel;
	public TextField employeeTitleLabel;
	public TextField employeeSurnameLabel;
	public TextField employeeNameLabel;
	public TextField employeeBirthDate;

	/*
	* ADD TEACHER
	*/

    public void employeeAddButtonAction() {

    }

	/*
	* SEARCH TEACHER
	*/

    public void employeeSearchButtonAction() {

    }

	/*
	 * SUBJECT
	*/

	public TextField subjectCryteriumLabel;
	public TextArea subjectTextArea;
	public TextField subjectNameLabel;
	public ChoiceBox<String> subjectFacultyChoiceBox;
	public ChoiceBox<String> subjectCourseChoiceBox;

	/*
	 * ADD SUBJECT
	*/

    public void subjectAddButtonAction() {
    	String name = subjectNameLabel.getText();
    	String faculty = subjectFacultyChoiceBox.getValue();
    	String course = subjectCourseChoiceBox.getValue();
    	Main.loadSubject(name, faculty, course);
    }

    /*
	 * SEARCH SUBJECT
	*/

    public void subjectSearchButtonAction() {

    }

	/*
	* COURSE
	*/

    public TextField courseCriteriumLabel;
    public TextArea courseTextArea;
    public TextField courseIdLabel;
    public TextField courseNameLabel;
    public ChoiceBox<String> courseFacultyChoiceBox;

    /*
	 * ADD COURSE
	*/

    public void courseAddButtonAction() {

    	String faculty = courseFacultyChoiceBox.getValue();
    	String id = courseIdLabel.getText();
    	String name = courseNameLabel.getText();
    	if(!faculty.isEmpty() && !id.isEmpty() && !name.isEmpty())
    	Main.loadCourse(id, name, faculty);

    	courseFacultyChoiceBox.setValue(null);
    	courseIdLabel.setText("");
    	courseNameLabel.setText("");
    }

    /*
	 * SEARCH COURSE
	*/

    public void courseSearchButtonAction() throws IOException {
    	ArrayList<String> filteredCourses = Main.searchCourse(courseCriteriumLabel.getText());
    	String filter="";
    	System.out.println("Searching courses with criterium: "+
    			courseCriteriumLabel.getText());
    	for(int i = 0 ; i < filteredCourses.size() ; i++ ){
    		filter = filter.concat(filteredCourses.get(i))+"\n";
    	}
    	courseTextArea.setText(filter);
    }

	/*
	* FACULTY
	*/

    public TextField facultyCriteriumLabel;
    public TextArea facultyTextArea;
    public TextField facultyIdLabel;
    public TextField facultyNameLabel;

    /*
	* ADD FACULTY
	*/

    public void facultyAddButtonAction() throws IOException {

    	String id = facultyIdLabel.getText();
        String name = facultyNameLabel.getText();
        Main.loadFaculty(id, name);

        facultyNameLabel.setText("");
        facultyIdLabel.setText("");

        loadChoiceBox();
    }

    /*
	* SEARCH FACULTY
	*/

    public void facultySearchButtonAction() throws IOException {
    	ArrayList<String> filteredFaculties = Main.searchFaculty(facultyCriteriumLabel.getText());
    	String filter="";
		for(int i = 0 ; i < filteredFaculties.size() ; i++ ){
    		filter = filter.concat(filteredFaculties.get(i))+"\n";
    	}
    	facultyTextArea.setText(filter);
    }

}