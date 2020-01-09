package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
		try {
			studentFacultyChoiceBox.setItems(FXCollections.
					observableList(Main.getAllFaculties()));
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		    public void studentAddButtonAction() {

		    	String id = studentIdLabel.getText();
		        String surname = studentSurnameLabel.getText();
		        String name = studentNameLabel.getText();
		        String secondName = studentSecondNameLabel.getText();
		        String birthDate = studentBirthDateLabel.getText();
		        String faculty = "Fac";//studentFacultyChoiceBox.getValue();
		        String course = "Cour";//studentCourseChoiceBox.getValue();
		        String semester = studentSemesterLabel.getText();
		        Main.loadStudent(id, surname, name, secondName, birthDate,
		        		faculty, course, semester);
		    }


		    public void studentSearchButtonAction() throws IOException {
		    	System.out.println("Searching students with criterium: "+studentCryteriumLabel.getText());
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
	    public ChoiceBox<?> subjectFacultyChoiceBox;


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

		    	String faculty = (String)courseFacultyChoiceBox.getSelectionModel().getSelectedItem();
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
		    }


		    public void facultySearchButtonAction() {

		    }

}