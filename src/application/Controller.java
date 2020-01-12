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

	public VBox vbox;

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

	public void studentFacultyChoisen() {
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
		String filteredStudents = Main.searchStudent(studentCryteriumLabel.getText());
		studentTextArea.setText(filteredStudents);
	}

	    /*
	     * EMPLOYEE
	     */

	public TextField employeeCryteriumLabel;
	public TextArea employeeTextArea;
	public TextField employeeIdLabel;
	public TextField employeeTitleLabel;
	public TextField employeeSurnameLabel;
	public TextField employeeNameLabel;
	public TextField employeeBirthDate;

    public void employeeAddButtonAction() {

    }


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


    public void subjectAddButtonAction() {

    }


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

    public void courseAddButtonAction() {

    	String faculty = courseFacultyChoiceBox.getValue();
    	String id = courseIdLabel.getText();
    	String name = courseNameLabel.getText();
    	Main.loadCourse(id, name, faculty);
    }


    public void courseSearchButtonAction() {

    }

	    /*
	     * FACULTY
	     */

    public TextField facultyCriteriumLabel;
    public TextArea facultyTextArea;
    public TextField facultyIdLabel;
    public TextField facultyNameLabel;

    public void facultyAddButtonAction() throws IOException {

    	String id = facultyIdLabel.getText();
        String name = facultyNameLabel.getText();
        Main.loadFaculty(id, name);

        loadChoiceBox();
    }


    public void facultySearchButtonAction() {

    }

}